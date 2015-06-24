/**
 *
 */
package edu.cqu.no1.service.impl;

import java.util.List;

import edu.cqu.no1.dao.TExpertLibDAO;
import edu.cqu.no1.dao.TExpertTeacherDAO;
import edu.cqu.no1.dao.TTempEmailReciverDAO;
import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.domain.TTempEmailReciver;
import edu.cqu.no1.service.ExpertLibService;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class ExpertLibServiceImpl implements ExpertLibService {

    @Resource
    private TExpertLibDAO tExpertLibDAO;
    @Resource
    private TExpertTeacherDAO tExpertTeacherDAO;
    @Resource
    private TTempEmailReciverDAO tTempEmailReciverDAO;

    public TExpertLib getById(String libId) {
        return this.tExpertLibDAO.findById(libId);
    }

    /* (non-Javadoc)
     * @see com.isse.service.ExpertLibService#creatExpertLib()
     */
    @Override
    //创建一个专家库
    public void creatExpertLib(TExpertLib tExpertLib,
                               List<TExpertTeacher> tExpertTeacherList, String type) {
        // TODO Auto-generated method stub
        Session session = this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            // 开始事务
            trans.begin();

            this.tExpertLibDAO.save(tExpertLib);
            for (int i = 0; i < tExpertTeacherList.size(); i++) {
                //向专家教师表中添加对象
                tExpertTeacherList.get(i).setTExpertLib(tExpertLib);
                this.tExpertTeacherDAO.save(tExpertTeacherList.get(i));

                //向临时邮件收信人表中添加对象
                TTempEmailReciver tTempEmailReciver = new TTempEmailReciver();
                tTempEmailReciver.setCode(tExpertTeacherList.get(i).getTTeacher().getTeaCode());
                tTempEmailReciver.setDepartId(tExpertTeacherList.get(i).getTTeacher().getTUnit().getUnitId());
                tTempEmailReciver.setEmail(tExpertTeacherList.get(i).getTTeacher().getTeaEmail());
                tTempEmailReciver.setJqId(tExpertLib.getTJieqi().getJqId());
                tTempEmailReciver.setName(tExpertTeacherList.get(i).getTTeacher().getTeaName());
                //设置类别和单位
                tTempEmailReciver.setIsdeleted("N");
                tTempEmailReciver.setType(type);
                tTempEmailReciver.setDepartId(tExpertLib.getTUnit().getUnitId());
                this.tTempEmailReciverDAO.save(tTempEmailReciver);

            }
            this.tExpertTeacherDAO.changeReviewUserType(tExpertLib.getLibId());
            trans.commit();

        } catch (Exception e) {

            try {
                trans.rollback();// JTA事务回滚

            } catch (Exception e2) {
                // JTA事务回滚出错处理
                e2.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * 根据学院主管教师学号获取学院的专家信息
     */
    @Override
    public List<TExpertLib> findExpsByUnitTeaCode(String teaCode, String type,
                                                  PageBean pageBean) {
        return this.tExpertLibDAO.findExpsByUnitTeaCode(teaCode, type, pageBean);
    }

    @Override
    public int findExpsCountByUnitTeaCode(String teaCode, String type) {
        return this.tExpertLibDAO.findExpsCountByUnitTeaCode(teaCode, type);
    }

    @Override
    public TExpertLib findNowJieQiExpLib(String type) {
        return this.tExpertLibDAO.findNowJieQiExpLib(type);
    }

    //删除专家库以及该专家库中的专家教师
    public void deleteExperLib(TExpertLib tExpertLib) {
        Session session = this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            // 开始事务
            trans.begin();
            tExpertLib.setIsdeleted("Y");
            this.tExpertLibDAO.merge(tExpertLib);
            List<TExpertTeacher> expertTeacherList = this.tExpertTeacherDAO.getExpetTeachersByExpertLib(tExpertLib.getLibId());
            for (int i = 0; i < expertTeacherList.size(); i++) {
                expertTeacherList.get(i).setIsdeleted("Y");
                this.tExpertTeacherDAO.merge(expertTeacherList.get(i));
            }

            List<TTempEmailReciver> tempEmailReciverList = this.tTempEmailReciverDAO.findTempEmailReciverByJQid(tExpertLib.getTJieqi().getJqId());
            for (int i = 0; i < tempEmailReciverList.size(); i++) {
                tempEmailReciverList.get(i).setIsdeleted("Y");
                this.tTempEmailReciverDAO.merge(tempEmailReciverList.get(i));
            }
            trans.commit();

        } catch (Exception e) {

            try {
                trans.rollback();// JTA事务回滚

            } catch (Exception e2) {
                // JTA事务回滚出错处理
                e2.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    //更新专家库中的专家教师
    public void updateExperLib(TExpertLib tExpertLib, List<TExpertTeacher> expertTeacherList, String type) {
        Session session = this.tExpertTeacherDAO.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            // 开始事务
            trans.begin();

            List<TExpertTeacher> oldExpertTeacherList = this.tExpertTeacherDAO.getExpetTeachersByExpertLib(tExpertLib.getLibId());
            for (int i = 0; i < oldExpertTeacherList.size(); i++) {
                //删除专家教师表中的对象
                oldExpertTeacherList.get(i).setIsdeleted("Y");
                this.tExpertTeacherDAO.merge(oldExpertTeacherList.get(i));

                //删除临时邮件收信人表中对应的对象
                TTempEmailReciver tempEmailReciver = this.tTempEmailReciverDAO.findTempEmailReciver(tExpertLib.getTJieqi().getJqId(), oldExpertTeacherList.get(i).getTTeacher().getTeaCode());
                tempEmailReciver.setIsdeleted("Y");
                this.tTempEmailReciverDAO.merge(tempEmailReciver);
            }

            for (int i = 0; i < expertTeacherList.size(); i++) {
                //在专家教师表中添加对象
                expertTeacherList.get(i).setTExpertLib(tExpertLib);
                this.tExpertTeacherDAO.save(expertTeacherList.get(i));

                //在临时邮件收信人表中添加对象
                TTempEmailReciver tTempEmailReciver = new TTempEmailReciver();
                tTempEmailReciver.setCode(expertTeacherList.get(i).getTTeacher().getTeaCode());
                tTempEmailReciver.setDepartId(expertTeacherList.get(i).getTTeacher().getTUnit().getUnitId());
                tTempEmailReciver.setEmail(expertTeacherList.get(i).getTTeacher().getTeaEmail());
                tTempEmailReciver.setJqId(tExpertLib.getTJieqi().getJqId());
                tTempEmailReciver.setName(expertTeacherList.get(i).getTTeacher().getTeaName());
                //设置类别和单位
                tTempEmailReciver.setIsdeleted("N");
                tTempEmailReciver.setType(type);
                tTempEmailReciver.setDepartId(tExpertLib.getTUnit().getUnitId());
                this.tTempEmailReciverDAO.save(tTempEmailReciver);
            }

            trans.commit();

        } catch (Exception e) {

            try {
                trans.rollback();// JTA事务回滚

            } catch (Exception e2) {
                // JTA事务回滚出错处理
                e2.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * **************************
     * set and get methods
     * **************************
     */
    public TExpertLibDAO gettExpertLibDAO() {
        return tExpertLibDAO;
    }

    public void settExpertLibDAO(TExpertLibDAO tExpertLibDAO) {
        this.tExpertLibDAO = tExpertLibDAO;
    }

    public TExpertTeacherDAO gettExpertTeacherDAO() {
        return tExpertTeacherDAO;
    }

    public void settExpertTeacherDAO(TExpertTeacherDAO tExpertTeacherDAO) {
        this.tExpertTeacherDAO = tExpertTeacherDAO;
    }

    public TTempEmailReciverDAO gettTempEmailReciverDAO() {
        return tTempEmailReciverDAO;
    }

    public void settTempEmailReciverDAO(TTempEmailReciverDAO tTempEmailReciverDAO) {
        this.tTempEmailReciverDAO = tTempEmailReciverDAO;
    }

}
