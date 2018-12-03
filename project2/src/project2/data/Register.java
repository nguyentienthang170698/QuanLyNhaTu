/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.data;
import project2.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Register {
    public boolean checktrung(String username) {
        String sql = "select * from admin where username=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        } finally {

            DBUtils.closeAll(con, stm, rs);

        }
    }

    public boolean regis(String userName, String pass,String sohieu,String hoten) {
        if (checktrung(userName) == true) {
            return false;
        } else {
            String sql = "INSERT INTO admin(username,pass,so_hieu,ho_va_ten,CreatedTime) VALUES (?,?,?,?,?)";
            Connection con = DBUtils.open();
            PreparedStatement stm = null;
            try {
                con.setAutoCommit(false);
                String encodedString = Base64.getEncoder().encodeToString(pass.getBytes());
                Date date = new Date();
                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
                stm = con.prepareStatement(sql);
                stm.setString(1, userName);
                stm.setString(2, encodedString);
                stm.setString(3, sohieu);
                stm.setString(4, hoten);
                stm.setDate(5, sqlStartDate);

                int checkc = stm.executeUpdate();
                con.commit();
                if (checkc > 0) {
                    return true;
                }

            } catch (Exception ex) {
                try {
                    con.rollback();
                    return false;
                } catch (SQLException ex1) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                DBUtils.closeTwo(con, stm);
            }
        }
        return false;
    }

    public boolean changePass(int id, String passold, String passnew) {
        String encodedStringPassold = Base64.getEncoder().encodeToString(passold.getBytes());
        String encodedStringPassnew = Base64.getEncoder().encodeToString(passnew.getBytes());
        String sql = "Update admin set pass=? where id=? and pass=?";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        try {
            con.setAutoCommit(false);

            stm = con.prepareStatement(sql);
            stm.setString(1, encodedStringPassnew);
            stm.setInt(2, id);
            stm.setString(3, encodedStringPassold);

            int checkc = stm.executeUpdate();
            con.commit();
            if (checkc > 0) {
                return true;
            }

        } catch (Exception ex) {
            try {
                con.rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            DBUtils.closeTwo(con, stm);
        }
        return false;
    }
}
