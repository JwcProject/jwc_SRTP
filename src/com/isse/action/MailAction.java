/**
 * 
 */
package com.isse.action;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;

import com.isse.model.TEmail;
import com.isse.model.TEmailReceiver;
import com.isse.model.TTempEmailReciver;
import com.isse.model.TUser;
import com.isse.service.EmailReceiverService;
import com.isse.service.EmailService;
import com.isse.service.RoleService;
import com.isse.service.TempEmailReciverService;
import com.opensymphony.xwork2.ActionSupport;
import com.util.mail.MailSenderInfo;
import com.util.mail.SimpleMailSender;
import javax.mail.MessagingException;

/**
 * @author ming
 * 
 */
public class MailAction extends BaseAction {

	private String jqId;
	// private TEmail tEmail;
	private String qici;
	private String jieqiId;

	private String senderEmail;
	private String senderPassword;

	// 邮件主题
	private String emailTitle;
	// 邮件的文本内容
	private String emailContent;

	private TempEmailReciverService tempEmailReciverService;
	private EmailService emailService;
	private EmailReceiverService emailReceiverService;
	private RoleService roleService;

	// 发送邮件
	public String sendEmails() throws Exception {
		// 获取登录者的userID
		TUser user = getSessionUser();
		if (user == null || user.getUserId() == null
				|| user.getUserId().equals("")) {
			toLogin();
		}
		String teaCode = user.getUserId();
		SimpleMailSender sms = new SimpleMailSender(senderEmail, senderPassword);
		System.out.println(jieqiId);
		List<String> emailList = tempEmailReciverService.findEmailByJQid(
				jieqiId, teaCode, "01");
		List<TTempEmailReciver> tempEmailReceiverList = tempEmailReciverService
				.findTempEmailRecivers(jieqiId, teaCode, "01");
		List<String> recipients = new ArrayList<String>();
		recipients = emailList;

		// System.out.println(tEmail.getEmailContent());
		// TEmail email = new TEmail();
		// email = tEmail;
		/*
		 * recipients.add("342231033@qq.com");
		 * recipients.add("289505513@qq.com");
		 * recipients.add("1900830370@qq.com");
		 * recipients.add("1553085243@qq.com");
		 * recipients.add("695783730@qq.com");
		 * 
		 * recipients.add("472863897@qq.com");
		 * recipients.add("1343538047@qq.com");
		 * recipients.add("1039717808@qq.com");
		 * recipients.add("fly_wdw@126.com");
		 * recipients.add("xiaofa@gmail.com");
		 * 
		 * recipients.add("pzhnevermore@sina.com");
		 * recipients.add("luzhengfa88@163.com");
		 * recipients.add("fly_wdw@126.com");
		 * recipients.add("wdwmumu@gmail.com");
		 * recipients.add("wudaowen@baosight.com");
		 */
		TEmail tEmail = new TEmail();
		tEmail.setEmailTitle(emailTitle);
		tEmail.setEmailContent(emailContent);
		try {
			for (int i = 0; i < recipients.size(); ++i) {

				sms.send(recipients.get(i), emailTitle, emailContent);

				if (i == 0) {
					emailService.saveEmail(tEmail);
					TEmailReceiver tEmailReceiver = new TEmailReceiver();
					tEmailReceiver.setTEmail(tEmail);
					tEmailReceiver.setReceiverCode(tempEmailReceiverList.get(i)
							.getCode());

					tEmailReceiver.setReceiverRole(this.roleService
							.findRoleNameByUserId(tempEmailReceiverList.get(i)
									.getCode()));
					tEmailReceiver.setEmailAddress(recipients.get(i));
					emailReceiverService.saveEmailReceiver(tEmailReceiver);
				} else {
					TEmailReceiver tEmailReceiver = new TEmailReceiver();
					tEmailReceiver.setTEmail(tEmail);
					tEmailReceiver.setReceiverCode(tempEmailReceiverList.get(i)
							.getCode());
					tEmailReceiver.setReceiverRole(this.roleService
							.findRoleNameByUserId(tempEmailReceiverList.get(i)
									.getCode()));
					tEmailReceiver.setEmailAddress(recipients.get(i));
					emailReceiverService.saveEmailReceiver(tEmailReceiver);
				}

			}
			// sms.send(recipients, emailTitle, emailContent);

			// emailService.saveEmailAndReceiver(tEmail, tEmailReceiverList);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			return "error";
		}

	}

	/**
	 * 
	 *TODO 发布结题公告
	 *authoy lzh
	 *@return
	 *@throws Exception
	 */
	public String sendEnprojectEmail() throws Exception {
		// 获取登录者的userID
		TUser user = getSessionUser();
		if (user == null || user.getUserId() == null
				|| user.getUserId().equals("")) {
			toLogin();
		}
		String teaCode = user.getUserId();
		SimpleMailSender sms = new SimpleMailSender(senderEmail, senderPassword);
		List<String> emailList = tempEmailReciverService.findEmailByJQid(
				jieqiId, teaCode, "02");
		List<TTempEmailReciver> tempEmailReceiverList = tempEmailReciverService
				.findTempEmailRecivers(jieqiId, teaCode, "02");
		List<String> recipients = new ArrayList<String>();
		recipients = emailList;

		TEmail tEmail = new TEmail();
		tEmail.setEmailTitle(emailTitle);
		tEmail.setEmailContent(emailContent);
		try {
			for (int i = 0; i < recipients.size(); ++i) {
				sms.send(recipients.get(i), emailTitle, emailContent);
				if (i == 0) {
					emailService.saveEmail(tEmail);
					TEmailReceiver tEmailReceiver = new TEmailReceiver();
					tEmailReceiver.setTEmail(tEmail);
					tEmailReceiver.setReceiverCode(tempEmailReceiverList.get(i)
							.getCode());
					tEmailReceiver.setReceiverRole(this.roleService
							.findRoleNameByUserId(tempEmailReceiverList.get(i)
									.getCode()));
					tEmailReceiver.setEmailAddress(recipients.get(i));
					emailReceiverService.saveEmailReceiver(tEmailReceiver);
				} else {
					TEmailReceiver tEmailReceiver = new TEmailReceiver();
					tEmailReceiver.setTEmail(tEmail);
					tEmailReceiver.setReceiverCode(tempEmailReceiverList.get(i)
							.getCode());
					tEmailReceiver.setReceiverRole(this.roleService
							.findRoleNameByUserId(tempEmailReceiverList.get(i)
									.getCode()));
					tEmailReceiver.setEmailAddress(recipients.get(i));
					emailReceiverService.saveEmailReceiver(tEmailReceiver);
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("send endproject email failed" + e);
			return ERROR;
		}
	}

	public String getJqId() {
		return jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderPassword() {
		return senderPassword;
	}

	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}

	public String getEmailTitle() {
		return emailTitle;
	}

	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public TempEmailReciverService getTempEmailReciverService() {
		return tempEmailReciverService;
	}

	public void setTempEmailReciverService(
			TempEmailReciverService tempEmailReciverService) {
		this.tempEmailReciverService = tempEmailReciverService;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public EmailReceiverService getEmailReceiverService() {
		return emailReceiverService;
	}

	public void setEmailReceiverService(
			EmailReceiverService emailReceiverService) {
		this.emailReceiverService = emailReceiverService;
	}

	public String getJieqiId() {
		return jieqiId;
	}

	public void setJieqiId(String jieqiId) {
		this.jieqiId = jieqiId;
	}

	public String getQici() {
		return qici;
	}

	public void setQici(String qici) {
		this.qici = qici;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
