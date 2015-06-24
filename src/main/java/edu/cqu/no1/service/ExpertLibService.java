package edu.cqu.no1.service;

import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface ExpertLibService {
	public void creatExpertLib(TExpertLib tExpertLib, List<TExpertTeacher> tExpertTeacherList, String type);
	public List<TExpertLib> findExpsByUnitTeaCode(String teaCode, String type, PageBean pageBean);
	public int findExpsCountByUnitTeaCode(String teaCode, String type);
	public TExpertLib findNowJieQiExpLib(String type);
	public TExpertLib getById(String libId);
	
	//删除专家库以及该专家库中的专家教师
	public void deleteExperLib(TExpertLib tExpertLib);
	
	//更新专家库中的专家教师
	public void updateExperLib(TExpertLib tExpertLib, List<TExpertTeacher> expertTeacherList, String type);
}
