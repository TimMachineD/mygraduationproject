package du.shop.util;

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
import javax.mail.search.RecipientTerm;

import java.util.Properties;

/**
 * �ʼ����͹�����
 * @author Administrator
 *
 */
public class MailUtils {
	/**
	 * 
	 * @param to ���ռ���
	 * @param code ��������
	 */
	/*private  String FROM = "137584432@qq.com";//������
	private String PASSWORD = "oamxehnjovwvbibg";//��Ȩ��*/
	public static void sendMail(String to,String code) {
		/**
		 * 1.���session����
		 * 2.�����ʼ�����
		 * 3.�����ʼ�Trasport
		 */
		String from = "137584432@qq.com";
		String passID = "oamxehnjovwvbibg";
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
				return new PasswordAuthentication(from, passID);
			}
			
		});
		Message message = new MimeMessage(session);
		//���÷�����
		try {
			message.setFrom(new InternetAddress(from));
			//�����ռ���
			message.addRecipient(RecipientType.TO,new InternetAddress(to) );
			//���� ���� ����Ҫ
			//����
			message.setSubject("���������̳ǵļ����ʼ���");
			//�����ʼ�����
			message.setContent("<h1>������������ɼ������!</h1>"
					+ "<h3><a href='http://127.0.0.1:8080/E_Shop/user_active.action?code="+
					code+"'>http://127.0.0.1:8080/E_Shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			//�����ʼ�
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
