/**
 * 
 */
package com.isse.service;

import java.util.List;

import com.isse.model.TTeacher;
import com.isse.model.TUser;

/**
 * @author ming
 *
 */
public interface TeacherService {
	public List getTeachers(String teaCode);
	public List getCommonTeachers(String teaCode,String type);
	
    public void addTTeacher(TTeacher tTeacher);
    
    public TTeacher findTeacherByTeaCode(String teaCode);
    public void addUsers(TUser tUser);
}
