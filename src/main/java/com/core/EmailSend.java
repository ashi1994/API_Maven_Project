package com.core;
	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.IOUtils;
import org.testng.Reporter;



	public class EmailSend {
		
	     public static void mailsend() throws FileNotFoundException, IOException {
			Properties pro=TestUtils.getMessagePropery();
			String host=pro.getProperty("mail.host");
			String port=pro.getProperty("mail.port");
			String auth=pro.getProperty("mail.auth");
			final String username=pro.getProperty("mail.username");
			final String password=pro.getProperty("mail.password");
			String to=pro.getProperty("mail.to");
			String cc=pro.getProperty("mail.cc");
			String subject=pro.getProperty("mail.subject");
			String content=pro.getProperty("mail.content");
			boolean status=Boolean.parseBoolean(pro.getProperty("mail.send"));
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.socketFactory.port", port);
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", auth);
			props.put("mail.smtp.port", port);
			
			if(status) {
			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				String[] recipientList = to.split(",");
				InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
				int counter = 0;
				for (String recipient : recipientList) {
				    recipientAddress[counter] = new InternetAddress(recipient.trim());
				    counter++;
				}
				message.setRecipients(Message.RecipientType.TO, recipientAddress);
				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
				message.setSubject(subject);
				message.setText(content);
				StringWriter writer = new StringWriter();
				IOUtils.copy(new FileInputStream(new File(System.getProperty("user.dir")+"/"+"/test-output/html/index.html")), writer);

				message.setContent(writer.toString(), "text/html");
				
			
				//Below code for attachment in email

//		         // This mail has 2 part, the BODY and the embedded image
//  	         MimeMultipart multipart = new MimeMultipart("related");
//
//		         // first part (the html)
//		         BodyPart messageBodyPart = new MimeBodyPart();
//		         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
//		         messageBodyPart.setContent(htmlText, "text/html");
//		         // add it
//		         multipart.addBodyPart(messageBodyPart);
//		         
//		      // second part (the image)
//		         messageBodyPart = new MimeBodyPart();
//		         DataSource fds = new FileDataSource("C:\\Users\\Ashiwani\\Downloads\\download.jpg");
//		         messageBodyPart.setDataHandler(new DataHandler(fds));
//		         messageBodyPart.setHeader("Content-ID", "<image>");
//
//		         // add image to the multipart
//		         multipart.addBodyPart(messageBodyPart);
//                // put everything together
//		         message.setContent(multipart);
//		         
		         

				Transport.send(message);

				System.out.println("Email sent successfully");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			}
			else {
				Reporter.log("Email sent is Off",true);
			}
		}
}

