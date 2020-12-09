package com.surveygen.controller;

import com.surveygen.model.UserLogin;
import com.surveygen.service.SecurityService;
import com.surveygen.service.UserLoginService;
import com.surveygen.service.UserService;
import com.surveygen.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserLogin());

        return "registration";
    }

    @CrossOrigin(origins="*")
    @PostMapping("/registration")
    public ResponseEntity<String> registration(@ModelAttribute("userForm") UserLogin userLoginForm, BindingResult bindingResult) {
        userValidator.validate(userLoginForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("Failed", HttpStatus.OK);
        }

        userLoginService.save(userLoginForm);

        userService.addUser(userLoginForm);     // adds user to mongo database as well

        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @GetMapping("/loginpage")
    public String displayLogin() {
        System.out.println("Lemon Tree");
        return "login";
    }

    @CrossOrigin(origins="*")
    @GetMapping ("/logincreds")
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){

        if(userLoginService.checkPassword(username, password)){
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Failed", HttpStatus.OK);
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
        userLoginService.emailConfirmation(email);

        return "checkYourEmail";
    }

}
