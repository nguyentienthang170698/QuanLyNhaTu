/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class Users {
    private int ID;
    private String username;
    private String pass;
    private String so_hieu;
    private String ho_va_ten;
    private Date CreatedTime;

    public Users(int id, String userna, String email, String pass, Date createtime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCreatedTime(Date CreatedTime) {
        this.CreatedTime = CreatedTime;
    }

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public Users(Date CreatedTime) {
        this.CreatedTime = CreatedTime;
    }
    public Users() {
    }

    public Users(int ID, String username, String pass, String so_hieu, String ho_va_ten) {
        this.ID = ID;
        this.username = username;
        this.pass = pass;
        this.so_hieu = so_hieu;
        this.ho_va_ten = ho_va_ten;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getSo_hieu() {
        return so_hieu;
    }

    public String getHo_va_ten() {
        return ho_va_ten;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setSo_hieu(String so_hieu) {
        this.so_hieu = so_hieu;
    }

    public void setHo_va_ten(String ho_va_ten) {
        this.ho_va_ten = ho_va_ten;
    }
    
}
