package com.example.kkulaproject;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.kkulaproject.EmailService.EmailManage;
import com.example.kkulaproject.FilesManage.Filesave;
import com.example.kkulaproject.datacalss.History;
import com.example.kkulaproject.datacalss.User;
import com.example.kkulaproject.datacalss.UserRepository;

@Controller
public class MainController {
    @Autowired private UserRepository userRepository;
    @Autowired Filesave filesave;
    @Autowired EmailManage emailManage;
    
    @RequestMapping("/")
    public String Homeindex() {
        System.out.println("Index...");
        return "Home/index";
    }

    @RequestMapping("/loginkku")
    public String Login(Model model) {
        model.addAttribute("user", new User());
        System.out.println("login...");
        return "Home/login_signin";
    }
    
    @RequestMapping("/form")
    public String Form(Model model,HttpServletRequest request) {
        System.out.println(request.getUserPrincipal().getName()+" is Form...");
        History history = new History();
        model.addAttribute("history", history);
        return "Body/form";
    }
    @RequestMapping("/history")
    public String History(Model model,HttpServletRequest request) {
        System.out.println(request.getUserPrincipal().getName()+" is History...");

        System.out.println(request.getUserPrincipal().getName());
        
        User user = userRepository.findByEmail(request.getUserPrincipal().getName());
        model.addAttribute("user", user);
        return "Body/history";
    }

    @PostMapping("/upform")
    public String Upform(@Validated History history,@RequestParam("file") MultipartFile multipartFile,HttpServletRequest request)throws IOException, MessagingException {
        System.out.println(history);
        System.out.println(history.getHistorydetails());
        User user = userRepository.findByEmail(request.getUserPrincipal().getName());
        if (multipartFile.getOriginalFilename()==""){//ไม่มีไฟล์
            emailManage.sendSimpleEmail(user, history);
        }else{//มีไฟล์
            System.out.println("------------file is notNull---------------------");
            history.getHistorydetails().setFileURL( filesave.FilesaveGetUrl(multipartFile));
            emailManage.sendemailattachment(user, history,multipartFile.getOriginalFilename());
        }
        user.getHistory().add(history);
        userRepository.save(user);
        return "redirect:/history";
    }

    @PostMapping("/register")
    public String addregister(@Validated User user,Model model) {
        if(userRepository.findByEmail(user.getEmail())!=null){
            return "Home/error";
        }else{
            userRepository.save(user);
            return "Home/successfully";
        }
    }
}
