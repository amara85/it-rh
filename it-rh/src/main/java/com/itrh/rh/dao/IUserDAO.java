package com.itrh.rh.dao;

import java.util.List;

import com.itrh.rh.model.User;

public interface IUserDAO {
	
	
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
    public User getUserByUsername(String login) ;
 
    /**
     * Get User List
     *
     */
    public List<User> getUsers();
    
    /**
     * Get User List
     *
     */
    
    public List<User> getUserByUserId(int selectedUserid);
}