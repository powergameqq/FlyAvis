package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bill;
@Repository("findBillDAO")
public class BillDAO implements Dao<Bill> {
	@Autowired
	SessionFactory factory;

	public BillDAO() {
//		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Integer save(Bill bill) {
		Integer i = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			i = (int) session.save(bill);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public Bill load(int pk) {
		Bill bill = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			bill = (Bill) session.load(Bill.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return bill;
	}

	@Override
	public Bill get(int pk) {
		Bill bill = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			bill =  (Bill) session.get(Bill.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return bill;
	}

	@Override
	public void update(Bill t) {
		Bill bill = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			bill = (Bill) session.get(Bill.class, t.getCostId());
			bill.setCostTittle(t.getCostTittle());
			bill.setMemberId(t.getMemberId());
			bill.setIfTrafficCost(t.getIfTrafficCost());
			bill.setCostDate(t.getCostDate());
			bill.setCategory(t.getCategory());
			bill.setSinglePayer(t.getSinglePayer());
			bill.setSingleCost(t.getSingleCost());
			session.update(bill);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(int pk) {
		Bill bill = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			bill = (Bill) session.get(Bill.class, pk);
			session.delete(bill);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bill> selectByHQL(String f) {
		List<Bill> billList = new ArrayList<>();
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			billList = session.createQuery("FROM PlanDetail where planId = :pid").setParameter("pid", f).list();
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return billList;
	}
	
	public int getCostFromOnePlan(int planId) {
		Session session = factory.getCurrentSession();
		int totalCost = 0;
		try {
			totalCost = ((Number)session.createQuery("select sum(singleCost) FROM PlanDetail where planId = :pid and ifTrafficCost = null").setParameter("pid", planId).uniqueResult()).intValue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return totalCost;
	}
}
