package edu.cqu.no1.service.impl;


import com.opensymphony.xwork2.ActionContext;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.*;
import edu.cqu.no1.service.EmailService;
import edu.cqu.no1.util.mail.MailAuthenticator;
import edu.cqu.no1.util.mail.MailInfo;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    TEmailDAO tEmailDAO;

    @Resource
    TEmailReceiverDAO tEmailReceiverDAO;


    @Resource
    TJieqiDAO tJieqiDAO;

    @Resource
    TTeacherDAO tTeacherDAO;

    @Override
    public boolean saveEmail(MailInfo mailInfo, boolean sendState) {
        TEmail email = new TEmail();
        List jieqiList = tJieqiDAO.getJieqiByYear(mailInfo.getJieqiYear());
        if(jieqiList.size() == 0){
            return false;
        }
        TJieqi jieqi = (TJieqi) jieqiList.get(0);
        email.setTJieqi(jieqi);

        TUser user = (TUser) ActionContext.getContext().getSession().get("user");
        if (user == null) {
            return false;
        }
        List teacherList = tTeacherDAO.findTeacherByCode(user.getUserId());
        if (teacherList.size() == 0) {
            return false;
        }
        TTeacher teacher = (TTeacher) teacherList.get(0);

        email.setTTeacher(teacher);
        email.setEmailTitle(mailInfo.getSubject());
        email.setEmailContent(mailInfo.getContent());
        email.setSender(mailInfo.getFromAddress());
        email.setEmailSecret(mailInfo.getPassword());
        email.setCreatOn(new Timestamp(System.currentTimeMillis()));
        email.setSendOn(new Timestamp(System.currentTimeMillis()));
        email.setSendState(String.valueOf(sendState));
        email.setIsdeleted("N");
        tEmailDAO.save(email);


        TEmailReceiver receiver = new TEmailReceiver();
        receiver.setTEmail(email);
        List receiverList = tTeacherDAO.findByTeaEmail(mailInfo.getToAddress());
        if (receiverList.size() == 0) {
            return false;
        }
        TTeacher receiverTea = (TTeacher) receiverList.get(0);

        receiver.setReceiverCode(receiverTea.getTeaCode());

        receiver.setEmailAddress(mailInfo.getToAddress());
        receiver.setIsReceived(String.valueOf(sendState));
        receiver.setIsdeleted("N");

        tEmailReceiverDAO.save(receiver);
        return true;
    }


    /**
     * 根据邮件信息发送邮件
     *
     * @param mailInfo
     * @return
     */
    @Override
    public boolean sendMail(MailInfo mailInfo) {
        String[] fromAddressInfo = mailInfo.getFromAddress().split("@");
        //发送方登录服务器的用户名及密码
        String userName = fromAddressInfo[0];
        String password = mailInfo.getPassword();
        //发送方及接收者的邮箱地址
        String fromAddress = mailInfo.getFromAddress();
//        String toAddress = mailInfo.getToAddress();
        String[] toAddress=mailInfo.getToAddress().split(",");
        //邮件主题、内容及附件
        String subject = mailInfo.getSubject();
        String content = mailInfo.getContent();
        String[] attachFileNames = mailInfo.getAttachFileNames();

        mailInfo.setMailServerHost("smtp." + fromAddressInfo[1]);
        mailInfo.setUserName(userName);


        //获取邮件Session所需的Properties对象
        Properties props = mailInfo.getProperties();
        MailAuthenticator authenticator = new MailAuthenticator(userName, password);
        //创建Session对象
        Session session = Session.getDefaultInstance(props, authenticator);

        try {
            //构造MimeMessage并设置相关属性值
            MimeMessage msg = new MimeMessage(session);
            //设置发件人
            msg.setFrom(new InternetAddress(fromAddress));
            //设置收件人
            InternetAddress[] addresses=new InternetAddress[toAddress.length];
            for(int i=0;i<toAddress.length;i++){
                addresses[i]=new InternetAddress(toAddress[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addresses);
            //设置邮件主题
            //subject = mailInfo.transferChinese(subject);
            msg.setSubject(subject);
            //构造Multipart
            Multipart mp = new MimeMultipart();
            //向Multipart添加正文
            MimeBodyPart mbpContent = new MimeBodyPart();
            mbpContent.setText(content);
            //将BodyPart添加到MultiPart中
            mp.addBodyPart(mbpContent);
            //向Multipart添加附件
            //遍历附件列表，将所有文件添加到邮件消息里
            for (String efile : attachFileNames) {
                MimeBodyPart mbpFile = new MimeBodyPart();
                //以文件名创建FileDataSource对象
                FileDataSource fds = new FileDataSource(efile);
                //处理附件
                mbpFile.setDataHandler(new DataHandler(fds));
                mbpFile.setFileName(fds.getName());
                //将BodyPart添加到MultiPart中
                mp.addBodyPart(mbpFile);
            }
            //清空附件列表
            attachFileNames = new String[]{};
            //向Multipart添加MimeMessage
            msg.setContent(mp);
            //设置发送日期
            msg.setSentDate(new Date());
            //发送邮件
            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }


    public TEmailDAO gettEmailDAO() {
        return tEmailDAO;
    }

    public void settEmailDAO(TEmailDAO tEmailDAO) {
        this.tEmailDAO = tEmailDAO;
    }

}
