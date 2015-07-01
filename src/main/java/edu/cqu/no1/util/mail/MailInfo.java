package edu.cqu.no1.util.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;


public class MailInfo {
    // 发送邮件的服务器的IP和端口
    private String mailServerHost;
    private String mailServerPort = "25";
    // 邮件发送者的地址
    private String fromAddress;    //从前端获取
    // 邮件接收者的地址
    private String toAddress;      //从前端获取
    // 登陆邮件发送服务器的用户名和密码    
    private String userName;
    private String password;       //从前端获取
    // 是否需要身份验证
    private boolean validate = true;
    // 邮件主题    
    private String subject;        //从前端获取
    // 邮件的文本内容    
    private String content;        //从前端获取
    // 邮件附件的文件名    
    private String[] attachFileNames = new String[]{};   //从前端获取


    //届期年份
    private String jieqiYear;

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        return p;
    }


    /**
     * 把邮件主题转换为中文
     *
     * @param strText 邮件主题
     * @return 转换为中文后的邮件主题
     */
    public String transferChinese(String strText) {
        try {
            strText = MimeUtility.encodeText(
                    new String(strText.getBytes()
                            , "GB2312"), "GB2312", "B");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strText;
    }


    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }

    public String getJieqiYear() {
        return jieqiYear;
    }

    public void setJieqiYear(String jieqiYear) {
        this.jieqiYear = jieqiYear;
    }

}
