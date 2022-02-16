

package com.restaurant.dao;

import com.restaurant.common.ICommonInterface;
import com.restaurant.model.Menu;
import com.restaurant.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "menuDAO")
public class MenuDAO implements ICommonInterface<Menu>{
Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public int save(Menu t) {
        String sql = "insert into menu_dtls (item_name, price, menu_category, status, photo) values(?,?,?,?,?)";
            int status = 0;
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getItemName());
            ps.setDouble(2, t.getPrice());
            ps.setString(3, t.getMenuCategory());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getImg());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return status;
    }

    @Override
    public int update(Menu t) {
         String sql = "update menu_dtls set item_name= ?, price =?, menu_category=?, status=? where id = ?";
        int status = 0;
        try {
             Connection con = DBConnection.getConnect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getItemName());
            ps.setDouble(2, t.getPrice());
            ps.setString(3, t.getMenuCategory());
            ps.setString(4, t.getStatus());
//            ps.setString(5, t.getImg());
            ps.setInt(5, t.getId());
           int sts = ps.executeUpdate();
//            System.err.println("status " + sts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
            return status;
    }

    @Override
    public int delete(Menu t) {
         String sql = "delete from menu_dtls where id =?";
        int status = 0;
        try {
             con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getId());
            System.out.println(t.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Menu getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Menu> getAll() {
        String sql = "select * from menu_dtls";
                ArrayList<Menu> menus = new ArrayList<Menu>();
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
            Menu getAllMenu = new Menu();
            getAllMenu.setItemName(rs.getString("item_name"));
            getAllMenu.setPrice(rs.getDouble("price"));
            getAllMenu.setMenuCategory(rs.getString("menu_category"));
            getAllMenu.setStatus(rs.getString("status"));
            getAllMenu.setImg(rs.getString("photo"));
            getAllMenu.setId(rs.getInt("id"));
            menus.add(getAllMenu);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return menus;
    }
    
}
