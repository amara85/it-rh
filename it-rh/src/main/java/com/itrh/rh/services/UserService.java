package com.itrh.rh.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itrh.rh.dao.IUserDAO;
import com.itrh.rh.model.User;


  
@Transactional(readOnly = true)
public class UserService implements IUserService {

	
	IUserDAO userDAO;
	
	@Transactional(readOnly = false)
    public void addUser(User user) {
		// TODO Auto-generated method stub
		 getUserDAO().addUser(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		  getUserDAO().updateUser(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		 getUserDAO().deleteUser(user);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		 return getUserDAO().getUserById(id);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		 return getUserDAO().getUsers();
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean login(String login, String pwd) {
		return getUserDAO().login(login,pwd);
	}

	public User getUserByLogin(String login) {
		// TODO Auto-generated method stub
		return getUserDAO().getUserByUsername(login);
	}

	public List<User> getUserByUserId(int selectedUserid) {
		// TODO Auto-generated method stub
		return getUserDAO().getUserByUserId(selectedUserid);
	}
	
}
