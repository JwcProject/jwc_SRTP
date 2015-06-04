package edu.cqu.no1.service;


import edu.cqu.no1.domain.TDeclComment;
import edu.cqu.no1.domain.TDeclaration;
import edu.cqu.no1.domain.TExpertReview;
import edu.cqu.no1.domain.TExpertTeacher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface ExpertReviewService {
	public void creatExpertReview(TDeclaration tDeclaration, List<TExpertTeacher> tExpertTeacherList);
	public TExpertReview getTExpertReview(String jqId, String teaCode, String declId, String type);
	public TDeclComment geTDeclCommentByTexpertReview(String texperReviewId);
}
