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

/**
 *
 * @author ACER
 */
public class Loign {
    public boolean login(String userName, String pass) {
        String sql = "select * from admin where username=? ";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            stm = con.prepareStatement(sql);
            stm.setString(1, userName);
            rs = stm.executeQuery();
            if (rs.next()) {
                String passs = rs.getString("pass");
                byte[] decodedBytes = Base64.getDecoder().decode(passs);
                
                String decodedString = new String(decodedBytes);
                if (decodedString.compareTo(pass) == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            return false;
        } finally {
            DBUtils.closeAll(con, stm, rs);
        }
        return false;
    }
        public boolean checkpass(int iduser, String pass) {
        String sql = "select * from admin where ID=? ";
        Connection con = DBUtils.open();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            stm = con.prepareStatement(sql);
            stm.setInt(1, iduser);
            rs = stm.executeQuery();
            if (rs.next()) {
                String passs = rs.getString("pass");
                byte[] decodedBytes = Base64.getDecoder().decode(passs);
                String decodedString = new String(decodedBytes);
                if (decodedString.compareTo(pass) == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            return false;
        } finally {
            DBUtils.closeAll(con, stm, rs);
        }
        return false;
    }
}
