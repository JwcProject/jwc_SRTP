package edu.cqu.no1.service;

import edu.cqu.no1.domain.TEmail;
import edu.cqu.no1.util.mail.MailInfo;


/**
 * Created by ZKQ on 2015/6/4.
 */

public interface EmailService {
	public boolean saveEmail(MailInfo mailInfo, boolean sendState);

    public boolean sendMail(MailInfo mailInfo);
	
}
