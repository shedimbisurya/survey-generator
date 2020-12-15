package com.surveygen.validator;

import com.surveygen.model.UserLogin;
import com.surveygen.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserLoginService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserLogin.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserLogin userLogin = (UserLogin) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userLogin.getUsername().length() < 6 || userLogin.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(userLogin.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userLogin.getPassword().length() < 8 || userLogin.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!userLogin.getPasswordConfirm().equals(userLogin.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
