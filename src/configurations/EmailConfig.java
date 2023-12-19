package configurations;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailConfig {
    private final String to;
    private final String subject;
    private final String text;

    public EmailConfig(String to, String subject, String text) {
        super();
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void sendActualEmail( ) {


        //my email
        String from="nuswarwick@gmail.com";
        //host
        String host="smtp.gmail.com";
        //properties
        Properties prop=System.getProperties();

        //setting the server
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.port","465");
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.auth","true");


        //passing username and password to session object
        Session session=Session.getInstance(prop,new javax.mail.Authenticator() {
            @SuppressWarnings("SpellCheckingInspection")
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nuswarwick@gmail.com","xpbpjfnqjkzlqmzy");
            }
        });

        session.setDebug(true);
        try {
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        }catch(MessagingException mex) {
            mex.printStackTrace();
        }
    }


}
