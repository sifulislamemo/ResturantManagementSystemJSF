/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.model;

import com.restaurant.dao.LoginDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author USER
 */
@ManagedBean
@SessionScoped
public class Login {
    String name, email, phone, password, address, msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String loginAction() {

        boolean result = new LoginDAO().login(email, password);

        if (result) {
            
            // System.out.println("success");
            return "index";

        } else if (email.equals("admin@mail.com") && password.equals("1234")) {
            clear();
            return "add_menu";
        } else {
            setMsg("Email & Password Invalid");
            
            //System.out.println("failed");
            return "adminlogin";
        }
        
    }
    
    public void clear(){
        setEmail("");
        setPassword("");
    }
     public void register() {
        new LoginDAO().save(this);

        try {
           
        } catch (Exception e) {
        }
    }
}
