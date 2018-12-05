package DAO;

import Class.ClsConn;
import FORM.frmLogin;
import MODELS.TipoVeiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoVeiculoDAO {

    ClsConn objConn = new ClsConn();

    public TipoVeiculo Consultar(int SEQ_TIPOVEICULO) throws ClassNotFoundException {
        TipoVeiculo tv = null;
        try {
            objConn.Connect();
            String sql = "SELECT SEQ_TIPOVEICULO, NOM_TIPOVEICULO FROM ACME9.TIPOVEICULO WHERE SEQ_TIPOVEICULO = " + SEQ_TIPOVEICULO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            tv = (TipoVeiculo) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return tv;
    }

    public ArrayList<TipoVeiculo> Consultar() throws ClassNotFoundException {
        ArrayList<TipoVeiculo> lstTv = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT SEQ_TIPOVEICULO, NOM_TIPOVEICULO FROM ACME9.TIPOVEICULO";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                TipoVeiculo tv = new TipoVeiculo();
                tv.setSEQ_TIPOVEICULO(rs.getInt("SEQ_TIPOVEICULO"));
                tv.setNOM_TIPOVEICULO(rs.getString("NOM_TIPOVEICULO"));
                lstTv.add(tv);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstTv;
    }

    public int Incluir(TipoVeiculo tv) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Guaruenglish?user=crawdio&password=crawdio");

            cst = cn.prepareCall("{call ACME9.PKG_TIPOVEICULO.sp_inc_tipoveiculo(?, ?)}");
            cst.setString(1, tv.getNOM_TIPOVEICULO());
            cst.registerOutParameter(2, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(2);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            }
        }
        return id;
    }

    public int Alterar(TipoVeiculo tv) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Guaruenglish?user=crawdio&password=crawdio");

            cst = cn.prepareCall("{call ACME9.PKG_TIPOVEICULO.sp_alt_tipoveiculo(?, ?)}");
            cst.setString(1, tv.getNOM_TIPOVEICULO());
            cst.setInt(2, tv.getSEQ_TIPOVEICULO());

            int r = cst.executeUpdate();
            if (r > 0) {
                id++;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            }
        }
        return id;
    }

    public int Excluir(int SEQ_TIPOVEICULO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Guaruenglish?user=crawdio&password=crawdio");

            cst = cn.prepareCall("{call ACME9.PKG_TIPOVEICULO.sp_del_tipoveiculo(?)}");
            cst.setInt(1, SEQ_TIPOVEICULO);

            int r = cst.executeUpdate();
            if (r > 0) {
                id++;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            }
        }
        return id;
    }
    public int ConsultarSeq(String NOM_TIPOVEICULO) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT TV.SEQ_TIPOVEICULO FROM ACME9.TIPOVEICULO TV WHERE TV.NOM_TIPOVEICULO = '" + NOM_TIPOVEICULO + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_TIPOVEICULO");
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
