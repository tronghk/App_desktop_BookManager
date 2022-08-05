package BUS;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DTO.mail;
public class myMail {
	public static void send(mail mail) throws Exception {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port","587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(prop, new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(mail.getForm(), mail.getPass());
				
			}
		});
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(mail.getForm()));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo()));
				message.setSubject(mail.getSubject());
				message.setContent(mail.getContent(),"tetxt/html; charset = ult-8");
				Transport.send(message);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	}
}
