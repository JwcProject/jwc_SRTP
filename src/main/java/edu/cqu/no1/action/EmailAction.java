package edu.cqu.no1.action;


import edu.cqu.no1.service.EmailService;
import edu.cqu.no1.util.mail.MailInfo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by ZKQ on 2015/7/1.
 */

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class EmailAction extends BaseAction {


    private MailInfo mailInfo;
    @Resource
    private EmailService emailService;

    private String sendResult;

    
    @Action(value = "sendEmail", results = {
            @Result(name = "success", type = "json", params = {"root", "sendResult"}),
            @Result(name = "error", type = "json", params = {"root", "sendResult"}),
    })
    public String sendMail() {

        boolean result = emailService.sendMail(mailInfo);
        sendResult = result ? "发送成功！" : "发送失败";
        if (result){
            emailService.saveEmail(mailInfo, true);
            return SUCCESS;
        }

        emailService.saveEmail(mailInfo, false);
        return ERROR;
    }


    public MailInfo getMailInfo() {
        return mailInfo;
    }

    public void setMailInfo(MailInfo mailInfo) {
        this.mailInfo = mailInfo;
    }


    public String getSendResult() {
        return sendResult;
    }

    public void setSendResult(String sendResult) {
        this.sendResult = sendResult;
    }
}
