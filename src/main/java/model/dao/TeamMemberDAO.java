package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.TeamMember;
@Repository("findTeamMemberDAO")
public class TeamMemberDAO implements Dao<TeamMember> {
	@Autowired
	SessionFactory factory;

	public TeamMemberDAO() {
//		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Integer save(TeamMember tm) {
		Integer i = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			i = (int) session.save(tm);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public TeamMember load(int pk) {
		TeamMember tm = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			tm = (TeamMember) session.load(TeamMember.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return tm;
	}

	@Override
	public TeamMember get(int pk) {
		TeamMember tm = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			tm = (TeamMember) session.get(TeamMember.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return tm;
	}

	@Override
	public void update(TeamMember t) {
		TeamMember tm = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			tm = (TeamMember) session.get(TeamMember.class, t.getMemberId());
			tm.setUserId(t.getUserId());
			tm.setMemberName(t.getMemberName());
			tm.setTeamName(t.getTeamName());
		
			session.update(tm);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(int pk) {
		TeamMember tm = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			tm = (TeamMember) session.get(TeamMember.class, pk);
			session.delete(tm);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TeamMember> selectByHQL(String f) {
		List<TeamMember> teamMemberList = new ArrayList<>();
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			teamMemberList = session.createQuery("FROM TeamMember where tripId = :tid").setParameter("tid", f).list();
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return teamMemberList;
	}
}
