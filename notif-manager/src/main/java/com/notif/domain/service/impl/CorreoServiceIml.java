package com.notif.domain.service.impl;

import com.notif.domain.service.CorreoService;
import com.notif.domain.service.event.ClienteEvent;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CorreoServiceIml implements CorreoService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviaCorreo(ClienteEvent clienteEvent) {
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("cualquier@Correo.bo");
            helper.setTo(clienteEvent.getCorreo());
            helper.setSubject("Confirmacion, apertura de cuenta");
            helper.setText("Estimado cliente "+clienteEvent.getNombres()+"su cuenta Nro: "+clienteEvent.getNroCuenta()+" fue aperturada", true);
            mailSender.send(message);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
    }
}
