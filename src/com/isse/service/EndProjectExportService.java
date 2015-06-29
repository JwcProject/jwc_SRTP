package com.isse.service;

import java.util.List;

import org.hibernate.Query;

import com.isse.model.TDeclaration;
import com.isse.model.TEndProject;
import com.isse.model.TEndProjectExport;
import com.isse.model.TExpertTeacher;
import com.util.PageBean;

/**
 * @Create Date：2013-9-7上午10:35:54
 * @Update Date：
 * @Author：lzh
 * TODO
 */
public interface EndProjectExportService {
	public void creatEndProExpertReview(TEndProject endProject, List<TExpertTeacher> tExpertTeacherList);
	public List<TEndProjectExport> findMyReviewEndPros(String teaCode,String jieqiId,PageBean pageBean);
	public int findMyReviewEndPros(String teaCode,String jieqiId);
	//根据结题ID和教职工号获取结题评审专家对象
	public TEndProjectExport findEndProExp(String teaCode,String endProId);
}
