package com.surveygen.service;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.surveygen.Repository.UserRepository;
import com.surveygen.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private GmailService gmailService;

    @Override
    public User findById(int id){
        return userRepository.findById(id);
    }

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean checkPassword(String username, String password){

        System.out.println("Reached checkPassword()!");

        User user = findByUsername(username);
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            System.out.println("Matching passwords!");
            return true;
        }
        else return false;
    }

    @Override
    public void emailConfirmation(String email) throws MessagingException, MessagingException, IOException, GeneralSecurityException {
        String confirmationBody = new String("This is a test email.");
        // body needs to be inserted
        System.out.println("2222222");
        MimeMessage mimeMessage =  gmailService.createEmail(email, "onlinesurveygen@gmail.com", "Confirmation link", confirmationBody);

        //Message message = gmailService.createMessageWithEmail(mimeMessage);
        System.out.println("33333333");
        Gmail gmail = gmailService.instantiateGmailService();
        System.out.println("666666666");
        gmailService.sendMessage(gmail, "onlinesurveygen@gmail.com", mimeMessage);

    }


}
