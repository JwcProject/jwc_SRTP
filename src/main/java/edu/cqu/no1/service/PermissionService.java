package edu.cqu.no1.service;


import edu.cqu.no1.domain.TPermission;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface PermissionService {

    public void addTPermission(TPermission permission);

    public void updateTPermission(TPermission permission);

    public void deleteTPermission(String id);

    public TPermission getTPermission(String id);

    public List<TPermission> getAllTPermission(final PageBean pageBean);

    public int getAllTPermissionCount();

    public List<TPermission> getAllPermission(); //get all permission except deleted

    public List<TPermission> searchPermission(TPermission permission, PageBean pageBean);

    public int getSearchCount(TPermission permission);

    public edu.cqu.no1.datamodel.TreeNode getFatherPermissionTree(String curFatherPermsId);
}
