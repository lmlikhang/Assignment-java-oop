package assignment.java.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alvin
 */
public class User {
    private String usernametxt;
    private String passwordtxt;
    private String usertype;
    
    public User(String username, String password, String usertype){
        this.usernametxt = username;
        this.passwordtxt = password;
        this.usertype = usertype;    
    }

    public String getUsername(){
        return usernametxt;
    }
    
    public void setUsername (String username){
        this.usernametxt = username;
    }
    
    public String getPassword(){
        return passwordtxt;
    }
    
    public void setPassword (String password){
        this.passwordtxt = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
    public User validateUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userdata = line.split(",");  // Split the line by commas
                String fileUsername = userdata[0];  // Get username from the file
                String filePassword = userdata[1];  // Get password from the file
                String role = userdata[2];  // Get role from the file

                // Check if the entered username and password match any record
                if (fileUsername.equals(username) && filePassword.equals(password)) {
                    
                    // If valid, return a new User object with the details
                    
                    return new User(fileUsername, filePassword, role);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no matching user is found
    }
    
    
}
