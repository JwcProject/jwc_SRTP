package edu.cqu.no1.service;

import java.util.List;

import edu.cqu.no1.domain.TEndProject;
import edu.cqu.no1.domain.TEndProjectExport;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface EndProjectExportService {
	public void creatEndProExpertReview(TEndProject endProject, List<TExpertTeacher> tExpertTeacherList);
	public List<TEndProjectExport> findMyReviewEndPros(String teaCode, String jieqiId, PageBean pageBean);
	public int findMyReviewEndPros(String teaCode, String jieqiId);
	//根据结题ID和教职工号获取结题评审专家对象
	public TEndProjectExport findEndProExp(String teaCode, String endProId);
}
