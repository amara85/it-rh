package com.itrh.rh.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.itrh.rh.model.User;

public class UserDAO implements IUserDAO {
	
	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().update(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(user);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
	      @SuppressWarnings("unchecked")
		List<User> list = getSessionFactory().getCurrentSession()
                  .createQuery("from User where id_user=?")
                  .setParameter(0, id).list();
		return list.get(0);
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
	      @SuppressWarnings("unchecked")
		List<User> list = getSessionFactory().getCurrentSession()
                  .createQuery("from User where username=?")
                  .setParameter(0, username).list();
	      if(list.size()>0)
	     	return list.get(0);
	      else
	    	return null;
	}
	
	public List<User> getUsers() {
		// TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
		List<User> list = getSessionFactory().getCurrentSession().createQuery("from User").list();
        return list;
	}

	public boolean login(String username, String pwd) {
		// TODO Auto-generated method stub
		if((getUserByUsername(username)!=null)&&(getUserByUsername(username).getPassword().equals(pwd)))
		  return true;
		else
		  return false;
	}
	
	 public List<User> getUserByUserId(int selectedUserid) {
			// TODO Auto-generated method stub
	      @SuppressWarnings("unchecked")
		List<User> list = getSessionFactory().getCurrentSession()
                 .createQuery("from User where id_user=?")
                 .setParameter(0, selectedUserid).list();
	      if(list.size()>0)
	     	return list;
	      else
	    	return null;
	 }
	}
