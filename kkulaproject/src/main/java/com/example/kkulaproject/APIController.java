package com.example.kkulaproject;

import org.springframework.web.bind.annotation.RestController;

import com.example.kkulaproject.EmailService.EmailSenderService;
import com.example.kkulaproject.datacalss.Historydetails;
import com.example.kkulaproject.datacalss.HistorydetailsRepository;
import com.example.kkulaproject.datacalss.History;
import com.example.kkulaproject.datacalss.HistoryRepository;
import com.example.kkulaproject.datacalss.User;
import com.example.kkulaproject.datacalss.UserRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class APIController { ///API สำหรับทดสอบระบบเท่านั้น 
    @Autowired
    UserRepository userRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    HistorydetailsRepository historydetailsRepository;
    @Autowired private EmailSenderService service;

    @GetMapping(value = "/API")
    public String getHome() {
        return "KKULA Home";
    }

    @GetMapping(value = "/API/setdata")
    public String setdata() {
        User user = new User();

        user.setEmail("x");
        user.setStudentid("633020032-4");
        user.setName("klayut Phichaichoed");
        user.setPassword("x");

        List<History> history = new ArrayList<History>();

        history.add(new History(Date.valueOf("2001-06-13"), Date.valueOf("2001-06-14"),
                new Historydetails("totsukath@gmail.com", "NULL","0621768480","klalalallalalala")));

        history.add(new History(Date.valueOf("2001-07-02"), Date.valueOf("2001-07-05"),
                new Historydetails("totsukath@gmail.com", "NULL","0621768480","klayutlalallalal")));

        user.setHistory(history);
        userRepository.save(user);
        System.out.println("<System> save successfully...");
        return "save successfully.....";
    }

    @GetMapping(value = "/API/update")
    public String updetedata() {
        User user = userRepository.findByEmail("klayut@kkumial.com");

        user.getHistory().get(0).getHistorydetails().getDetails();

        user.setEmail("kla_yut@kkumail.com");
        userRepository.save(user);
        System.out.println("<System> updetedata successfully...");
        return "updetedata successfully.....";
    }
    
    @GetMapping(value = "/API/sendemail")
    public String sendEmail() {
        service.sendSimpleEmail("totsukath@gmail.com","klayut","ขอลาครับผม");
        return "sendEmail successfully.....";
    }
    @GetMapping(value = "/API/sendemailattachment")
    public String sendEmailAttachment() throws MessagingException {
        service.sendEmailWithAttachment("totsukath@gmail.com","klayut","ขอลาครับผม","Files-Upload\\VaYM70Nd-Untitled.png");
        return "sendEmailAttachmen successfully.....";
    }

}
