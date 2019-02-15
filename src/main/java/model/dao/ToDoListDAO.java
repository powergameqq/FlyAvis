package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.ToDoList;
@Repository("findToDoListDAO")
public class ToDoListDAO implements Dao<ToDoList> {
	@Autowired
	SessionFactory factory;

	public ToDoListDAO() {
//		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Integer save(ToDoList toDo) {
		Integer i = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			i = (int) session.save(toDo);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public ToDoList load(int pk) {
		ToDoList toDo = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			toDo = (ToDoList) session.load(ToDoList.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return toDo;
	}

	@Override
	public ToDoList get(int pk) {
		ToDoList toDo = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			toDo =  (ToDoList) session.get(ToDoList.class, pk);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return toDo;
	}

	@Override
	public void update(ToDoList t) {
		ToDoList toDo = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			toDo = (ToDoList) session.get(ToDoList.class, t.getToDoId());
			toDo.setToDoItem(t.getToDoItem());
			toDo.setDone(t.isDone());
			
			session.update(toDo);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(int pk) {
		ToDoList toDo = null;
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			toDo = (ToDoList) session.get(ToDoList.class, pk);
			session.delete(toDo);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ToDoList> selectByHQL(String f) {
		List<ToDoList> tdList = new ArrayList<>();
		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
			tdList = session.createQuery("FROM PlanDetail where planId = :pid").setParameter("pid", f).list();
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			System.out.println(e.getMessage());
		}
		return tdList;
	}
}
