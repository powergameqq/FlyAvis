package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MyTrip;
@Repository("findMyTripDAO")
public class MyTripDAO implements Dao<MyTrip> {
	@Autowired
	SessionFactory factory;
	public MyTripDAO() {
//		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Integer save(MyTrip trip) {
		Integer i = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			i = (int) session.save(trip);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public MyTrip load(int pk) {
		MyTrip trip = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			trip = (MyTrip) session.load(MyTrip.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return trip;
	}

	@Override
	public MyTrip get(int pk) {
		MyTrip trip = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			trip =  (MyTrip) session.get(MyTrip.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return trip;
	}

	@Override
	public void update(MyTrip t) {
		MyTrip trip = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			trip = (MyTrip) session.get(MyTrip.class, t.getTripId());
			trip.setTripName(t.getTripName());
			trip.setTripDate(t.getTripDate());
			trip.setTripPrivate(t.getTripPrivate());
			trip.setCreatetime(t.getCreatetime());
			if(t.getTripPhoto() != null) {
			trip.setTripPhoto(t.getTripPhoto());}
			session.update(trip);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(int pk) {
		MyTrip trip = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			trip = (MyTrip) session.get(MyTrip.class, pk);
			session.delete(trip);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MyTrip> selectByHQL(String f) {
		List<MyTrip> tripList = new ArrayList<>();
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			tripList = session.createQuery("FROM MyTrip where userId = :uid").setParameter("uid", f).list();
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return tripList;
	}
	
	@SuppressWarnings("unchecked")
	public List<MyTrip> getPopularTrip(){
		List<MyTrip> tripList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		try {
			tripList = session.createQuery("FROM MyTrip order by tripLike desc").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tripList;
	}

	@SuppressWarnings("unchecked")
	public List<MyTrip> getNewTrip(){
		List<MyTrip> tripList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		try {
			tripList = session.createQuery("FROM MyTrip order by createtime desc").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tripList;
	}
}
