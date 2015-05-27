package edu.cqu.no1.dao;

import edu.cqu.no1.datamodel.EndProjectProperty;
import edu.cqu.no1.domain.TEndProject;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TEndProjectDAO extends BaseDao<TEndProject> {
    //	public int getEndProjectCountForSecReview(EndProjectProperty properties){
//		Criteria criteria = getCriteriaForSecReview(properties);
//		int rowCount = (Integer) criteria.setProjection(Projections.rowCount())
//				.uniqueResult();
//		criteria.setProjection(null);
//		return rowCount;
//	}
    List getEndProjectsForResultTypeIn(EndProjectProperty properties, Boolean typeIned, PageBean pageBean);

    int getEndProjectCountForResultTypeIn(EndProjectProperty properties, Boolean typeIned);

    int getEndProjectCountByMutiProperty(EndProjectProperty properties);

    List getEndProjectsByMutiProperty(EndProjectProperty properties,
                                      PageBean pageBean);

    TEndProject findByLeaderCode(String leaderCode);

    @SuppressWarnings("unchecked")
    List<TEndProject> findEndProByMutipleProperty(String teaCode,
                                                  String year, String qici, String proNumber, String proName,
                                                  String profession, String stuNumber, String state, PageBean pageBean);

    int findEndProByMutiplePropertyCount(String teaCode, String year,
                                         String qici, String proNumber, String proName, String profession,
                                         String stuNumber, String state);

    List getUnitEndProByTeaCode(String unitTeaCode, String checkState,
                                PageBean pageBean);

    int getUnitEndProCount(String unitTeaCode, String checkState);

    List findMyEndProjects(String studentNum);

    List findByEndprojectState(Object endprojectState);

    List findByEndprojectSummary(Object endprojectSummary);

    List findByEndprojectMethod(Object endprojectMethod);

    List findByEndprojectScore(Object endprojectScore);

    List findByLastScore(Object lastScore);

    List findByEndprojectNumber(Object endprojectNumber);

    List findByLastComment(Object lastComment);

    List findByEndprojectComment(Object endprojectComment);

    List findByEndprojectName(Object endprojectName);

    List findByEndprojectSense(Object endprojectSense);

    List findByEndprojectContent(Object endprojectContent);

    List findByEndprojectCredit(Object endprojectCredit);

    List findByEndprojectProblem(Object endprojectProblem);

    List findByEndprojectInnovate(Object endprojectInnovate);

    List findByEndprojectIntroduction(Object endprojectIntroduction);

    List findByEndprojectWork(Object endprojectWork);

    List findByIsdeleted(Object isdeleted);

    List findByEndprojectPassapply(Object endprojectPassapply);
}
