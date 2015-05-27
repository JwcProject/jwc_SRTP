package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TPermission;
import edu.cqu.no1.util.PageBean;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TPermissionDAO {
    List findByPermissionName(Object permissionName);

    List findByPermissionState(Object permissionState);

    List findByPermissionUrl(Object permissionUrl);

    List findByPermissionLevel(Object permissionLevel);

    List findByPermissionFatherid(Object permissionFatherid);

    List findByPermissionIntroduction(Object permissionIntroduction);

    List findByIsdeleted(Object isdeleted);

    int getAllTPermissionCount();

    List findAll(PageBean pageBean);

    //write by pzh
    List findAllExceptDeleted();

    List seachPermission(TPermission instance, PageBean pageBean);

    int getSearchCount(TPermission instance);

    @SuppressWarnings("unchecked")
    List getChildPermissionsById(String id);
}
