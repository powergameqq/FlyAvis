package services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import model.Bill;
import model.BudgetAndCost;
import model.MyTrip;
import model.PlanDetail;
import model.TeamMember;
import model.ToDoList;
import model.dao.BillDAO;
import model.dao.Dao;
import model.dao.MemberDAO;
import model.dao.MyTripDAO;
import model.dao.PlanDetailDAO;
import model.dao.TeamMemberDAO;
import model.dao.ToDoListDAO;

@Transactional
@Service
public class TripService {
	@Autowired
	MemberDAO memDao;
	@Autowired
	MyTripDAO tripDao;
	@Autowired
	BillDAO billDao;
	@Autowired
	PlanDetailDAO planDao;
	@Autowired
	TeamMemberDAO teamDao;
	@Autowired
	ToDoListDAO toDoDao;
	@Autowired
	WebApplicationContext ctx;
	public List<MyTrip> getTripsFromUserId(int userId) {
		List<MyTrip> tripList = null;
		tripList = tripDao.selectByHQL("" + userId);
		for (MyTrip mt : tripList) {
			Hibernate.initialize(mt);
		}
		return tripList;
	}
	
	public List<TeamMember> getTripTeamMember(int tripId) {
		List<TeamMember> tmList = null;
		tmList = teamDao.selectByHQL("" + tripId);
		for (TeamMember tm : tmList) {
			Hibernate.initialize(tm);
		}
		return tmList;
	}

	public List<PlanDetail> getDetail(int tripId) {
		List<PlanDetail> detailList = null;
		detailList = planDao.selectByHQL("" + tripId);
		for (PlanDetail detail : detailList) {
			Hibernate.initialize(detail);
			for(ToDoList tdl:detail.getToDoList()) {
				Hibernate.initialize(tdl);
			}
			for(Bill bill:detail.getBill()) {
				Hibernate.initialize(bill);
			}
		}
		return detailList;
	}

	public List<MyTrip> getPopularTripTopFive() {
		List<MyTrip> tripList = null;
		List<MyTrip> tripTopFive = new ArrayList<>();
		tripList = tripDao.getPopularTrip();
		for (int i = 0; i < tripList.size(); i++) {
			tripTopFive.add(tripList.get(i));
		}
		for (MyTrip mt : tripTopFive) {
			Hibernate.initialize(mt);
		}
		return tripTopFive;
	}

	public List<MyTrip> getNewTripEight(int times) {
		List<MyTrip> tripList = null;
		List<MyTrip> tripEight = new ArrayList<>();
		tripList = tripDao.getNewTrip();
		if (times * 8 < tripList.size()) {
			for (int i = ((times - 1) * 8); i < (times * 8); i++) {
				tripEight.add(tripList.get(i));
			}
		} else {
			for (int i = ((times - 1) * 8); i < tripList.size(); i++) {
				tripEight.add(tripList.get(i));
			}
		}
		for (MyTrip mt : tripEight) {
			Hibernate.initialize(mt);
		}
		return tripEight;
	}

	public List<BudgetAndCost> getBudgetAndCostList(int tripId) {
		List<BudgetAndCost> bcList = new ArrayList<>();
		List<PlanDetail> planList = null;
		int totalCost;
		planList = planDao.selectByHQL("" + tripId);
		for (int i = 0; i < planList.size(); i++) {
			totalCost = 0;
			totalCost = billDao.getCostFromOnePlan(planList.get(i).getPlanId());
			bcList.add(new BudgetAndCost(planList.get(i).getSpotName(), planList.get(i).getSpotCost(), totalCost));
		}
		return bcList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> int create(T t) {
		Dao dao = (Dao) ctx.getBean("find" + t.getClass().getSimpleName() + "DAO");
		return dao.save(t);
	}

	@SuppressWarnings({ "rawtypes" })
	public <T> void delete(T t, int pk) {
		Dao dao = (Dao) ctx.getBean("find" + t.getClass().getSimpleName() + "DAO");
		dao.delete(pk);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> void update(T t) {
		Dao dao = (Dao) ctx.getBean("find" + t.getClass().getSimpleName() + "DAO");
		dao.update(t);
	}

}
