package com.irakli;

import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/irakli/view/login.fxml"));
        primaryStage.setTitle("სალობიე");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //Creating the connection
        String url = "jdbc:mysql://localhost/UniversityDemo";
        String user = "root";
        String pass = "password";

        //Entering the data
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first name");
        String firstName = scanner.next();
        System.out.println("enter last name");
        String lastName = scanner.next();
        System.out.println("enter scholarship");
        String scholarship = scanner.next();

        //Inserting data using SQL query
        String sql = "insert into Students(firstName, lastName, scholarship) values('" + firstName + "', '" + lastName + "', '" + scholarship + "')";
        Connection con;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: unable to load driver class!");
                System.exit(1);
            } catch (IllegalAccessException ex) {
                System.out.println("Error: access problem while loading!");
                System.exit(2);
            } catch (InstantiationException ex) {
                System.out.println("Error: unable to instantiate driver!");
                System.exit(3);
            }

            //Reference to connection interface
            con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1)
                System.out.println("inserted successfully : " + sql);
            else
                System.out.println("insertion failed");
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
