package edu.cqu.no1.action;

import edu.cqu.no1.domain.TAnnouncement;
import edu.cqu.no1.domain.TAttachment;
import edu.cqu.no1.domain.TAnnounType;
import edu.cqu.no1.domain.TUser;
import edu.cqu.no1.service.AnnouncementService;
import edu.cqu.no1.service.RoleService;
import edu.cqu.no1.util.FileUtility;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class AnnouncementAction extends BaseAction {

    @Resource
    private AnnouncementService announcementService;
    @Resource
    private RoleService roleService;

    private TAnnouncement announcement;
    private List<TAnnouncement> listAnnouncement;
    private TAnnouncement announcementModel;
    private List<TAttachment> attachments;
    private String attachementId;

    private TUser tUser;
    private String number;// 学生学号，指导老师教职工号，教务处主管老师教职工号
    private String announId;
    private String announTitle;
    private String announContent;


    private String publishState;
    private Date publishTime;
    private TAnnounType TAnnounType;

    private String checkerCode;
    private Date checkTime;
    private String checkState;

    private String publisherName;
    private String announTypeName;
    private List<TAnnouncement> listAnnouncements;


    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数
    private int pageCapacity = 14; // 每页显示条数

    // 上传文件 数组
    private File[] files;
    private String[] filesContentType;
    private String[] filesFileName;


    /**
     * 查询学生老师个人公告
     * @return
     * @throws Exception
     */
    @Action(value = "findStuTeaAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/person_announ_list.jsp")
    })
    public String queryStuTeaAnnoun() throws Exception {
        try {
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            number = tUser.getUserId();

            this.totalNumber = this.announcementService.queryStuTeaAnnounCount(
                    number, announTitle, publishTime);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncement = this.announcementService
                    .queryStuTeaAnnoun(number, announTitle, publishTime,
                            pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("query StuTea Announcement exception: " + e);
            throw e;
        }
    }


    /**
     * 查询学院公告
     * @return
     * @throws Exception
     */
    @Action(value = "findUnitAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/unit_announ_list.jsp")
    })
    public String queryUnitAnnoun() throws Exception {
        try {
            tUser = getSessionUser();
            if (tUser == null) {
                toLogin();
            }

            number = tUser.getUserId();

            this.totalNumber = this.announcementService.queryUnitAnnounCount(
                    number, announTitle, publishTime);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncement = this.announcementService.queryUnitAnnoun(
                    number, announTitle, publishTime, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("query Unit Announcement exception: " + e);
            throw e;
        }
    }


    /**
     * 查询教务处公告
     * @return
     * @throws Exception
     */
    @Action(value = "findDeanAnnoun", results = {
            @Result(name = "success", location = "/pages/announManage/schoolLeader_announ_list.jsp")
    })
    public String queryDeanAnnoun() throws Exception {
        try {

            announTypeName = "教务处公告";

            this.totalNumber = this.announcementService.querySchoolAnnounCount(
                    announTitle, checkState, publishTime, publisherName, announTypeName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncement = this.announcementService
                    .querySchoolAnnoun(announTitle, checkState, publishTime, publisherName,
                            announTypeName, pageBean);
            totalPage = pageBean.getTotalPage();

            return SUCCESS;

        } catch (Exception e) {
            System.out.println("query StuTea Announcement exception: " + e);
            throw e;
        }
    }


    /**
     * 查询全校公告
     * @return
     * @throws Exception
     */
    @Action(value = "findSchoolAnnoun", results = {
            @Result(name = "successTea", location = "/pages/announManage/schoolTea_announ_list.jsp"),
            @Result(name = "successLeader", location = "/pages/announManage/schoolLeader_announ_list.jsp")
    })
    public String querySchoolAnnoun() throws Exception {
        try {

            tUser = getSessionUser();
            if (tUser == null) {
                toLogin();
            }


            this.totalNumber = this.announcementService.querySchoolAnnounCount(announTitle, checkState, publishTime, publisherName, announTypeName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncement = this.announcementService.querySchoolAnnoun(announTitle, checkState, publishTime, publisherName, announTypeName, pageBean);
            totalPage = pageBean.getTotalPage();

            String userType = tUser.getUserType();
            if (userType.equals("00") || userType.equals("02"))
                return "successLeader";
            return "successTea";

        } catch (Exception e) {
            System.out.println("query StuTea Announcement exception: " + e);
            throw e;
        }
    }


    /**
     * 根据公告类别查询公告
     */
    public String getAnnounByTypeName() throws Exception {
        try {
            this.totalNumber = this.announcementService
                    .getAnnounByTypeCount(announTypeName);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncement = this.announcementService.getAnnounByType(
                    announTypeName, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("query StuTea Announcement exception: " + e);
            throw e;
        }

    }


    /**
     * 发布不用审核的公告
     * @return
     * @throws Exception
     */
    @Action(value = "CommitAnnouncement", results = {
            @Result(name = "personalSuccess", type = "redirect", location = "findStuTeaAnnoun"),
            @Result(name = "unitSuccess", type = "redirect", location = "findUnitAnnoun"),
            @Result(name = "schoolSuccess", type = "redirect", location = "findSchoolAnnoun")
    })
    public String commitAnnouncement() throws Exception {
        try {

            if (announcement == null) {
                return ERROR;
            }

            announcement.setPublishTime(new Timestamp(System.currentTimeMillis()));

            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }

            //String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
            announcement.setPublisherCode(tUser.getUserId());
            announcement.setPublisherName(tUser.getUserName());
            String userType = tUser.getUserType();
            announcement.setPublisherRole(userType);
            announcement.setIsdeleted("N");
            if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
                announcement.setTAnnounType(tAnnounType);
                announcement.setPublishState("Y");
                announcement.setCheckState("CY");
                announcement = saveFilesAndAnnouncement(announcement);

                return "personalSuccess";

            } else if (userType.equals("05") || userType.equals("04")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
                announcement.setTAnnounType(tAnnounType);
                announcement.setPublishState("Y");
                announcement.setCheckState("CY");
                announcement = saveFilesAndAnnouncement(announcement);

                return "personalSuccess";

            } else if (userType.equals("03") || userType.equals("02")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
                announcement.setTAnnounType(tAnnounType);
                announcement.setPublishState("Y");
                announcement.setCheckState("CY");
                announcement = saveFilesAndAnnouncement(announcement);

                return "unitSuccess";

            } else if (userType.equals("01") || userType.equals("00")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
                announcement.setTAnnounType(tAnnounType);
                announcement.setPublishState("Y");
                announcement.setCheckState("NC");
                announcement = saveFilesAndAnnouncement(announcement);

                return "schoolSuccess";

            } else {
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * 发布需审核的公告
     * @return
     * @throws Exception
     */
    @Action(value = "CommitCheckingAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_commit.jsp")
    })
    public String commitCheckingAnnouncement() throws Exception {
        try {
            announcement.setPublishState("Y");
            announcement.setCheckState("NC");
            announcement.setPublishTime(new Timestamp(System.currentTimeMillis()));
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            announcement.setPublisherCode(tUser.getUserId());
            announcement.setPublisherName(tUser.getUserName());
            //String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
            String userType = tUser.getUserType();
            announcement.setPublisherRole(userType);
            if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
                announcement.setTAnnounType(tAnnounType);
            } else if (userType.equals("05") || userType.equals("04")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
                announcement.setTAnnounType(tAnnounType);
            } else if (userType.equals("03") || userType.equals("02")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
                announcement.setTAnnounType(tAnnounType);
            } else if (userType.equals("01") || userType.equals("00")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
                announcement.setTAnnounType(tAnnounType);
            }

            announcement = saveFilesAndAnnouncement(announcement);

            if (announcement == null) {
                return ERROR;
            } else {
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 保存公告和附件的帮助方法
     * @param announcement
     * @return
     * @throws Exception
     */
    private TAnnouncement saveFilesAndAnnouncement(TAnnouncement announcement) throws Exception {
        TUser user = getSessionUser();
        if (user == null) {
            toLogin();
        }
        if (files != null && filesFileName != null && filesContentType != null
                && files.length == filesFileName.length
                && filesFileName.length == filesContentType.length && files.length > 0) {
            List<String> fileUris = FileUtility.SaveFiles(files, filesFileName,
                    filesContentType);
            if (fileUris != null && fileUris.size() > 0) {
                List<TAttachment> tAttachments = new ArrayList<TAttachment>();
                for (int i = 0; i < fileUris.size(); i++) {
                    TAttachment tAttachment = new TAttachment();
                    tAttachment.setFileName(filesFileName[i]);
                    tAttachment.setFileFormat(filesContentType[i]);
                    tAttachment.setFileSize(new Double(files[i].length()));
                    tAttachment.setFileUrl(fileUris.get(i));
                    tAttachment.setTUser(user);
                    tAttachments.add(tAttachment);
                }
                return this.announcementService.addTAnnouncement(tAttachments, announcement);
            } else {
                return null;
            }
        } else {
            return this.announcementService.addTAnnouncement(announcement);
        }
    }


    /**
     * 保存公告
     * @return
     * @throws Exception
     */
    @Action(value = "SaveAnnouncement", results = {
            @Result(name = "personalSuccess", type = "redirect", location = "findStuTeaAnnoun"),
            @Result(name = "unitSuccess", type = "redirect", location = "findUnitAnnoun"),
            @Result(name = "schoolSuccess", type = "redirect", location = "findSchoolAnnoun")
    })
    public String saveAnnouncement() throws Exception {
        try {

            if (announcement == null) {
                return ERROR;
            }

            announcement.setPublishState("N");

            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            announcement.setPublisherCode(tUser.getUserId());
            String userType = tUser.getUserType();
            announcement.setPublisherRole(userType);


            if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
                announcement.setTAnnounType(tAnnounType);
                announcement = saveFilesAndAnnouncement(announcement);

                return "personalSuccess";


            } else if (userType.equals("05") || userType.equals("04")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
                announcement.setTAnnounType(tAnnounType);
                announcement = saveFilesAndAnnouncement(announcement);

                return "personalSuccess";

            } else if (userType.equals("03") || userType.equals("02")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
                announcement.setTAnnounType(tAnnounType);
                announcement = saveFilesAndAnnouncement(announcement);

                return "unitSuccess";

            } else if (userType.equals("01") || userType.equals("00")) {
                TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
                announcement.setTAnnounType(tAnnounType);
                announcement = saveFilesAndAnnouncement(announcement);

                return "schoolSuccess";

            } else {
                return ERROR;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * 发布已保存的公告
     * @return
     * @throws Exception
     */
    @Action(value = "CommitSavedAnnouncement", results = {
            @Result(name = "personalSuccess", type = "redirect", location = "findStuTeaAnnoun"),
            @Result(name = "unitSuccess", type = "redirect", location = "findUnitAnnoun"),
            @Result(name = "schoolSuccess", type = "redirect", location = "findSchoolAnnoun")
    })
    public String commitSavedAnnouncement() throws Exception {
        try {
            announcement = this.announcementService.getAnnounById(announId);
            announcement.setPublishTime(new Timestamp(System.currentTimeMillis()));
            announcement.setPublishState("Y");
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            String userType = tUser.getUserType();
            if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
                announcement.setCheckState("CY");
                this.announcementService.updateTAnnouncement(announcement);
                return "personalSuccess";

            } else if (userType.equals("05") || userType.equals("04")) {
                announcement.setCheckState("CY");
                this.announcementService.updateTAnnouncement(announcement);
                return "personalSuccess";

            } else if (userType.equals("03") || userType.equals("02")) {
                announcement.setCheckState("CY");
                this.announcementService.updateTAnnouncement(announcement);
                return "unitSuccess";

            } else if (userType.equals("01") || userType.equals("00")) {
                announcement.setCheckState("NC");
                this.announcementService.updateTAnnouncement(announcement);
                return "schoolSuccess";

            } else {
                return ERROR;
            }

        } catch (Exception e) {
            System.out.println("add exception: " + e.toString());

            return ERROR;
        }
    }


    /**
     * 审核公告
     * @return
     * @throws Exception
     */
    @Action(value = "CheckAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_check.jsp")
    })
    public String checkAnnouncement() throws Exception {
        try {
            announcementModel = this.announcementService.getAnnounById(announId);
            attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 审核不通过
     * @return
     * @throws Exception
     */
    @Action(value = "UnpassedAnnouncement", results = {
            @Result(name = "success", type = "redirect", location = "findDeanAnnoun")
    })
    public String unpassedAnnouncement() throws Exception {
        try {
            announcement = this.announcementService.getAnnounById(announId);
            announcement.setCheckState("CN");
            tUser = getSessionUser();
            announcement.setCheckerCode(tUser.getUserId());
            announcement.setCheckTime(new Timestamp(System.currentTimeMillis()));
            this.announcementService.updateTAnnouncement(announcement);

            return SUCCESS;
        } catch (Exception e) {
            System.out.println("update exception: " + e);
            return ERROR;
        }
    }


    /**
     * 审核通过
     * @return
     * @throws Exception
     */
    @Action(value = "PassedAnnouncement", results = {
            @Result(name = "success", type = "redirect", location = "findDeanAnnoun")
    })
    public String passedAnnouncement() throws Exception {
        try {

            announcement = this.announcementService.getAnnounById(announId);

            announcement.setCheckState("CY");

            announcement.setPublishState("Y");

            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }

            announcement.setCheckerCode(tUser.getUserId());

            announcement.setCheckTime(new Timestamp(System.currentTimeMillis()));

            this.announcementService.updateTAnnouncement(announcement);

            return SUCCESS;
        } catch (Exception e) {
            System.out.println("update exception: " + e.toString());

            return ERROR;
        }
    }


    /**
     * 查看主页的公告详情
     * @return
     * @throws Exception
     */
    @Action(value = "ViewAnnouncement", results = {
            @Result(name = SUCCESS, location = "/pages/announManage/announ_view.jsp")
    })
    public String viewAnnouncement() throws Exception {
        try {
            announcementModel = this.announcementService.getAnnounById(announId);
            attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "ViewLoginAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_login_view.jsp")
    })
    public String viewLoginAnnouncement() throws Exception {
        try {
            announcementModel = this.announcementService.getAnnounById(announId);
            attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * 编辑公告
     * @return
     * @throws Exception
     */
    @Action(value = "EditAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/announ_edit.jsp")
    })
    public String editAnnouncement() throws Exception {
        try {
            announcement = this.announcementService.getAnnounById(announId);
            attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 保存编辑的公告
     * @return
     * @throws Exception
     */
    @Action(value = "UpdateAnnouncement", results = {
            @Result(name = "successStuTea", type = "redirect", location = "findStuTeaAnnoun"),
            @Result(name = "successUnit", type = "redirect", location = "findUnitAnnoun"),
            @Result(name = "successSchool", type = "redirect", location = "findSchoolAnnoun")
    })
    public String updateAnnouncement() throws Exception {
        try {
            TUser user = getSessionUser();
            if (user == null) {
                toLogin();
            }
            announcement = this.announcementService.getAnnounById(announId);
            announcement.setAnnounContent(announContent);
            announcement.setAnnounTitle(announTitle);
            if (files != null && files.length > 0) {
                if (files != null && filesFileName != null
                        && filesContentType != null
                        && files.length == filesFileName.length
                        && filesFileName.length == filesContentType.length) {
                    List<TAttachment> tAttachments = this.announcementService.getAttachmentsByAnnounceId(announId);
                    for (TAttachment tAttachment : tAttachments) {
                        FileUtility.DeleteFile(tAttachment.getFileUrl());
                        tAttachment.setIsdeleted("Y");
                    }
                    List<String> fileUris = FileUtility.SaveFiles(files,
                            filesFileName, filesContentType);
                    if (fileUris != null && fileUris.size() > 0) {
                        List<TAttachment> newAttachments = new ArrayList<TAttachment>();
                        for (int i = 0; i < fileUris.size(); i++) {
                            TAttachment tAttachment = new TAttachment();
                            tAttachment.setFileName(filesFileName[i]);
                            tAttachment.setFileFormat(filesContentType[i]);
                            tAttachment.setFileSize(new Double(files[i].length()));
                            tAttachment.setFileUrl(fileUris.get(i));
                            tAttachment.setTUser(user);
                            newAttachments.add(tAttachment);
                        }
                        this.announcementService.updateTAnnouncement(newAttachments, announcement);
                    }
                }
            } else {
                this.announcementService.updateTAnnouncement(announcement);
            }
            //String a = announcement.getTAnnounType().getAnnounTypeName();


            String userType = user.getUserType();
            //String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());

            if (userType.equals("02") || userType.equals("03") || userType.equals("04") || userType.equals("05")) {
                return "successUnit";
            } else if (userType.equals("00") || userType.equals("01")) {
                return "successSchool";
            } else {
                return "successStuTea";
            }

        } catch (Exception e) {
            System.out.println("update exception: " + e.toString());

            return ERROR;
        }
    }


    /**
     * 删除公告
     * @return
     * @throws Exception
     */
    @Action(value = "DeleteAnnouncement", results = {
            @Result(name = "successStuTea", type = "redirect", location = "findStuTeaAnnoun"),
            @Result(name = "successUnit", type = "redirect", location = "findUnitAnnoun"),
            @Result(name = "successSchool", type = "redirect", location = "findDeanAnnoun")
    })
    public String deleteAnnouncement() throws Exception {
        try {

            announcementService.deleteTAnnouncement(announId);
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            String userType = tUser.getUserType();
            if (userType.equals("02") || userType.equals("03") || userType.equals("04") || userType.equals("05")) {
                return "successUnit";
            } else if (userType.equals("00") || userType.equals("01")) {
                return "successSchool";
            } else {
                return "successStuTea";
            }

        } catch (Exception e) {
            return ERROR;
        }
    }


    @Action(value = "findCommonAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexCommonAnnounList.jsp")
    })


    /**
     * 查询主页公告 普通教师及学生
     */
    public String findCommonAnnouncement() throws Exception {
        try {
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            this.totalNumber = this.announcementService.findCommonStuAndTeaAnnounCount(announTitle, announContent, publishTime);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncements = this.announcementService.findCommonStuAndTeaAnnoun(announTitle, announContent, publishTime, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ERROR;
        }
    }



    /**
     * 查询主页公告 学院
     */
    @Action(value = "findIndexUnitAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexUnitAnnounList.jsp")
    })
    public String findIndexUnitAnnouncement() throws Exception {
        try {
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            String stuCode = tUser.getUserId();
            this.totalNumber = this.announcementService.findTAnnouncementByStuCodeCount(stuCode, announTitle, publishTime);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncements = this.announcementService.findTAnnouncementByStuCode(stuCode, announTitle, publishTime, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * 查询主页公告 教务处
     */
    @Action(value = "findIndexDeanAnnouncement", results = {
            @Result(name = "success", location = "/pages/announManage/indexSchoolAnnounList.jsp")
    })
    public String findIndexDeanAnnouncement() throws Exception {
        try {
            //获取当前用户的id
            tUser = getSessionUser();
            if (null == tUser) {
                toLogin();
            }
            this.totalNumber = this.announcementService.findIndexSchoolAnnoumentCount(announTitle, publishTime, "教务处公告");
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            listAnnouncement = this.announcementService.findIndexSchoolAnnoument(announTitle, publishTime, "教务处公告", pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }

    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public TAnnouncement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(TAnnouncement announcement) {
        this.announcement = announcement;
    }

    public List<TAnnouncement> getListAnnouncement() {
        return listAnnouncement;
    }

    public void setListAnnouncement(List<TAnnouncement> listAnnouncement) {
        this.listAnnouncement = listAnnouncement;
    }

    public TAnnouncement getAnnouncementModel() {
        return announcementModel;
    }

    public void setAnnouncementModel(TAnnouncement announcementModel) {
        this.announcementModel = announcementModel;
    }

    public List<TAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<TAttachment> attachments) {
        this.attachments = attachments;
    }

    public String getAttachementId() {
        return attachementId;
    }

    public void setAttachementId(String attachementId) {
        this.attachementId = attachementId;
    }

    public TUser gettUser() {
        return tUser;
    }

    public void settUser(TUser tUser) {
        this.tUser = tUser;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAnnounId() {
        return announId;
    }

    public void setAnnounId(String announId) {
        this.announId = announId;
    }

    public String getAnnounTitle() {
        return announTitle;
    }

    public void setAnnounTitle(String announTitle) {
        this.announTitle = announTitle;
    }

    public String getAnnounContent() {
        return announContent;
    }

    public void setAnnounContent(String announContent) {
        this.announContent = announContent;
    }

    public String getPublishState() {
        return publishState;
    }

    public void setPublishState(String publishState) {
        this.publishState = publishState;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public TAnnounType getTAnnounType() {
        return TAnnounType;
    }

    public void setTAnnounType(TAnnounType TAnnounType) {
        this.TAnnounType = TAnnounType;
    }

    public String getCheckerCode() {
        return checkerCode;
    }

    public void setCheckerCode(String checkerCode) {
        this.checkerCode = checkerCode;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAnnounTypeName() {
        return announTypeName;
    }

    public void setAnnounTypeName(String announTypeName) {
        this.announTypeName = announTypeName;
    }

    public List<TAnnouncement> getListAnnouncements() {
        return listAnnouncements;
    }

    public void setListAnnouncements(List<TAnnouncement> listAnnouncements) {
        this.listAnnouncements = listAnnouncements;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getPageCapacity() {
        return pageCapacity;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public String[] getFilesContentType() {
        return filesContentType;
    }

    public void setFilesContentType(String[] filesContentType) {
        this.filesContentType = filesContentType;
    }

    public String[] getFilesFileName() {
        return filesFileName;
    }

    public void setFilesFileName(String[] filesFileName) {
        this.filesFileName = filesFileName;
    }


}
