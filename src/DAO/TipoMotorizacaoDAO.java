package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.TipoMotorizacao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TipoMotorizacaoDAO {
    
        ClsConn objConn = new ClsConn();
        appBean ab = new appBean();

    public TipoMotorizacao Consultar(int SEQ_TIPOMOTORIZACAO) throws ClassNotFoundException {
        TipoMotorizacao tm = null;
        try {
            objConn.Connect();
            String sql = "SELECT SEQ_TIPOMOTORIZACAO, DESC_TIPOMOTORIZACAO FROM SGA.TIPOMOTORIZACAO WHERE SEQ_TIPOMOTORIZACAO = " + SEQ_TIPOMOTORIZACAO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            tm = (TipoMotorizacao) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return tm;
    }

    public ArrayList<TipoMotorizacao> Consultar() throws ClassNotFoundException {
        ArrayList<TipoMotorizacao> lstTv = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT SEQ_TIPOMOTORIZACAO, DESC_TIPOMOTORIZACAO FROM SGA.TIPOMOTORIZACAO";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                TipoMotorizacao tm = new TipoMotorizacao();
                tm.setSEQ_TIPOMOTORIZACAO(rs.getInt("SEQ_TIPOMOTORIZACAO"));
                tm.setDESC_TIPOMOTORIZACAO(rs.getString("DESC_TIPOMOTORIZACAO"));
                lstTv.add(tm);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstTv;
    }

    public int Incluir(TipoMotorizacao tm) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_inc_tipomotorizacao(?, ?)}");
            cst.setString(1, tm.getDESC_TIPOMOTORIZACAO());
            cst.registerOutParameter(2, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(2);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
            }
        }
        return id;
    }

    public int Alterar(TipoMotorizacao tm) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_alt_tipomotorizacao(?, ?)}");
            cst.setString(1, tm.getDESC_TIPOMOTORIZACAO());
            cst.setInt(2, tm.getSEQ_TIPOMOTORIZACAO());

            int r = cst.executeUpdate();
            if (r > 0) {
                id++;
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
            }
        }
        return id;
    }

    public int Excluir(int SEQ_TIPOMOTORIZACAO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_del_tipomotorizacao(?)}");
            cst.setInt(1, SEQ_TIPOMOTORIZACAO);

            int r = cst.executeUpdate();
            if (r > 0) {
                id++;
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
            }
        }
        return id;
    }
    public int ConsultarSeq(String DESC_TIPOMOTORIZACAO) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT TM.SEQ_TIPOMOTORIZACAO FROM SGA.TIPOMOTORIZACAO TM WHERE TM.DESC_TIPOMOTORIZACAO = '" + DESC_TIPOMOTORIZACAO + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_TIPOMOTORIZACAO");
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
