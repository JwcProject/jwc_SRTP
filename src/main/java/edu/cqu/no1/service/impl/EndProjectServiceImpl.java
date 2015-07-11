package edu.cqu.no1.service.impl;

import java.util.ArrayList;
import java.util.List;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.datamodel.EndProject;
import edu.cqu.no1.datamodel.EndProjectProperty;
import edu.cqu.no1.datamodel.ExpertTeacher;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.EndProjectService;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class EndProjectServiceImpl implements EndProjectService {


    @Resource
    public TEndProjectDAO endProjectDAO;
    @Resource
    public TAttachmentDAO attachmentDAO;
    @Resource
    public TAttchmentTypeDAO attchmentTypeDAO;
    @Resource
    public TEndprojectJobDAO endprojectJobDAO;
    @Resource
    public TTempEmailReciverDAO tempEmailReciverDAO;
    @Resource
    public TEndProjectCommentDAO endProjectCommentDAO;


    @Resource
    private TUnitDAO unitDAO;
    @Resource
    private TJieqiDAO jieqiDAO;
    @Resource
    private TProfessionDAO professionDAO;
    @Resource
    private TExpertTeacherDAO expertTeacherDAO;
    @Resource
    private TTeacherDAO teacherDAO;
    @Resource
    private TExpertLibDAO expertLibDAO;
    @Resource
    private TEndProjectExportDAO endProjectExportDAO;

    @Override
    public void secondReviewResultTypeIn(String endProjectIds, String lastScore) {
        Session session = this.endProjectDAO.getSessionFactory()
                .getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            // 开始事务
            trans.begin();
            String eids[] = endProjectIds.split(",");
            for (String eid : eids) {
                TEndProject endProject = this.endProjectDAO.findById(eid);
                endProject.setLastScore(lastScore);
                this.endProjectDAO.merge(endProject);
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();// 事务回滚
        }
    }

    @Override
    public int getEndProjectCountForResultTypeIn(EndProjectProperty properties,
                                                 Boolean typeIned) {
        properties.setEndProjectState("05");
        return this.endProjectDAO.getEndProjectCountForResultTypeIn(properties, typeIned);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EndProject> getEndProjectsForResultTypeIn(
            EndProjectProperty properties, Boolean typeIned,
            PageBean pageBean) {
        properties.setEndProjectState("05");
        List<EndProject> endProjects = new ArrayList<EndProject>();
        List<TEndProject> list = this.endProjectDAO.getEndProjectsForResultTypeIn(properties, typeIned, pageBean);
        copyProperties(endProjects, list);
        return endProjects;
    }

    @Override
    public void dispatchExperTeacher(String endProjectIds,
                                     String expertTeacherIds) {
        Session session = this.expertTeacherDAO.getSessionFactory()
                .getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            // 开始事务
            trans.begin();
            String eids[] = endProjectIds.split(",");
            String tids[] = expertTeacherIds.split(",");
            List<TExpertTeacher> expertTeachers = new ArrayList<TExpertTeacher>();
            for (String tid : tids) {
                expertTeachers.add(this.expertTeacherDAO.findById(tid));
            }
            for (String eid : eids) {
                for (TExpertTeacher expert : expertTeachers) {
                    TEndProjectExport endProjectExport = new TEndProjectExport();
                    TEndProject endProject = this.endProjectDAO.findById(eid);
                    endProjectExport.setTEndProject(endProject);
                    endProjectExport.setTExpertTeacher(expert);
                    this.endProjectExportDAO.save(endProjectExport);
                    endProject.setEndProjectState("05");
                    this.endProjectDAO.merge(endProject);
                }
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();// 事务回滚
        }
    }

    public int getEndProjectCountForSecReview(EndProjectProperty properties) {
        properties.setEndProjectState("04");
        return this.endProjectDAO.getEndProjectCountByMutiProperty(properties);
    }

    @SuppressWarnings("unchecked")
    public List<EndProject> getEndProjectForSecReview(EndProjectProperty properties,
                                                      PageBean pageBean) {
        properties.setEndProjectState("04");
        List<EndProject> endProjects = new ArrayList<EndProject>();
        List<TEndProject> list = this.endProjectDAO.getEndProjectsByMutiProperty(properties, pageBean);
        copyProperties(endProjects, list);
        return endProjects;
    }

    private void copyProperties(List<EndProject> endProjects, List<TEndProject> list) {
        for (TEndProject tEndProject : list) {
            EndProject endProject = new EndProject();
            endProject.setEndprojectId(tEndProject.getEndProjectId());
            endProject.setEndprojectScore(tEndProject.getEndProjectScore());
            endProject.setProfessionName(tEndProject.getTProject().getTStudentByProjectLeader().getTProfessionByProfessionId().getProfessionName());
            endProject.setProjectName(tEndProject.getTProject().getProjectName());
            endProject.setProjectNumber(tEndProject.getTProject().getProjectNumber());
            endProject.setQici(tEndProject.getTJieqi().getQici());
            endProject.setStudentName(tEndProject.getTProject().getTStudentByProjectLeader().getStudentName());
            endProject.setStudentNunber(tEndProject.getTProject().getTStudentByProjectLeader().getStudentNumber());
            endProject.setUnitName(tEndProject.getTProject().getTUnit().getUnitName());
            endProject.setUnitTypeinTime(tEndProject.getUnitTypeinTime());
            endProject.setYear(tEndProject.getTJieqi().getJqYear().toString());
            if (tEndProject.getLastScore() != null) {
                endProject.setLastScore(tEndProject.getLastScore());
            }
            endProjects.add(endProject);
        }
    }

    @Override
    public void deleteExpertTeacher(String expertTeacherIds) {
        Session session = this.expertTeacherDAO.getSessionFactory()
                .getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            // 开始事务
            trans.begin();
            String ids[] = expertTeacherIds.split(",");
            for (String eid : ids) {
                TExpertTeacher expertTeacher = this.expertTeacherDAO
                        .findById(eid);
                expertTeacher.setIsdeleted("Y");
                this.expertTeacherDAO.merge(expertTeacher);
                TTempEmailReciver tempEmailReciver = this.tempEmailReciverDAO
                        .findTempEmailRecivers(
                                expertTeacher.getTExpertLib().getTJieqi()
                                        .getJqId(),
                                expertTeacher.getTTeacher().getTeaCode(), "03")
                        .get(0);
                tempEmailReciver.setIsdeleted("Y");
                this.tempEmailReciverDAO.merge(tempEmailReciver);
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();// 事务回滚
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public TExpertTeacher addExpertTeacher(String jieqiId, String teaCode, String type, TUser loginUser) {
        TTeacher teacher = findTeacherByTeaCode(teaCode);
        TTeacher loginTeacher = findTeacherByTeaCode(loginUser.getUserId());
        if (null != loginTeacher) {
            if (null != loginTeacher.getTUnit() && !"".equals(loginTeacher.getTUnit().getUnitId())) {
                List<TExpertLib> expertLibs = this.expertLibDAO.findExpertLibByQici(jieqiId, loginTeacher.getTUnit().getUnitId(), type);
                TExpertLib expertLib = new TExpertLib();
                TExpertTeacher exTeacher = new TExpertTeacher();
                Session session = this.expertTeacherDAO.getSessionFactory().getCurrentSession();
                Transaction trans = session.beginTransaction();
                try {
                    // 开始事务
                    trans.begin();
                    if (expertLibs == null || expertLibs.size() == 0) {
                        setExpertLibProperty(expertLib, teacher, jieqiId, type, loginUser);
                        this.expertLibDAO.save(expertLib);
                    } else {
                        expertLib = expertLibs.get(0);
                    }
                    exTeacher.setTTeacher(teacher);
                    exTeacher.setTExpertLib(expertLib);
                    this.expertTeacherDAO.save(exTeacher);

                    //向临时邮件收信人表中添加对象
                    TTempEmailReciver tTempEmailReciver = new TTempEmailReciver();
                    tTempEmailReciver.setCode(teacher.getTeaCode());
                    tTempEmailReciver.setDepartId(teacher.getTUnit().getUnitId());
                    tTempEmailReciver.setEmail(teacher.getTeaEmail());
                    tTempEmailReciver.setJqId(expertLib.getTJieqi().getJqId());
                    tTempEmailReciver.setName(teacher.getTeaName());
                    tTempEmailReciver.setType(type);
                    tTempEmailReciver.setDepartId(teacher.getTUnit().getUnitId());
                    this.tempEmailReciverDAO.save(tTempEmailReciver);
                    trans.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    trans.rollback();// 事务回滚
                }
                return exTeacher;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    private void setExpertLibProperty(TExpertLib expertLib, TTeacher teacher, String jieqiId, String type, TUser loginUser) {
        TTeacher loginTeacher = findTeacherByTeaCode(loginUser.getUserId());
        expertLib.setTTeacher(loginTeacher);
        expertLib.setTJieqi(this.jieqiDAO.findById(jieqiId));
        expertLib.setTUnit(loginTeacher.getTUnit());
        expertLib.setType(type);
    }

    private TTeacher findTeacherByTeaCode(String teaCode) {
        List<TTeacher> teacherList = this.teacherDAO.findByTeaCode(teaCode);
        TTeacher teacher = null;
        if (teacherList.size() > 0) {
            teacher = teacherList.get(0);
        }
        return teacher;
    }

    @Override
    public int getExpTeaCountByQici(String jieqiId, String type) {
        return this.expertTeacherDAO.getExpTeaCountByQici(jieqiId, type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExpertTeacher> getExpertTeachersByQici(String qiciId,
                                                       String type, PageBean pageBean) {
        List<ExpertTeacher> expertTeachers = new ArrayList<ExpertTeacher>();
        List<TExpertTeacher> list = this.expertTeacherDAO.getExpertTeachersByQici(qiciId, type, pageBean);
        for (TExpertTeacher tExpertTeacher : list) {
            TTeacher teacher = tExpertTeacher.getTTeacher();
            TJieqi tJieqi = tExpertTeacher.getTExpertLib().getTJieqi();
            expertTeachers.add(new ExpertTeacher(tExpertTeacher.getExTeaId(), teacher.getTeaName(), teacher.getTeaCode(),
                    teacher.getTUnit().getUnitName(), teacher.getTeaTitle(), tJieqi.getJqYear().toString(), tJieqi.getQici()));
        }
        return expertTeachers;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TUnit> getAllColleges() {
        return this.unitDAO.getAllColleges();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TProfession> getProfessionsByTeacherId(String teacherId) {
        return this.professionDAO.findProfessionsByTeaCode(teacherId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAllJieQiYear() {
        return jieqiDAO.findAllYears();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TEndProject> getEndProjectsByMutiProperty(TUser user,
                                                          EndProjectProperty properties, PageBean pageBean) {
        if ("00".equals(user.getUserType()) || "01".equals(user.getUserType())) {
            //properties.setEndProjectState("04");
            return this.endProjectDAO.getEndProjectsByMutiProperty(properties, pageBean);
        }
        if ("02".equals(user.getUserType()) || "03".equals(user.getUserType())) {
            properties.setUnitId(this.unitDAO.getUnitByTeacherId(user.getUserId()).getUnitId());
            return this.endProjectDAO.getEndProjectsByMutiProperty(properties, pageBean);
        }
        return null;
    }

    @Override
    public int getEndProjectCountByMutiProperty(TUser user,
                                                EndProjectProperty properties) {
        if ("00".equals(user.getUserType()) || "01".equals(user.getUserType())) {
            //properties.setEndProjectState("04");
            return this.endProjectDAO.getEndProjectCountByMutiProperty(properties);
        }
        if ("02".equals(user.getUserType()) || "03".equals(user.getUserType())) {
            properties.setUnitId(this.unitDAO.getUnitByTeacherId(user.getUserId()).getUnitId());
            return this.endProjectDAO.getEndProjectCountByMutiProperty(properties);
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TJieqi> getJieqisOfYear(String year) {
        return this.jieqiDAO.getJieqiByYear(year);
    }

    /**
     * 提交结题申请
     */
    @Override
    public TEndProject addEndProjectRequest(List<TAttachment> tAttachments,
                                            TEndProject endProject, List<TEndProjectJob> endprojectJobs) {
//        Session session = this.endProjectDAO.getSessionFactory().getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            transaction.begin();
            //结题
            this.endProjectDAO.save(endProject);
            TAttchmentType tAttchmentType = this.attchmentTypeDAO.findById("3");
            //附件
            for (TAttachment tAttachment : tAttachments) {
                tAttachment.setTAttchmentType(tAttchmentType);
                tAttachment.setObjectCode(endProject.getEndProjectId());
                tAttachment.setIsdeleted("N");
                this.attachmentDAO.save(tAttachment);
            }
            //分工
            for (TEndProjectJob t : endprojectJobs) {
                t.setTEndProject(endProject);
                t.setIsdeleted("N");
                this.endprojectJobDAO.save(t);
            }
//            transaction.commit();
            return endProject;
//        } catch (Exception e) {
//            e.printStackTrace();
////            transaction.rollback();
//            return null;
//        }
    }


    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#updateEndProjects(java.util.List)
     */
    @Override
    public void updateEndProjects(List<TEndProject> endProjects) {
        Session session = this.endProjectDAO.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            transaction.begin();
            for (TEndProject t : endProjects) {
                this.endProjectDAO.merge(t);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    /**
     * 根据结题获取结题的分工信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TEndProjectJob> findEndproJobsByEndProId(String endproId) {
        return this.endprojectJobDAO.findEndProJobsByEndProId(endproId);
    }

    /**
     * 根据结题获取结题的附件
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TAttachment> findAttachmentByEndProId(String endproId) {
        return this.attachmentDAO.findAttachsByEndProId(endproId);
    }

    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#findMyReviewEndPros(java.lang.String, com.util.PageBean)
     */
    @Override
    public List<TEndProjectComment> findMyReviewEndPros(String teaCode,
                                                        PageBean pageBean) {
        return this.endProjectCommentDAO.findMyReviewEndPros(teaCode, pageBean);
    }


    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#findMyReviewEndProsCount(java.lang.String)
     */
    @Override
    public int findMyReviewEndProsCount(String teaCode) {
        return this.endProjectCommentDAO.findMyReviewEndProsCount(teaCode);
    }

    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#getUnitEndProjects(java.lang.String, java.lang.String, java.lang.String, com.util.PageBean)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TEndProject> getUnitEndProjects(String unitTeaCode,
                                                String checkState, PageBean pageBean) {
        return this.endProjectDAO.getUnitEndProByTeaCode(unitTeaCode, checkState, pageBean);
    }

    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#getUnitEndProjectsCount(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int getUnitEndProjectsCount(String unitTeaCode, String checkState) {
        return this.endProjectDAO.getUnitEndProCount(unitTeaCode, checkState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TEndProject> findMyEndProjects(String studentNum) {
        return this.endProjectDAO.findMyEndProjects(studentNum);
    }

    @Override
    public TEndProject findEndProjectById(String endprojectId) {
        return this.endProjectDAO.findById(endprojectId);
    }

    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#findEndProByMutipleProperty(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.util.PageBean)
     */
    @Override
    public List<TEndProject> findEndProByMutipleProperty(String teaCode,
                                                         String year, String qici, String proNumber, String proName,
                                                         String profession, String stuNumber, String state, PageBean pageBean) {
        return this.endProjectDAO.findEndProByMutipleProperty(teaCode, year, qici, proNumber, proName, profession, stuNumber, state, pageBean);
    }

    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#findEndProByMutiplePropertyCount(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int findEndProByMutiplePropertyCount(String teaCode, String year,
                                                String qici, String proNumber, String proName, String profession,
                                                String stuNumber, String state) {
        return this.endProjectDAO.findEndProByMutiplePropertyCount(teaCode, year, qici, proNumber, proName, profession, stuNumber, state);
    }

    /* (non-Javadoc)
     * @see com.isse.service.EndProjectService#findEndProComById(java.lang.String)
     */
    @Override
    public TEndProjectComment findEndProComById(String id) {
        return this.endProjectCommentDAO.findById(id);
    }

    @Override
    public TEndProject findByLeaderCode(String leaderCode) {
        return this.endProjectDAO.findByLeaderCode(leaderCode);
    }

    @Override
    public void addEndProjectComment(
            TEndProjectComment endProjectComment) {
        this.endProjectCommentDAO.save(endProjectComment);
    }

    /**
     * *************************************
     * set and get methods
     * **************************************
     */
    public TEndProjectDAO getEndProjectDAO() {
        return endProjectDAO;
    }

    public void setEndProjectDAO(TEndProjectDAO endProjectDAO) {
        this.endProjectDAO = endProjectDAO;
    }

    public TAttachmentDAO getAttachmentDAO() {
        return attachmentDAO;
    }

    public void setAttachmentDAO(TAttachmentDAO attachmentDAO) {
        this.attachmentDAO = attachmentDAO;
    }

    public TAttchmentTypeDAO getAttchmentTypeDAO() {
        return attchmentTypeDAO;
    }

    public void setAttchmentTypeDAO(TAttchmentTypeDAO attchmentTypeDAO) {
        this.attchmentTypeDAO = attchmentTypeDAO;
    }

    public TEndprojectJobDAO getEndprojectJobDAO() {
        return endprojectJobDAO;
    }

    public void setEndprojectJobDAO(TEndprojectJobDAO endprojectJobDAO) {
        this.endprojectJobDAO = endprojectJobDAO;
    }

    public TTempEmailReciverDAO getTempEmailReciverDAO() {
        return tempEmailReciverDAO;
    }

    public void setTempEmailReciverDAO(TTempEmailReciverDAO tempEmailReciverDAO) {
        this.tempEmailReciverDAO = tempEmailReciverDAO;
    }


    public TEndProjectCommentDAO getEndProjectCommentDAO() {
        return endProjectCommentDAO;
    }


    public void setEndProjectCommentDAO(TEndProjectCommentDAO endProjectCommentDAO) {
        this.endProjectCommentDAO = endProjectCommentDAO;
    }

    public TUnitDAO getUnitDAO() {
        return unitDAO;
    }


    public void setUnitDAO(TUnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }


    public TJieqiDAO getJieqiDAO() {
        return jieqiDAO;
    }


    public void setJieqiDAO(TJieqiDAO jieqiDAO) {
        this.jieqiDAO = jieqiDAO;
    }


    public TProfessionDAO getProfessionDAO() {
        return professionDAO;
    }


    public void setProfessionDAO(TProfessionDAO professionDAO) {
        this.professionDAO = professionDAO;
    }

    public TExpertTeacherDAO getExpertTeacherDAO() {
        return expertTeacherDAO;
    }

    public void setExpertTeacherDAO(TExpertTeacherDAO expertTeacherDAO) {
        this.expertTeacherDAO = expertTeacherDAO;
    }

    public TTeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TTeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public TExpertLibDAO getExpertLibDAO() {
        return expertLibDAO;
    }

    public void setExpertLibDAO(TExpertLibDAO expertLibDAO) {
        this.expertLibDAO = expertLibDAO;
    }

    public TEndProjectExportDAO getEndProjectExportDAO() {
        return endProjectExportDAO;
    }

    public void setEndProjectExportDAO(TEndProjectExportDAO endProjectExportDAO) {
        this.endProjectExportDAO = endProjectExportDAO;
    }
}
