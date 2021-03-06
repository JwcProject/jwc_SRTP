package edu.cqu.no1.service;

import edu.cqu.no1.domain.TDeclComment;
import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface ExpertTeacherService {
	public List<TExpertTeacher> getExpertTeachersByTeaCode(String teaCode, String type, PageBean pageBean);
	public int getExpertTeachersByTeaCodeCount(String teaCode, String type);
	public int findExpertTeachersCount(String teaCode, String teaName, String teaTitle, String type);
	public List<TExpertTeacher> findExpertTeachers(String teaCode, String teaName, String teaTitle, String type, PageBean pageBean);
	
	public List<TExpertTeacher> findExpertTeachersByJQid(String jqId);
	public void saveExpertTeacher(List<TExpertTeacher> tExpertTeacherList);
	
	public TExpertTeacher findExpTeaByCode(String teaCode);
    public void addTDeclComment(TDeclComment declComment);
    public List<TExpertTeacher> findExpTeaByExpLibId(String expLibId, PageBean pageBean);
    public List<TExpertTeacher> findExpTeaByExpLibId(String expLibId);
    public int findExpTeaCountByExpLibId(String expLibId);
    //获取本届期已经分配的专家教师
    public List findAssignedExpertTeachers(String jqId, String type, String teaCode);
    
    //根据届期id，专家库类型，获取专家库
    public List<TExpertLib> findExpertLibByJqid(String jqId, String type);
    
    //根据届期id，专家库类型，登陆教师ID，获取本学院专家库
    public List<TExpertLib> findUnitExpertLibByJqid(String jqId, String type, String teacherCode);
}
