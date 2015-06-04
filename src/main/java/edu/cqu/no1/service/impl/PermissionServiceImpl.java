package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TPermissionDAO;
import edu.cqu.no1.datamodel.TreeNode;
import edu.cqu.no1.domain.TPermission;
import edu.cqu.no1.service.PermissionService;
import edu.cqu.no1.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class PermissionServiceImpl implements PermissionService {

    private TPermissionDAO tPermissionDAO;

    public TPermissionDAO gettPermissionDAO() {
        return tPermissionDAO;
    }

    public void settPermissionDAO(TPermissionDAO tPermissionDAO) {
        this.tPermissionDAO = tPermissionDAO;
    }

    @Override
    public void addTPermission(TPermission permission) {
        this.tPermissionDAO.save(permission);
    }

    @Override
    public void updateTPermission(TPermission permission) {
        this.tPermissionDAO.merge(permission);
    }

    @Override
    public void deleteTPermission(String id) {
        TPermission tPermission = this.tPermissionDAO.findById(id);
        tPermission.setIsdeleted("Y");
        this.tPermissionDAO.merge(tPermission);
    }

    @Override
    public TPermission getTPermission(String id) {
        return this.tPermissionDAO.findById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TPermission> getAllTPermission(PageBean pageBean) {
        return this.tPermissionDAO.findAll(pageBean);
    }

    @Override
    public int getAllTPermissionCount() {
        return this.tPermissionDAO.getAllTPermissionCount();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TPermission> getAllPermission() {
        // TODO Auto-generated method stub
        return this.tPermissionDAO.findAllExceptDeleted();
    }

    /**
     * lsp
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TPermission> searchPermission(TPermission permission, PageBean pageBean) {
        return this.tPermissionDAO.seachPermission(permission, pageBean);
    }

    @Override
    public int getSearchCount(TPermission permission) {
        return this.tPermissionDAO.getSearchCount(permission);
    }

    @Override
    public TreeNode getFatherPermissionTree(String curFatherPermsId) {
        TreeNode root = new TreeNode();
        TPermission tPermission = (TPermission) this.tPermissionDAO.getChildPermissionsById(null).get(0);
        root.setId(tPermission.getPermissionId());
        root.setText(tPermission.getPermissionName());
        if (null != curFatherPermsId && curFatherPermsId.equals(tPermission.getPermissionId())) {
            root.setChecked(true);
        }
        getChildPermsItem(root, curFatherPermsId);
        return root;
    }

    @SuppressWarnings("unchecked")
    private void getChildPermsItem(TreeNode node, String curFatherPermsId) {
        List<TreeNode> children = new ArrayList<TreeNode>();
        List<TPermission> permissions = this.tPermissionDAO.getChildPermissionsById(node.getId());
        for (TPermission tPermission : permissions) {
            TreeNode child = new TreeNode();
            child.setId(tPermission.getPermissionId());
            child.setText(tPermission.getPermissionName());
            if (null != curFatherPermsId && curFatherPermsId.equals(tPermission.getPermissionId())) {
                child.setChecked(true);
            }
            getChildPermsItem(child, curFatherPermsId);
            children.add(child);
        }
        node.setChildren(children);
    }
}
