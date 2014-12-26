package com.itrh.rh.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.springframework.dao.DataAccessException;

import com.itrh.rh.model.User;
import com.itrh.rh.services.IUserService;
import com.itrh.rh.util.Util;

@ManagedBean(name = "userMB")
@SessionScoped
public class UserManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2752278168549956155L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private String destination = "C:/workspace/it-rh/src/main/webapp/images/users/";

	@ManagedProperty(value = "#{UserService}")
	IUserService userService;


	private String  username;
	private String  password;
	private String  description;
	private int  enabled;

	List<User> userList;

	/**
	 * Add User
	 * 
	 * @return String - Response Message
	 */

	boolean local_login_result = false;
	private User loggedUser;
	
	
	
	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public String login() {
		local_login_result = false;
		local_login_result = getUserService().login(username, password);

		if (local_login_result) {
			loggedUser = getUserService().getUserByLogin(username);
			HttpSession session = Util.getSession();
			session.setAttribute("loggedUser", loggedUser);
			return "home.xhtml?faces-redirect=true";
		 }
			
			else {
			FacesContext.getCurrentInstance().addMessage(
					"msgs",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur!",
							"Verifiez votre login et mot de passe!"));
			return "error";
		}
		
	}

	public void welcomeMessage() {
		if (local_login_result)
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue !",
							"Vous avez un accès sur la totalité de système"));

	}

	public String loggedUserUsername() {
		return loggedUser.getUsername();

	}

	public String logout() {
		System.out.println("logout action");
		HttpSession session = Util.getSession();
		session.invalidate();
		return "index.xhtml?faces-redirect=true";

	}


	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUserList() {
		System.out.println("alooooogetuserlist");
		System.out.println(selectedUserid);
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
		
		
	}

	/**
	 * Set User List
	 * 
	 * @param List
	 *            - User List
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/*------start master 30/09/2014   ----------*/
	private User selectedUser;

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	private int selectedUserid;

	public int getSelectedUserid() {
		return selectedUserid;
	}

	public void setSelectedUserid(int selectedUserid) {
		this.selectedUserid = selectedUserid;
	}


	/*------end  master 02/10/2014   ----------*/

	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination
					+ fileName));
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String showUserDetails(){
		System.out.println("===============showUserDetails==========");
		return "edit_users.xhtml?faces-redirect=true";
	}

}
