package org.jsp.userspringapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.userspringapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
EntityManager manager;
	
public User saveUser(User user) {
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(user);
	transaction.begin();
	transaction.commit();
	return user;
}

public User updateUser(User user) {
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	transaction.commit();
	return user;
}
public User findUserById(int id) {
	return manager.find(User.class, id);
}

public User verifyUser(long phone, String password) {
	Query q=manager.createQuery("select u from User u where u.phone=?1 and u=password=?2");
	q.setParameter(1, phone);
	q.setParameter(2, password);
	try {
		return (User) q.getSingleResult();
	} catch (NoResultException e) {
		return null;
	}
}

public boolean deleteUser(int id) {
	User u=findUserById(id);
	if(u!=null) {
		manager.remove(u);
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
	return false;
}
}
