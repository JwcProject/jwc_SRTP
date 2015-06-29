package com.isse.service;

import java.math.BigDecimal;
import java.util.List;

import com.isse.datamodel.EndProject;
import com.isse.datamodel.EndProjectProperty;
import com.isse.datamodel.ExpertTeacher;
import com.isse.model.TAttachment;
import com.isse.model.TEndProject;
import com.isse.model.TEndProjectComment;
import com.isse.model.TEndprojectJob;
import com.isse.model.TExpertTeacher;
import com.isse.model.TJieqi;
import com.isse.model.TProfession;
import com.isse.model.TUnit;
import com.isse.model.TUser;
import com.util.PageBean;

/**
 * @Create Date：2013-8-31上午12:32:27
 * @Update Date：
 * @Author：lzh
 * TODO
 */
public interface EndProjectService {

	public TEndProject addEndProjectRequest(List<TAttachment> tAttachments,TEndProject endProject,List<TEndprojectJob> endprojectJobs);
	public List<TEndProject> findMyEndProjects(String studentNum);
	public TEndProject findEndProjectById(String endprojectId);
	//获取学院结题列表
	public List<TEndProject> getUnitEndProjects(String unitTeaCode, String checkState, PageBean pageBean);
	public int getUnitEndProjectsCount(String unitTeaCode, String checkState);
	public void updateEndProjects(List<TEndProject> endProjects);
	//获取一个教师可以评审的结题
	public List<TEndProjectComment> findMyReviewEndPros(String teaCode,PageBean pageBean);
	public int findMyReviewEndProsCount(String teaCode);
	
	public TEndProjectComment findEndProComById(String id);
	public List<TEndProject> findEndProByMutipleProperty(String teaCode,
			String year, String qici, String proNumber, String proName,
			String profession, String stuNumber, String state, PageBean pageBean);
	public int findEndProByMutiplePropertyCount(String teaCode, String year,
			String qici, String proNumber, String proName, String profession,
			String stuNumber, String state); 
	//根据结题获取结题分工信息
	public List<TEndprojectJob> findEndproJobsByEndProId(String endproId);
	//根据结题获取结题附件
	public List<TAttachment>findAttachmentByEndProId(String endproId);
	public TEndProject findByLeaderCode(String leaderCode);
	
	public void addEndProjectComment(TEndProjectComment endProjectComment);
	/**
	 * lsp
	 */
	List<BigDecimal> getAllJieQiYear();
	List<TJieqi> getJieqisOfYear(String year);
	int getEndProjectCountByMutiProperty(TUser user, EndProjectProperty properties);
	List<TEndProject> getEndProjectsByMutiProperty(TUser user, EndProjectProperty properties, PageBean pageBean);
	List<TProfession> getProfessionsByTeacherId(String teacherId);
	List<TUnit> getAllColleges();
	
	List<ExpertTeacher> getExpertTeachersByQici(String qiciId,String type,PageBean pageBean);
	int getExpTeaCountByQici(String jieqiId, String type);
	TExpertTeacher addExpertTeacher(String jieqiId,String teaCode,String type,TUser loginUser);
	void deleteExpertTeacher(String expertTeacherIds);
	int getEndProjectCountForSecReview(EndProjectProperty properties);
	List<EndProject> getEndProjectForSecReview(EndProjectProperty properties,
			PageBean pageBean);
	void dispatchExperTeacher(String endProjectIds, String expertTeacherIds);
	int getEndProjectCountForResultTypeIn(EndProjectProperty properties,Boolean typeIned);
	List<EndProject> getEndProjectsForResultTypeIn(EndProjectProperty properties,Boolean typeIned,PageBean pageBean);
	void secondReviewResultTypeIn(String endProjectIds, String lastScore);
}
