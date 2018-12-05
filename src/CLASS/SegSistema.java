/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import Class.ClsConn;
import FORM.frmLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author André
 */
public class SegSistema {

    ClsConn objConn = new ClsConn();

    public int fc_get_perf_usu() throws ClassNotFoundException {

        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT U.SEQ_PERFIL FROM ACME9.USUARIO U WHERE U.LOGINNAME = upper('" + frmLogin.username + "')";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_PERFIL");
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return Seq;
    }

    public int fc_get_usu_cad() throws ClassNotFoundException {

        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT COUNT(*) AS CNT FROM ACME9.USUARIO U WHERE U.LOGINNAME = upper('" + frmLogin.username + "')";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("CNT");
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return Seq;
    }
}
