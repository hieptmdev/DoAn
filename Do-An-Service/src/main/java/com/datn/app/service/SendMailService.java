package com.datn.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendCodeMail(String toEmail, String subject, String code){
        SimpleMailMessage message = new SimpleMailMessage();
        String text = String.format(templateSimpleMessage().getText(), code);
        message.setFrom("noreply@baeldung.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Trường Đại học Giao thông vận tải\n" +
                "Mã xác thực sử dụng thay đổi mật khẩu: %s");
        return message;
    }
}
