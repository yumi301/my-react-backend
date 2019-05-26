package com.MyReact.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyReact.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		
		tx.commit();
		return user;
	}
	
	@Override
	public User getUserbyName(String userName) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("userName", userName));
		List listusers = criteria.list();
		tx.commit();
		if(listusers.isEmpty()){
			return null;
		}
		return (User) listusers.get(0);
	}
	
	@Override
	public User getUserbyEmail(String userEmail) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("userEmail", userEmail));
		List listusers = criteria.list();
		tx.commit();
		if(listusers.isEmpty()){
			return null;
		}
		return (User) listusers.get(0);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
	     session.save(user);
			tx.commit();
	}

	

}
