package com.itrh.rh.services;

import java.util.List;

import com.itrh.rh.model.User;

public interface IUserService {

	/**
     * Login User
     *
     * @param  User user
     */
    public boolean login(String login, String pwd);
	
    /**
     * Add User
     *
     * @param  User user
     */
    public void addUser(User user);
 
    /**
     * Update User
     *
     * @param  User user
     */
    public void updateUser(User user);
 
    /**
     * Delete User
     *
     * @param  User user
     */
    public void deleteUser(User user);
 
    /**
     * Get User
     *
     * @param  int User Id
     */
    public User getUserById(int id);
    
    /**
     * Get User
     *
     * @param  String User Login
     */   
    public User getUserByLogin(String login) ;
    
    /**
     * Get User List
     *
     * @return List - User list
     */
    public List<User> getUsers();
    
    /**
     * Get User List id
     *
     * @return List - User list by id
     */
    public List<User> getUserByUserId(int selectedUserid);
}
