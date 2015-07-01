package edu.cqu.no1.util.mail;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 用于登录邮箱验证
 */
public class MailAuthenticator extends Authenticator {

    //邮箱帐号
    private String username;
    //密码
    private String password;


    /**
     * 初始化邮箱和密码
     *
     * @param username 邮箱
     * @param password 密码
     */
    public MailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

    String getPassword() {
        return password;
    }


    String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
