/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Random;

import javax.mail.Authenticator;


/**
 *
 * @author alanwar
 */
public class send_email {
   public static void sendemail(String recepient,int ran) throws MessagingException{
       
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
 // Get a Properties object
    Properties props = System.getProperties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    props.setProperty("mail.smtp.socketFactory.fallback", "false");
    props.setProperty("mail.smtp.port", "888");
    props.setProperty("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.store.protocol", "pop3");
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.starttls.enable","true"); 

    final String username = "alalmalhospital@gmail.com";//
    final String password = "alamal12345";
    try{
      Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
      Message msg = new MimeMessage(session);

   // -- Set the FROM and TO fields --
      msg.setFrom(new InternetAddress(username));
      msg.setRecipients(Message.RecipientType.TO, 
                        InternetAddress.parse( recepient ,false));
      msg.setSubject("Wellcome to Airline_app application");
      msg.setText("to continue with your email verfication ,\n please enter the following code :\n"
              + "Verfication Code\n:"
              + ran);
      msg.setSentDate(new Date());
      Transport.send(msg);
      System.out.println("Message sent.");
    }catch (MessagingException e){ 
      System.out.println("Erreur d'envoi, cause: " + e);
    }
       
       
       
       
       
       
       
       
      /*roperties p=new Properties();
        p.put("mail.stmp.auth","true");
p.put("mail.stmp.starttls.enable","true");
p.put("mail.stmp.host","smtp.gmail.com");
p.put("mail.stmp.port","578");
       
       
String   myacount="alalmalhospital@gmail.com";       
  String    pass="alamal12345";
      
       Session session=Session.getInstance(p,new javax.mail.Authenticator() {
           @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(myacount,pass);
        }
           
        
       });
               
       
       Message message=prepareMessage(session,myacount,recepient);
       Transport.send(message);
       System.out.print("message sent");
       */
       
   }
    
    /*
    final String username="AL_Amal Hospital";
            final String password="alamal12345";
String   fromEmail="alalmalhospital@gmail.com";
String ToEmail="rawanzanabeet@gmail.com";
            public void sendEmail(){
                Properties p=new Properties();
                p.put("mail.stmp.auth","true");
p.put("mail.stmp.starttls.enable","true");
p.put("mail.stmp.host","mail.stmp.yahoo.com");
p.put("mail.stmp.port","578");
         
            Session session=Session.getInstance(p,new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(username,password);
        }
             
            
                               
                    
            
            
            }  );
            MimeMessage msg=new MimeMessage(session);
            
 try{
    msg.setFrom(new InternetAddress(fromEmail));
    msg.addRecipient(Message.RecipientType.TO,new InternetAddress(ToEmail));
msg.setSubject("true");
    Transport.send(msg);
 
 }
catch(Exception e)
{
    e.printStackTrace();
}
}*/

    private static Message prepareMessage(Session session, String myacount, String recepient) {
       try {
           Message message=new MimeMessage(session);
           message.setFrom(new InternetAddress(myacount));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setSubject("my first email from java");
           message.setText("look my email");
           return message;
       } catch (Exception ex) {
           Logger.getLogger(send_email.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
}