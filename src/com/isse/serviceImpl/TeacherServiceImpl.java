/**
 * 
 */
package com.isse.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.isse.dao.TTeacherDAO;
import com.isse.dao.TUserDAO;
import com.isse.model.TTeacher;
import com.isse.model.TUser;
import com.isse.service.TeacherService;

/**
 * @author ming
 *
 */
public class TeacherServiceImpl implements TeacherService {

	private TTeacherDAO tTeacherDAO;
	private TUserDAO tUserDAO;

	public TTeacherDAO gettTeacherDAO() {
		return tTeacherDAO;
	}

	public void settTeacherDAO(TTeacherDAO tTeacherDAO) {
		this.tTeacherDAO = tTeacherDAO;
	}
	
	public TUserDAO gettUserDAO() {
		return tUserDAO;
	}

	public void settUserDAO(TUserDAO tUserDAO) {
		this.tUserDAO = tUserDAO;
	}

	public List getTeachers(String teaCode) {
		// TODO Auto-generated method stub
		return this.tTeacherDAO.getTeachers(teaCode);
	}
	
	public List getCommonTeachers(String teaCode,String type)
	{
		return this.tTeacherDAO.getCommonTeachers(teaCode, type);
	}
	
	public void addTTeacher(TTeacher tTeacher){
		this.tTeacherDAO.save(tTeacher);
	}
	
	public TTeacher findTeacherByTeaCode(String teaCode){
		List<TTeacher> teacherList  = this.tTeacherDAO.findTeacherByCode(teaCode);
		TTeacher teacher =null;
		if(teacherList.size()>0){
			teacher = teacherList.get(0);
		}
			return teacher;
	}

	@Override
	public void addUsers(TUser tUser) {
		this.tUserDAO.save(tUser);	
	}
	
	

}
