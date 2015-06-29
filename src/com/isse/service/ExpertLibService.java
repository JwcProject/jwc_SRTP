/**
 * 
 */
package com.isse.service;

import java.util.List;

import com.isse.model.TExpertLib;
import com.isse.model.TExpertTeacher;
import com.isse.model.TTeacher;
import com.util.PageBean;

/**
 * @author ming
 *
 */
public interface ExpertLibService {
	public void creatExpertLib(TExpertLib tExpertLib, List<TExpertTeacher> tExpertTeacherList,String type);
	public List<TExpertLib> findExpsByUnitTeaCode(String teaCode,String type,PageBean pageBean);
	public int findExpsCountByUnitTeaCode(String teaCode,String type);
	public TExpertLib findNowJieQiExpLib(String type);
	public TExpertLib getById(String libId);
	
	//删除专家库以及该专家库中的专家教师
	public void deleteExperLib(TExpertLib tExpertLib);
	
	//更新专家库中的专家教师
	public void updateExperLib(TExpertLib tExpertLib, List<TExpertTeacher> expertTeacherList,String type);
}
