package com.isse.action;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.isse.model.TAnnounType;
import com.isse.model.TAnnouncement;
import com.isse.model.TAnnouncementModel;
import com.isse.model.TAttachment;
import com.isse.model.TUser;
import com.isse.service.AnnouncementService;
import com.isse.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;
import com.util.FileUtility;
import com.util.PageBean;

public class AnnouncementAction extends BaseAction {

	private AnnouncementService announcementService;
	private RoleService roleService;
	private TAnnouncement announcement;
	private List<TAnnouncementModel> listAnnouncementModels;
	private TAnnouncementModel announcementModel;
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
	
	public String listStuTeaAnnouncement() throws Exception {

		try {
		    //获取当前用户的id
		    tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			number = tUser.getUserId();
			
			this.totalNumber = this.announcementService
					.getStuTeaAnnouncementCount(number);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService
					.listStuTeaAnnouncements(number, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
		} catch (Exception e) {
			System.out.println("list student announcements exception:" + e);
			throw e;
		}
	}

	public String listUnitAnnouncement() throws Exception {
		try {
			
			 //获取当前用户(学院主管老师)的id
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			number = tUser.getUserId();
			this.totalNumber = this.announcementService.getUnitAnnouncementCount(number);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.listUnitAnnouncements(number, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
		} catch (Exception e) {
			System.out.println("list unit announcements exception:" + e);
			throw e;
		}
	}

	public String listSchoolAnnouncement() throws Exception {
		try {
			this.totalNumber = this.announcementService.getSchoolAnnouncementCount();
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.listSchoolAnnouncements(pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
			
		} catch (Exception e) {
			System.out.println("list school announcements exception:" + e);
			throw e;
		}
	}
	
	public String listSchoolLeaderAnnouncement() throws Exception {
		try {
			this.totalNumber = this.announcementService.getAnnounByTypeCount("教务处公告");
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.getAnnounByType("教务处公告", pageBean);
			totalPage = pageBean.getTotalPage();
		
				return "success";

			
		} catch (Exception e) {
			System.out.println("list school announcements exception:" + e);
			throw e;
		}
	}

	/**
	 * 
	 * TODO 老师或者学生查询本人公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryStuTeaAnnoun() throws Exception {
		try {
			//System.out.println("jdjdjdj");
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			number = tUser.getUserId();
			/*
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String timeString = sdf1.format(publishTime);
			System.out.println(timeString);
			Date timeDate = sdf1.parse(timeString);
			System.out.println(timeDate);
			publishTime = timeDate;*/
			
			this.totalNumber = this.announcementService.queryStuTeaAnnounCount(
					number, announTitle, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService
					.queryStuTeaAnnoun(number, announTitle, publishTime,
							pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}
	}

	/**
	 * 
	 * TODO 学院主管老师查询本学院的公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryUnitAnnoun() throws Exception {
		try {
			tUser = getSessionUser();
			number= tUser.getUserId();

			this.totalNumber = this.announcementService.queryUnitAnnounCount(
					number, announTitle, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.queryUnitAnnoun(
					number, announTitle, publishTime, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
		} catch (Exception e) {
			System.out.println("query Unit Announcement exception: " + e);
			throw e;
		}
	}

	/**
	 * 
	 * TODO 教务处主管教师以及教务处领导查询公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querySchoolAnnoun() throws Exception {
		try {
	//		System.out.println("123-->"+announTypeName);
			this.totalNumber = this.announcementService.querySchoolAnnounCount(announTitle, checkState, publishTime, publisherName, announTypeName);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.querySchoolAnnoun(announTitle, checkState, publishTime, publisherName,announTypeName, pageBean);
			totalPage = pageBean.getTotalPage();
			
			return "successTea";
			
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}
	}
	
	public String querySchoolLeaderAnnoun() throws Exception {
		try {
			
			announTypeName = "教务处公告";
			
			this.totalNumber = this.announcementService.querySchoolAnnounCount(
					announTitle, checkState, publishTime, publisherName, announTypeName);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService
					.querySchoolAnnoun(announTitle, checkState, publishTime, publisherName,
							announTypeName, pageBean);
			totalPage = pageBean.getTotalPage();
			
			return "success";
			
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}
	}

	/**
	 * 
	 *TODO 根据公告类别查询公告
	 *@return
	 *@throws Exception
	 */
	public String getAnnounByTypeName() throws Exception {
		try {
			this.totalNumber = this.announcementService
					.getAnnounByTypeCount(announTypeName);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.getAnnounByType(
					announTypeName, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
		} catch (Exception e) {
			System.out.println("query StuTea Announcement exception: " + e);
			throw e;
		}

	}

	private TAnnouncement saveFilesAndAnnouncement(TAnnouncement announcement)throws Exception{
    	TUser user = getSessionUser();
		if (user == null || user.getUserId() == null
				|| user.getUserId().equals("")) {
			toLogin();
		}
		if (files != null && filesFileName != null && filesContentType != null
				&& files.length == filesFileName.length
				&& filesFileName.length == filesContentType.length && files.length > 0) {
			List<String> fileUris = FileUtility.SaveFiles(files, filesFileName,
					filesContentType);
			if (fileUris != null && fileUris.size() > 0) {
				List<TAttachment> tAttachments = new ArrayList<TAttachment>();
				for (int i=0; i<fileUris.size(); i++) {
					TAttachment tAttachment = new TAttachment();
					tAttachment.setFileName(filesFileName[i]);
					tAttachment.setFileFormat(filesContentType[i]);
					tAttachment.setFileSize(new BigDecimal(files[i].length()));
					tAttachment.setFileUrl(fileUris.get(i));
					tAttachment.setTUser(user);
					tAttachments.add(tAttachment);
				}
				return this.announcementService.addTAnnouncement(tAttachments, announcement);
			}else{
				return null;
			}
		}else{
			return this.announcementService.addTAnnouncement(announcement);
		}
    }
	// 保存公告
	public String saveAnnouncement() throws Exception {
		try {
			
			if(announcement==null)
			{
				return "addError";
			}
			
			announcement.setPublishState("N");
			
			tUser = getSessionUser();
			if(null==tUser)
		    {
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
					
				   
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
			}
			else if (userType.equals("03") || userType.equals("02")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				  
				   return "unitSuccess";
					
			}
			else if (userType.equals("01") || userType.equals("00")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "schoolSuccess";
					
			}
			else {
				return "addError";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "addError";
		}
	}

	// 发布不用审核的公告
	public String commitAnnouncement() throws Exception {
		try {
			
			if(announcement==null)
			{
				return "addError";
			}
			

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

			publishTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间

			announcement.setPublishTime(publishTime);

			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			announcement.setPublisherCode(tUser.getUserId());
			String userType = tUser.getUserType();
			announcement.setPublisherRole(userType);
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("CY");
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
				   
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("CY");
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "personalSuccess";
					
			}
			else if (userType.equals("03") || userType.equals("02")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("CY");
				   announcement = saveFilesAndAnnouncement(announcement);
				  
				   return "unitSuccess";
					
			}
			else if (userType.equals("01") || userType.equals("00")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
				   announcement.setTAnnounType(tAnnounType);
				   announcement.setPublishState("Y");
				   announcement.setCheckState("NC");
				   announcement = saveFilesAndAnnouncement(announcement);
				   
				   return "schoolSuccess";
					
			}
			else {
				return "addError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "addError";
		}
	}

	// 发布需审核的公告
	/*public String commitCheckingAnnouncement() throws Exception {
		try {
			announcement.setPublishState("Y");

			announcement.setCheckState("NC");

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

			publishTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间

			announcement.setPublishTime(publishTime);

			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			announcement.setPublisherCode(tUser.getUserId());
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			String userType = tUser.getUserType();
			announcement.setPublisherRole(userType);
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学生公告");
				   announcement.setTAnnounType(tAnnounType);
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教师公告");
				   announcement.setTAnnounType(tAnnounType);
			}
			else if (userType.equals("03") || userType.equals("02")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("学院公告");
				   announcement.setTAnnounType(tAnnounType);
			}
			else if (userType.equals("01") || userType.equals("00")){
				   TAnnounType tAnnounType = this.announcementService.getTAnnounTypeByName("教务处公告");
				   announcement.setTAnnounType(tAnnounType);
			}

			announcement = saveFilesAndAnnouncement(announcement);

			if(announcement == null ){
				return "addError";
			}else {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "addError";
		}
	}*/

	// 发布已保存的公告
	public String commitSavedAnnouncement() throws Exception {
		try {
			
			announcement = this.announcementService.getAnnouncement(announId);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

			publishTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间

			announcement.setPublishTime(publishTime);
			
			announcement.setPublishState("Y");
			
			tUser = getSessionUser();
			if(null==tUser)
		    {
		    	toLogin();
		    }
			
			String userType = tUser.getUserType();
			if (userType.equals("06") || userType.equals("07") || userType.equals("08")) {
				   announcement.setCheckState("CY");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "personalSuccess";
					
				   
			} 
			else if (userType.equals("05") || userType.equals("04")){
				   announcement.setCheckState("CY");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "personalSuccess";
					
			}
			else if (userType.equals("03") || userType.equals("02")){
				   announcement.setCheckState("CY");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "unitSuccess";
					
			}
			else if (userType.equals("01") || userType.equals("00")){
				   announcement.setCheckState("NC");
				   this.announcementService.updateTAnnouncement(announcement);
				   return "schoolSuccess";
					
			}
			else {
				return "addError";
			}
			
		} catch (Exception e) {
			System.out.println("add exception: " + e.toString());

			return "updateError";
		}
	}

	// 审核公告
	public String checkAnnouncement() throws Exception {
		try {
			announcementModel = this.announcementService.getAnnounById(announId);
			return "success";
		} catch (Exception e) {
			return "checkError";
		}
	}

	// 审核不通过
	public String unpassedAnnouncement() throws Exception {
		try {
			announcement = this.announcementService.getAnnouncement(announId);
			
			announcement.setCheckState("CN");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
            checkTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间
            
            tUser = getSessionUser();
            
            announcement.setCheckerCode(tUser.getUserId());
            
            announcement.setCheckTime(checkTime);
			
			this.announcementService.updateTAnnouncement(announcement);

			return "success";
		} catch (Exception e) {
			System.out.println("update exception: " + e.toString());

			return "updateError";
		}
	}

	// 审核通过
	public String passedAnnouncement() throws Exception {
		try {
			
			announcement = this.announcementService.getAnnouncement(announId);
			
			announcement.setCheckState("CY");
			
			announcement.setPublishState("Y");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
            checkTime = df.parse(df.format(new Date()));// new Date()为获取当前系统时间
            
            tUser = getSessionUser();
            if(null==tUser)
		    {
		    	toLogin();
		    }
            
            announcement.setCheckerCode(tUser.getUserId());
            
            announcement.setCheckTime(checkTime);
			
			this.announcementService.updateTAnnouncement(announcement);

			return "success";
		} catch (Exception e) {
			System.out.println("update exception: " + e.toString());

			return "updateError";
		}
	}

	
	//查看公告
	public String viewAnnouncement() throws Exception 
	{
		try {
			announcementModel = this.announcementService.getAnnounById(announId);
			attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
			return "success";
		} catch (Exception e) {
			return "viewError";
		}
	}
	
	//登录页面的查看公告
	public String viewLoginAnnouncement() throws Exception 
	{
		try {
			announcementModel = this.announcementService.getAnnounById(announId);
			attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
			return "success";
		} catch (Exception e) {
			return "viewError";
		}
	}

	
	//查看编辑公告
	public String editAnnouncement() throws Exception
	{
		try
		{
			announcement = this.announcementService.getAnnouncement(announId);
			attachments = this.announcementService.getAttachmentsByAnnounceId(announId);
			return "success";
		}
		catch(Exception e)
		{
			return "editError";
		}
	}
	
	//保存编辑公告
	public String updateAnnouncement() throws Exception
	{
		try
		{
			//System.out.println("a");
			TUser user = getSessionUser();
			if (user == null || user.getUserId() == null
					|| user.getUserId().equals("")) {
				toLogin();
			}
            announcement = this.announcementService.getAnnouncement(announId);
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
					}					
					List<String> fileUris = FileUtility.SaveFiles(files,
							filesFileName, filesContentType);
					if (fileUris != null && fileUris.size() > 0) {
						List<TAttachment> newAttachments = new ArrayList<TAttachment>();
						for (int i=0; i<fileUris.size(); i++) {
							TAttachment tAttachment = new TAttachment();
							tAttachment.setFileName(filesFileName[i]);
							tAttachment.setFileFormat(filesContentType[i]);
							tAttachment.setFileSize(new BigDecimal(files[i].length()));
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
			}
			else if ( userType.equals("00") || userType.equals("01")) {
				return "successSchool";
			}
			else {
				return "successStuTea";
			}
			
		} catch (Exception e) {
			System.out.println("update exception: " + e.toString());

			return "updateError";
		}
	}

	
	//删除公告
	public String deleteAnnouncement() throws Exception
	{
		try
		{

			announcement = this.announcementService.getAnnouncement(announId);
			
			announcement.setIsdeleted("Y");
			
			//String a = announcement.getTAnnounType().getAnnounTypeName();
			
			this.announcementService.updateTAnnouncement(announcement);
			
			tUser = getSessionUser();
			if(null==tUser)
			{
				toLogin();
			}
			String userType = tUser.getUserType();
			//String roleName = this.roleService.findRoleNameByUserId(tUser.getUserId());
			
			if (userType.equals("02") || userType.equals("03") || userType.equals("04") || userType.equals("05")) {
				return "successUnit";
			}
			else if ( userType.equals("00") || userType.equals("01")) {
				return "successSchool";
			}
			else {
				return "successStuTea";
			}
			
		} catch (Exception e) {
			return "deleteError";
		}
	}
	
	
	//教务处公告
	public String listIndexDeanAnnouncement() throws Exception {
		try {
			//获取当前用户的id
		    tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.getAnnounByTypeCount("教务处公告");
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.getAnnounByType("教务处公告", pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "listError";
		}
	}
	
	//学院公告
	public String listIndexUnitAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
		    String stuCode = tUser.getUserId();
			this.totalNumber = this.announcementService.getTAnnouncementByStuCodeCount(stuCode);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.getTAnnouncementByStuCode(stuCode, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "listError";
		}
	}
	
	//普通教师及学生公告
	public String listCommonAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.getCommonStuAndTeaAnnounCount();
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.getCommonStuAndTeaAnnoun(pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "listError";
		}
	}

	//查询教务处公告
	public String findIndexDeanAnnouncement() throws Exception {
		try {
			//获取当前用户的id
		    tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.findIndexSchoolAnnoumentCount(announTitle, publishTime, "教务处公告");
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncementModels = this.announcementService.findIndexSchoolAnnoument(announTitle, publishTime, "教务处公告", pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "listError";
		}
	}
	
	//查询学院公告
	public String findIndexUnitAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
		    String stuCode = tUser.getUserId();
			this.totalNumber = this.announcementService.findTAnnouncementByStuCodeCount(stuCode, announTitle, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.findTAnnouncementByStuCode(stuCode, announTitle, publishTime, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "listError";
		}
	}
	
	//查询普通教师及学生公告
	public String findCommonAnnouncement() throws Exception {
		try {
			tUser = getSessionUser();
		    if(null==tUser)
		    {
		    	toLogin();
		    }
			this.totalNumber = this.announcementService.findCommonStuAndTeaAnnounCount(announTitle, announContent, publishTime);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			listAnnouncements = this.announcementService.findCommonStuAndTeaAnnoun(announTitle, announContent, publishTime, pageBean);
			totalPage = pageBean.getTotalPage();
			return "success";			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "listError";
		}
	}
	/*****************************************************
	 * get & set methods
	 * *************************************************/

	public String getAnnounId() {
		return announId;
	}

	public List<TAnnouncementModel> getListAnnouncementModels() {
		return listAnnouncementModels;
	}

	public void setListAnnouncementModels(
			List<TAnnouncementModel> listAnnouncementModels) {
		this.listAnnouncementModels = listAnnouncementModels;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public void setAnnounId(String announId) {
		this.announId = announId;
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public TAnnouncement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(TAnnouncement announcement) {
		this.announcement = announcement;
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

	public TAnnouncementModel getAnnouncementModel() {
		return announcementModel;
	}

	public void setAnnouncementModel(TAnnouncementModel announcementModel) {
		this.announcementModel = announcementModel;
	}

	public TAnnounType getTAnnounType() {
		return TAnnounType;
	}

	public void setTAnnounType(TAnnounType tAnnounType) {
		TAnnounType = tAnnounType;
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

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public TUser gettUser() {
		return tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}
	
	
}
