package com.irakli.services;

import com.irakli.models.AppUser;

public class AuthService {
    public static boolean authorization(String username, String password) {

        AppUser appUser = new AppUser(1L, username, password);

        boolean isAuthorized = false;

        if (appUser.getUsername().equals("admin") && appUser.getPassword().equals("password")) {
            isAuthorized = true;
        }

        return isAuthorized;
    }
}
