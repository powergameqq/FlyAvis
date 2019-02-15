package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.PlanDetail;
@Repository("findPlanDetailDAO")
public class PlanDetailDAO implements Dao<PlanDetail> {
	@Autowired
	SessionFactory factory;

	public PlanDetailDAO() {
//		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Integer save(PlanDetail pd) {
		Integer i = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			i = (int) session.save(pd);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public PlanDetail load(int pk) {
		PlanDetail pd = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			pd = (PlanDetail) session.load(PlanDetail.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return pd;
	}

	@Override
	public PlanDetail get(int pk) {
		PlanDetail pd = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			pd = (PlanDetail) session.get(PlanDetail.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return pd;
	}

	@Override
	public void update(PlanDetail t) {
		PlanDetail pd = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			pd = (PlanDetail) session.get(PlanDetail.class, t.getPlanId());
			pd.setPlanNum(t.getPlanNum());
			pd.setSpotName(t.getSpotName());
			pd.setSpotStartime(t.getSpotStartime());
			pd.setSpotEndtime(t.getSpotEndtime());
			pd.setPlanDay(t.getPlanDay());
			pd.setSpotCost(t.getSpotCost());
			pd.setSpotNotice(t.getSpotNotice());
			pd.setLongitude(t.getLongitude());
			pd.setLatitude(t.getLatitude());
			pd.setPlaceId(t.getPlaceId());
			pd.setSpotTraffic_fee(t.getSpotTraffic_fee());
			pd.setPlanB(t.getPlanB());
			session.update(pd);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(int pk) {
		PlanDetail pd = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			pd = (PlanDetail) session.get(PlanDetail.class, pk);
			session.delete(pd);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PlanDetail> selectByHQL(String f) {
		List<PlanDetail> planList = new ArrayList<>();
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			planList = session.createQuery("FROM PlanDetail where tripId = :tid group by planDay order by planNum").setParameter("tid", f).list();
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return planList;
	}

}
