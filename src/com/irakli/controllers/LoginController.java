package com.irakli.controllers;

import com.irakli.services.AuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    public TextField txt_username;
    public PasswordField txt_pwd;
    public void btnLogin(ActionEvent actionEvent) {
        System.out.println(txt_username.getText());
        System.out.println(txt_pwd.getText());

        boolean authorized = AuthService.authorization(txt_username.getText(),txt_pwd.getText());

        System.out.println(authorized);
    }

}
