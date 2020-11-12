package br.com.bb.uop.geadesp.mqp.controller;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class EmailSenderBeanTest {

    public String sendEmail() {
        
        try {

            String fromEmail = "GEADESP-MQP";
            String toEmail = "F6750699@bb.com.br";
            String subject = "Assunto";
            String msg = "\\u001B[1mI am bold \\033[0;1mtest";
          
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", "172.17.78.154");
            props.put("mail.smtp.port", "25");

            Session mailSession = Session.getDefaultInstance(props);
            mailSession.setDebug(true);
            Message mensagem = new MimeMessage(mailSession);
            mensagem.setFrom(new InternetAddress(fromEmail));
            mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mensagem.setContent(msg, "text/html");
            mensagem.setText(msg);
            mensagem.setSubject(subject);
            Transport.send(mensagem);
        } catch (MessagingException e) {
            return e.toString();
        }
        return "E-mail enviado com Sucesso!";
    }

}
