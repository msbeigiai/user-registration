package com.msbeigi.springsecurityclient.model;

public record PasswordModel(String email, String oldPassword, String newPassword) {
}
