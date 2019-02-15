package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Member;
@Repository("findMemberDAO")
public class MemberDAO implements Dao<Member> {
	@Autowired
	SessionFactory factory;

	public MemberDAO() {
//		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Integer save(Member mem) {
		Integer i = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			i = (int)session.save(mem);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public Member load(int pk) {
		Member mem = null;
		Session session = factory.getCurrentSession();
//		Transaction tx =null;
		try {
//			tx = session.beginTransaction();
			mem = (Member) session.load(Member.class, pk);
//			tx.commit();
		} catch(Exception e){
//			if (tx != null) tx.rollback();
			System.out.println(e.getMessage());
		}
		return mem;
	}

	@Override
	public Member get(int pk) {
		Member mem = null;
		Session session = factory.getCurrentSession();
//		Transaction tx =null;
		try {
//			tx = session.beginTransaction();
			mem = (Member) session.get(Member.class, pk);
//			tx.commit();
		} catch(Exception e){
//			if (tx != null) tx.rollback();
			System.out.println(e.getMessage());
		}
		return mem;
	}

	@Override
	public void update(Member t) {
		Member mem = null;
		Session session = factory.getCurrentSession();
//		Transaction tx =null;
		try {
//			tx = session.beginTransaction();
			mem = (Member) session.get(Member.class, t.getUserId());
			mem.setUserName(t.getUserName());
			mem.setUserPhoto(t.getUserPhoto());
			session.update(mem);
//			tx.commit();
		} catch(Exception e){
//			if (tx != null) tx.rollback();
			System.out.println(e.getMessage());
		}
		

	}

	@Override
	public void delete(int pk) {
		Member mem = null;
		Session session = factory.getCurrentSession();
//		Transaction tx =null;
		try {
//			tx = session.beginTransaction();
			mem = (Member) session.get(Member.class,pk);
			session.delete(mem);
//			tx.commit();
		} catch(Exception e){
//			if (tx != null) tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> selectByHQL(String f) {
		List<Member> memList = new ArrayList<>();
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			memList = session.createQuery("FROM Member where userToken = :token")
					.setParameter("token", f)			  
					.list();
//			tx.commit();
		} catch(Exception e){
//			if ( tx != null ) tx.rollback();
			System.out.println(e.getMessage());
		} 
		return memList;
	}

}
