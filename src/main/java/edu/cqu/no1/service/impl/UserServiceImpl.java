package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TRoleDao;
import edu.cqu.no1.dao.TStudentDAO;
import edu.cqu.no1.dao.TTeacherDAO;
import edu.cqu.no1.dao.TUserDAO;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.exception.RedundancyEmailException;
import edu.cqu.no1.exception.RedundancyUserException;


import edu.cqu.no1.service.UserService;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserDAO tUserDAO;
    @Resource
    private TTeacherDAO tTeacherDAO;
    @Resource
    private TStudentDAO tStudentDAO;

    @Override
    public TUser changeLoginState(String userId, String state) {
        TUser user = this.tUserDAO.findById(userId);
        user.setUserState(state);
        // this.tUserDAO.merge(user);
        return user;
    }

    @Override
    public TUser changePassword(String userId, String password) {
        TUser user = this.tUserDAO.findById(userId);
        user.setPassword(password);
        this.tUserDAO.merge(user);
        return user;
    }

    @Override
    public TStudent getStudentByUserId(String userId) {
        List list = this.tStudentDAO.findByStudentNumber(userId);
        if (list != null && list.size() > 0) {
            return (TStudent) list.get(0);
        }
        return null;
    }

    @Override
    public TTeacher getTeacherByUserId(String userId) {
        List list = this.tTeacherDAO.findByTeaCode(userId);
        if (list != null && list.size() > 0) {
            return (TTeacher) list.get(0);
        }
        return null;
    }

    public TUserDAO gettUserDAO() {
        return tUserDAO;
    }

    public void settUserDAO(TUserDAO tUserDAO) {
        this.tUserDAO = tUserDAO;
    }

    public TTeacherDAO gettTeacherDAO() {
        return tTeacherDAO;
    }

    public void settTeacherDAO(TTeacherDAO tTeacherDAO) {
        this.tTeacherDAO = tTeacherDAO;
    }

    public TStudentDAO gettStudentDAO() {
        return tStudentDAO;
    }

    public void settStudentDAO(TStudentDAO tStudentDAO) {
        this.tStudentDAO = tStudentDAO;
    }

    @Override
    public void addTUser(TUser user) {
        // TODO Auto-generated method stub
        this.tUserDAO.save(user);
    }

    @Override
    public void updateTUser(TUser user) {
        // TODO Auto-generated method stub
        this.tUserDAO.merge(user);
    }

    @Override
    public void deleteTUser(String id) {
        // TODO Auto-generated method stub
        TUser user = this.getTUser(id);
        user.setIsdeleted("1");
        this.updateTUser(user);
    }

    @Override
    public TUser getTUser(String id) {
        // TODO Auto-generated method stub
        return this.tUserDAO.findById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TUser> getAllTUser(PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tUserDAO.findAll(pageBean);
    }

    @Override
    public int getAllTUserCount() {
        // TODO Auto-generated method stub
        return this.tUserDAO.getAllTUserCount();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TUser> getTUserByMutiProperty(String userId, String userName,
                                              String userType, String userState, PageBean pageBean) {
        // TODO Auto-generated method stub
        return this.tUserDAO.getTUserByMutiProperty(userId, userName, userType, userState, pageBean);
    }

    @Override
    public int getTUserCountByMutiProperty(String userId, String userName,
                                           String userType, String userState) {
        // TODO Auto-generated method stub
        return this.tUserDAO.getTUserCountByMutiProperty(userId, userName, userType, userState);
    }

    @Override
    public TUser userLogin(String userId, String password) {
        List list = this.tUserDAO.findByUserIdAndPwd(userId, password);
        if (list != null && list.size() > 0) {
            return (TUser) list.get(0);
        }
        return null;
    }

    @Override
    public TUnit getUnitByUserId(String userId, String userType) {
        if ("00".equals(userType) || "01".equals(userType) || "02".equals(userType) || "03".equals(userType) || "04".equals(userType) || "05".equals(userType)) {
            List tmpList = this.tTeacherDAO.findTeacherByCode(userId);
            if (null != tmpList && null != tmpList.get(0)) {
                TTeacher teacher = (TTeacher) tmpList.get(0);

                if (null != teacher.getTeaId() && null != teacher.getTUnit()) {
                    return teacher.getTUnit();
                }
            }
        } else if ("06".equals(userType) || "07".equals(userType) || "08".equals(userType)) {
            List tmpList = this.tStudentDAO.findStudentByCode(userId);
            if (null != tmpList && null != tmpList.get(0)) {
                TStudent student = (TStudent) tmpList.get(0);

                if (null != student.getStudentId() && null != student.getTUnit()) {
                    return student.getTUnit();
                }
            }
        }
        return null;
    }

    @Resource
    private TRoleDao tRoleDao;

    private TUser user;


    public int checkUser(String username, String password) {

        try {
            user = tUserDAO.findByUsername(username);
        } catch (RedundancyUserException e) {
            user = null;
            return REDUNDANCY_USER;
        }
        if (user == null) {
            return NO_THIS_USER;
        }
        if (!user.getPassword().equals(password)) {
            user = null;
            return PASSWORD_WORRY;
        }
        return SUCCESS;
    }

    public int registerUser(TUser user) {
        this.user = null;
        try {
            if (tUserDAO.findByUsername(user.getUsername()) != null) {
                return REDUNDANCY_USER;
            }
            if (tUserDAO.findByEmail(user.getEmail()) != null) {
                return REDUNDANCY_EMAIL;
            }
            user.setTRole(tRoleDao.getRoleByName("ѧ��"));

            tUserDAO.saveUser(user);
            this.user = user;
            return SUCCESS;

        } catch (RedundancyUserException e) {
            return DATABASE_ERROR;
        } catch (RedundancyEmailException e) {
            return DATABASE_ERROR;
        }
    }

    /**
     * before: user check or register
     *
     * @return checked user,if check or register successfully
     * ,otherwise null
     */
    public TUser getUser() {
        return user;
    }

    @Override
    public List<TAuthority> getUserAuthorities(TUser user) {
        return tUserDAO.getUserAuthorities(user);
    }

    @Override
    public TRole getUserRole(TUser user) {
        Hibernate.initialize(user.getTRole());
        System.out.println(user.getTRole());
        return user.getTRole();
    }

    @Override
    public List<TUser> listAllUserByPage(int pageNo, int pageSize) {
        return tUserDAO.findAllUserByPage(pageNo, pageSize);
    }

    @Override
    public int resetPassword(String username, String email) {
        try {
            TUser user = tUserDAO.findByUsername(username);
            if (user == null) {
                return NO_THIS_USER;
            }
            if (!user.getEmail().equals(email)) {
                return EMAIL_WORRY;
            }

            user.setPassword(UUID.randomUUID().toString());

            tUserDAO.save(user);

            //TODO: send email to user ;

            return SUCCESS;

        } catch (RedundancyUserException e) {
            return REDUNDANCY_USER;
        }

    }

    @Override
    public TUser attachUser(TUser tUser) {
        return tUserDAO.attachDirty(tUser);
    }

}
