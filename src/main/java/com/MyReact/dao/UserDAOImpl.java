package com.MyReact.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.MyReact.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManger;

	/**
	 * EntityManger用法参考： https://stackoverflow.com/questions/43533691/required-a-bean-of-type-org-hibernate-sessionfactory-that-could-not-be-found/43537578
	 */
	@Override
	public User getUser(int id) {
		return entityManger.find(User.class, id);
	}

	@Override
	public User getUserbyName(String userName) {
		TypedQuery<User> result = entityManger.createQuery("select e from User e where userName=?", User.class);
		result.setParameter(0, userName);
		try {
			return result.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User getUserbyEmail(String userEmail) {
		TypedQuery<User> result = entityManger.createQuery("select e from User e where userEmail=?", User.class);
		result.setParameter(1, userEmail);
		return result.getSingleResult();
	}

	@Override
	public void addUser(User user) {
		entityManger.persist(user);
	}

}
