package com.msbeigi.springsecurityclient.model;

public record UserModel(
    String firtname,
	String lastname,
	String email,
	String password,
	String matchigPassword
) {
    
}
