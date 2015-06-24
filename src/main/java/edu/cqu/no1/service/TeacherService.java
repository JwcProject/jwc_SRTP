package edu.cqu.no1.service;

import edu.cqu.no1.domain.TTeacher;
import edu.cqu.no1.domain.TUser;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface TeacherService {
    public List getTeachers(String teaCode);

    public List getCommonTeachers(String teaCode, String type);

    public void addTTeacher(TTeacher tTeacher);

    public TTeacher findTeacherByTeaCode(String teaCode);

    public void addUsers(TUser tUser);
}
