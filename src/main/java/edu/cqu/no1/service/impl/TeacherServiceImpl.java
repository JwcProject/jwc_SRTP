package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TTeacherDAO;
import edu.cqu.no1.dao.TUserDAO;
import edu.cqu.no1.domain.TTeacher;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    private TTeacherDAO tTeacherDAO;
    private TUserDAO tUserDAO;

    public TTeacherDAO gettTeacherDAO() {
        return tTeacherDAO;
    }

    public void settTeacherDAO(TTeacherDAO tTeacherDAO) {
        this.tTeacherDAO = tTeacherDAO;
    }

    public TUserDAO gettUserDAO() {
        return tUserDAO;
    }

    public void settUserDAO(TUserDAO tUserDAO) {
        this.tUserDAO = tUserDAO;
    }

    public List getTeachers(String teaCode) {
        // TODO Auto-generated method stub
        return this.tTeacherDAO.getTeachers(teaCode);
    }

    public List getCommonTeachers(String teaCode, String type) {
        return this.tTeacherDAO.getCommonTeachers(teaCode, type);
    }

    public void addTTeacher(TTeacher tTeacher) {
        this.tTeacherDAO.save(tTeacher);
    }

    public TTeacher findTeacherByTeaCode(String teaCode) {
        List<TTeacher> teacherList = this.tTeacherDAO.findTeacherByCode(teaCode);
        TTeacher teacher = null;
        if (teacherList.size() > 0) {
            teacher = teacherList.get(0);
        }
        return teacher;
    }

    @Override
    public void addUsers(TUser tUser) {
        this.tUserDAO.save(tUser);
    }


}
