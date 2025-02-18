package staff;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
    public static void main(String args[]) throws AddressException, MessagingException, IOException {
        Mail mail = new Mail();
        mail.setupServerProperties();
        mail.draftEmail();
        mail.sendEmail();
    }
    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
    private MimeMessage draftEmail() throws AddressException, MessagingException, IOException {
        String[] emailRecipients = {"abc@gmail.com", "xyz@gmail.com"};  
        String emailSubject = "Test Mail";
        String emailBody = "Test Body of my email";

        mimeMessage = new MimeMessage(newSession);

        for (int i = 0; i < emailRecipients.length; i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients[i]));
        }

        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html"); 
        
        Multipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);

        mimeMessage.setContent(multiPart);

        return mimeMessage;
    }

    private void sendEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private MimeMessage mimeMessage;
    private Session newSession;
}
