package com.msbeigi.springsecurityclient.event.listener;

import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.msbeigi.springsecurityclient.entity.User;
import com.msbeigi.springsecurityclient.event.RegistrationCompleteEvent;
import com.msbeigi.springsecurityclient.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;

    public RegistrationCompleteEventListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create a verification token for user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // send mail to the user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        log.info("Click to verify your account: {}", url);
    }
    
}
