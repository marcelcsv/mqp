/**
 *
 * @author f6750699
 */
/*
 * Banco do Brasil SA
 * Todos os direitos reservados.
 */
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
public class EmailSenderBean {

    public String sendEmail(String emailFunci, String co, String assunto, String emailMensagem) {
        
        try {

            String fromEmail = "GEADESP-MQP";
            String ccEmail = "uop.geadesp@bb.com.br" ; //+ emailSuperior + ";" + emailPrefixo + ";" + emailExtra;
            String toEmail = emailFunci;
            String coEmail = co;
            String subject = assunto;
            String msg = emailMensagem;
          
            Properties props = new Properties();
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", "172.17.78.154");
            props.put("mail.smtp.port", "25");

            Session mailSession = Session.getDefaultInstance(props);
            mailSession.setDebug(true);
            Message mensagem = new MimeMessage(mailSession);
            mensagem.setFrom(new InternetAddress(fromEmail));
            mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mensagem.setRecipient(Message.RecipientType.CC, new InternetAddress(ccEmail));
            mensagem.setRecipient(Message.RecipientType.BCC, new InternetAddress(coEmail));
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
