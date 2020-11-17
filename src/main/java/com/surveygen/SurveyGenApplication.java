package com.surveygen;

import com.surveygen.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class })
public class SurveyGenApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SurveyGenApplication.class, args);
	}

	@Override
	public void run(String... arg){
		System.out.println("This is the beginning: ");
		System.out.println(userRepository.findById(1));
	}

}
