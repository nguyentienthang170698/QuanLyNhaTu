/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import project2.model.Users;
import project2.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class getUserIDforlogin {
    public int getUserID(String username){
     String sql = "select * from admin where username=?";
        Connection con = DBUtils.open();
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if(rs.next()){
              int id=rs.getInt("ID");
              return id;
                }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
             
            DBUtils.closeAll(con, stm, rs);
          
        }
        return 0;
    }
    public String getusername(int  id){
     String sql = "select * from admin where ID=?";
        Connection con = DBUtils.open();
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()){
              String userna=rs.getString("username");
              return userna;
                }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
             
            DBUtils.closeAll(con, stm, rs);
          
        }
        return null;
    }
     public Users get1usser(int  id){
     String sql = "select * from admin where id=?";
        Connection con = DBUtils.open();
        PreparedStatement stm=null;
        ResultSet rs=null;
        Users u=null;
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()){
                
              String userna=rs.getString("username");
              String pass=rs.getString("pass");         
              String so_hieu=rs.getString("so_hieu");
              String ho_ten=rs.getString("ho_va_ten");
              Date createtime=rs.getDate("CreatedTime");
              u=new Users(id, userna, so_hieu, pass,createtime);
                }
            return u;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
             
            DBUtils.closeAll(con, stm, rs);
          
        }
        return null;
    }
}
