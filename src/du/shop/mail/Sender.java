package du.shop.mail;
/**
 * �����ʼ���
 * @author Administrator
 *
 */

import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sender implements Runnable{
	private static String FROM = "137584432@qq.com";//������
	private static String PASSID = "oamxehnjovwvbibg";//��Ȩ��
	Properties props;
	Session session;
	MimeMessage msg;
	/**
	 * 
	 * @param to �ռ���
	 * @param code ������
	 */
	public Sender(String to ,String code) {
		System.out.println("constructor..."); 
		props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "true");
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        props.setProperty("mail.debug", "true"); 
		session = Session.getInstance(props,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSID);
			}
			
		});
		
		try {
			msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM));
			msg.addRecipient(RecipientType.TO, new InternetAddress(to));  
			msg.setSubject("���������̳ǵļ����ʼ���");
			//�����ʼ�����
			msg.setContent("<h1>������������ɼ������!</h1>"
					+ "<h3><a href='http://127.0.0.1:8080/E_Shop/user_active.action?code="+
					code+"'>http://127.0.0.1:8080/E_Shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void send() {
		try {  
            Transport.send(msg); 
            System.out.println("sent success!");  
        } catch (MessagingException mex) {  
            System.out.println(new Date() + " send failed, exception: " + mex);  
        }  
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		send();
	}
	
}
