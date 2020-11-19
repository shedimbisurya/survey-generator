package com.surveygen.controller;

import com.surveygen.model.User;
import com.surveygen.service.SecurityService;
import com.surveygen.service.UserService;
import com.surveygen.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println("registration successful!        1111");
        userService.save(userForm);
        System.out.println("registration successful!        2222");
        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        System.out.println("registration successful!        3333");

        return "redirect:/welcome";
    }

    @GetMapping("/loginpage")
    public String displayLogin() {
        System.out.println("Lemon Tree");
        return "login";
    }

    @PostMapping ("/logincreds")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        System.out.println("11111111111");
        if(userService.checkPassword(username, password)){
            System.out.println("POST /login hit and User validated!");
            return "welcome";
        }
        else return "login";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/forgetPassword")
    public String forgetPassword(){
        return "forget-password";
    }

    @PostMapping("/emailConfirmation")
    public String confirmEmail(@RequestParam("email") String email) throws MessagingException, MessagingException, IOException, GeneralSecurityException {
        System.out.println("1111111");
        userService.emailConfirmation(email);

        return "checkYourEmail";
    }

//    @PostMapping("/createSurvey")
//    public String createSurvey(@RequestParam("id") int id){
//
//        userService.createSurvey(id);
//
//    }


}
