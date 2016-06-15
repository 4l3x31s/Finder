package com.yvaganet.finder.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Created by acarrillo on 15/06/2016.
 */
public class MailUtil {

    public boolean enviarMail(String para)
    {
        String de = "petfinder@yvaganet.com";
        String host = "mail.yvaganet.com";
        String pass = "123alexeis";

        Properties propiedades = System.getProperties();
        propiedades.setProperty("mail.smtp.host", host);
        propiedades.setProperty("mail.smtp.port","26");
        Session sesion = Session.getDefaultInstance(propiedades);
        try{
            // Creamos un objeto mensaje tipo MimeMessage por defecto.
            MimeMessage mensaje = new MimeMessage(sesion);

            // Asignamos el “de o from” al header del correo.
            mensaje.setFrom(new InternetAddress(de));

            // Asignamos el “para o to” al header del correo.
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));

            // Asignamos el asunto
            mensaje.setSubject("Usuario Registrado");

            // Asignamos el contenido HTML, tan grande como nosotros queramos
            mensaje.setContent("<h1>El mensaje de nuestro primer correo HTML</h1>","text/html" );

            // Enviamos el correo
            
            Transport tr = sesion.getTransport("smtp");
            tr.connect(host, de, pass);
            mensaje.saveChanges();      // don't forget this
            tr.sendMessage(mensaje, mensaje.getAllRecipients());
            tr.close();
            //Transport.send(mensaje);
            System.out.println("Mensaje enviado");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return false;
    }
}
