package vts.mail;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import vts.basetest.TestBase;

public class SendMailReport extends TestBase {

	public void sendMail() throws MessagingException, IOException {

		// authentication info
		final String username = "rakeshchittimela98@gmail.com";
		final String password = "";
		String fromEmail = "rakeshchittimela98@gmail.com";
		String toEmail = "rakeshc@affluencesystems.com";

		Properties properties = System.getProperties();
		properties.put("mail.smtps.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(true);

		// Email message

		MimeMessage msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(fromEmail));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		msg.setSubject("Automation Testing Report");
		msg.setText("Hi Team.......");

		Multipart emailcontent = new MimeMultipart();

		MimeBodyPart textbody = new MimeBodyPart();
		textbody.setText("Hi team, Automation Testing is completed, here is the final report");

		MimeBodyPart pdf = new MimeBodyPart();

		pdf.attachFile(System.getProperty("user.dir") + "\\src\\main\\java\\vts\\reports\\extentreport " + actualdate
				+ ".html");
		emailcontent.addBodyPart(textbody);
		emailcontent.addBodyPart(pdf);

		msg.setContent(emailcontent);
		Transport.send(msg);
		System.out.println("Email sent successfully");

	}

}
