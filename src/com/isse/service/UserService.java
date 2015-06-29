package com.isse.service;

import java.util.List;

import com.isse.model.TStudent;
import com.isse.model.TTeacher;
import com.isse.model.TUnit;
import com.isse.model.TUser;
import com.util.PageBean;


public interface UserService 
{
	public void addTUser(TUser user);
	public void updateTUser(TUser user);
	public void deleteTUser(String id);
	public TUser getTUser(String id);
	public List<TUser> getAllTUser(final PageBean pageBean);
	public int getAllTUserCount();
	
	public List<TUser> getTUserByMutiProperty(String userId, String userName, String userType, String userState,final PageBean pageBean);
	public int getTUserCountByMutiProperty(String userId, String userName, String userType, String userState);
	
	public TUser userLogin(String userId, String password);
	public TUnit getUnitByUserId(String userId, String userType);
	
	TStudent getStudentByUserId(String userId);
	TTeacher getTeacherByUserId(String userId);
	TUser changePassword(String userId, String password);
	TUser changeLoginState(String userId, String state);
}
