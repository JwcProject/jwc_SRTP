/**
 * 
 */
package com.isse.service;

import java.util.List;

import com.isse.model.TDeclComment;
import com.isse.model.TDeclaration;
import com.isse.model.TExpertLib;
import com.isse.model.TExpertReview;
import com.isse.model.TExpertTeacher;

/**
 * @author ming
 *
 */
public interface ExpertReviewService {
	public void creatExpertReview(TDeclaration tDeclaration, List<TExpertTeacher> tExpertTeacherList);
	public TExpertReview getTExpertReview(String jqId,String teaCode,String declId,String type);
	public TDeclComment geTDeclCommentByTexpertReview(String texperReviewId);
}
