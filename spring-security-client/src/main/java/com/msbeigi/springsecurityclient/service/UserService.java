package com.msbeigi.springsecurityclient.service;

import com.msbeigi.springsecurityclient.entity.User;
import com.msbeigi.springsecurityclient.entity.VerificationToken;
import com.msbeigi.springsecurityclient.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);
    void saveVerificationTokenForUser(String token, User user);
    String validateVerificationToken(String token);
    VerificationToken generateNewVerificationToken(String oldToken);
}
