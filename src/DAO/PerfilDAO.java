package DAO;

import Class.ClsConn;
import MODELS.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerfilDAO {

    ClsConn objConn = new ClsConn();

    public Perfil Consultar(int SEQ_PERFIL) throws ClassNotFoundException {
        Perfil p = null;
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PERFIL, P.NOM_PERFIL FROM ACME9.PERFIL P WHERE P.SEQ_PERFIL = " + SEQ_PERFIL;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            p = (Perfil) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return p;
    }

    public int ConsultarSeq(String NOM_PERFIL) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PERFIL FROM ACME9.PERFIL P WHERE P.NOM_PERFIL = '" + NOM_PERFIL + "'";
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

    public ArrayList<Perfil> Consultar() throws ClassNotFoundException {
        ArrayList<Perfil> lstP = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PERFIL, P.NOM_PERFIL FROM ACME9.PERFIL P";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Perfil p = new Perfil();
                p.setSEQ_PERFIL(rs.getInt("SEQ_PERFIL"));
                p.setNOM_PERFIL(rs.getString("NOM_PERFIL"));
                lstP.add(p);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstP;
    }
}
