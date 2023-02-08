import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailFacade {
    private String from;
    private String password;
    private String to;
    private String subject;
    private String message;

    public EmailFacade(String from, String password, String to, String subject, String message) {
        this.from = from;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public void sendEmail() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            System.out.println("Email sent successfully.");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}