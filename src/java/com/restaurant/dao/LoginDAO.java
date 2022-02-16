/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.dao;

import com.restaurant.common.ICommonInterface;
import com.restaurant.model.Login;
import com.restaurant.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author USER
 */
public class LoginDAO implements ICommonInterface<Login>{
Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public int save(Login t) {
 String sql = "insert into login (name, email, phone, password, address) values(?,?,?,?,?)";
        int status = 0;    
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getEmail());
            ps.setString(3, t.getPhone());
            ps.setString(4, t.getPassword());
            ps.setString(5, t.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {
        }
         return status;
    }
public boolean login(String email, String password){
        
        String sql = "select * from login where email =? and password =?";
        try {
             con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                con.close();
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            
        }
       
    }
    @Override
    public int update(Login t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Login t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Login> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
