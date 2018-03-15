package du.shop.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailThread extends Thread{
	private static String FROM = "137584432@qq.com";//发件人
	private static String PASSID = "oamxehnjovwvbibg";//授权码
	private String to;
	private String code;
	public MailThread(String to,String code) {
		this.to = to;
		this.code = code;
	}
	
	public void run() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "true");
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        props.setProperty("mail.debug", "true"); 
        
		
		
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSID);
			}
			
		});
		Message message = new MimeMessage(session);
		//设置发件人
		try {
			message.setFrom(new InternetAddress(FROM));
			//设置收件人
			message.addRecipient(RecipientType.TO,new InternetAddress(to) );
			//抄送 密送 不需要
			//标题
			message.setSubject("来自网上商城的激活邮件！");
			//设置邮件正文
			message.setContent("<h1>点下面链接完成激活操作!</h1>"
					+ "<h3><a href='http://127.0.0.1:8080/E_Shop/user_active.action?code="+
					code+"'>http://127.0.0.1:8080/E_Shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			//发送邮件
			Transport transport = session.getTransport();
			transport.connect();
			transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
