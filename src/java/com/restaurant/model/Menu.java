
package com.restaurant.model;


import com.restaurant.dao.MenuDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

@ManagedBean
@RequestScoped
public class Menu {
    private int id;
    private String itemName, menuCategory, status, img;
    private double price;
    private Part file;
    ArrayList menus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

   

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public ArrayList getMenus() {
        return menus;
    }

    public void setMenus(ArrayList menus) {
        this.menus = menus;
    }

   

     public void addMenu() throws IOException {
        String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
        File savedFile = new File("G:\\isdb jee all\\java\\Jsp\\Resturant Management System\\web\\images\\menu\\",fileName);
        InputStream input = file.getInputStream();
        Files.copy(input, savedFile.toPath());
        //img = "img/" + fileName;
        img = "/images/menu/" + fileName; 
        new MenuDAO().save(this);
        clear();
    }
    public void clear(){
        setItemName("");
        setMenuCategory("");
        setStatus("");
        setPrice(0.0);
        setImg("");
    }
    public String beforeUpadate(Menu m){
        setId(m.id);
        //System.out.println(b.id);
        setItemName(m.itemName);
        setMenuCategory(m.menuCategory);
        setStatus(m.status);
        setPrice(m.price);
        setImg(m.img);
        return "update_menu";
    } 
    public void updateMenu(Menu menu){
        new MenuDAO().update(menu);
        System.out.println("done");
    }
    public void deleteMenu(Menu m){
        new MenuDAO().delete(m);
    }
}
