package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.Motorizacao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotorizacaoDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();

    public Motorizacao Consultar(int SEQ_MOTORIZACAO) throws ClassNotFoundException {
        Motorizacao M = null;
        try {
            objConn.Connect();
            String sql = "SELECT M.SEQ_MOTORIZACAO, M.NUM_POTENCIA, M.NUM_VELOCIDADE_FINAL, M.NUM_AUTONOMIA, NULL SEQ_TIPOMOTORIZACAO, M.DSC_MOTORIZACAO, TM.DESC_TIPOMOTORIZACAO FROM SGA.MOTORIZACAO M INNER JOIN SGA.TIPOMOTORIZACAO TM ON (TM.SEQ_TIPOMOTORIZACAO = M.SEQ_TIPOMOTORIZACAO) WHERE M.SEQ_MOTORIZACAO = " + SEQ_MOTORIZACAO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            M = (Motorizacao) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return M;
    }

    public ArrayList<Motorizacao> Consultar() throws ClassNotFoundException {
        ArrayList<Motorizacao> lstTv = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT M.SEQ_MOTORIZACAO, M.NUM_POTENCIA, M.NUM_VELOCIDADE_FINAL, M.NUM_AUTONOMIA, NULL SEQ_TIPOMOTORIZACAO, M.DSC_MOTORIZACAO, TM.DESC_TIPOMOTORIZACAO FROM SGA.MOTORIZACAO M INNER JOIN SGA.TIPOMOTORIZACAO TM ON (TM.SEQ_TIPOMOTORIZACAO = M.SEQ_TIPOMOTORIZACAO)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Motorizacao M = new Motorizacao();
                M.setSEQ_MOTORIZACAO(rs.getInt("SEQ_MOTORIZACAO"));
                M.setNUM_POTENCIA(rs.getInt("NUM_POTENCIA"));
                M.setNUM_VELOCIDADE_FINAL(rs.getDouble("NUM_VELOCIDADE_FINAL"));
                M.setNUM_AUTONOMIA(rs.getDouble("NUM_AUTONOMIA"));
                M.setDSC_MOTORIZACAO(rs.getString("DSC_MOTORIZACAO"));
                M.setDESC_TIPOMOTORIZACAO(rs.getString("DESC_TIPOMOTORIZACAO"));
                lstTv.add(M);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstTv;
    }

    public ArrayList<Motorizacao> ConsultarSeq(int SEQ_MOTORIZACAO) throws ClassNotFoundException {
        ArrayList<Motorizacao> lstTv = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT M.SEQ_MOTORIZACAO, M.NUM_POTENCIA, M.NUM_VELOCIDADE_FINAL, M.NUM_AUTONOMIA, NULL SEQ_TIPOMOTORIZACAO, M.DSC_MOTORIZACAO, TM.DESC_TIPOMOTORIZACAO FROM SGA.MOTORIZACAO M INNER JOIN SGA.TIPOMOTORIZACAO TM ON (TM.SEQ_TIPOMOTORIZACAO = M.SEQ_TIPOMOTORIZACAO) WHERE M.SEQ_MOTORIZACAO = " + SEQ_MOTORIZACAO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Motorizacao M = new Motorizacao();
                M.setSEQ_MOTORIZACAO(rs.getInt("SEQ_MOTORIZACAO"));
                M.setNUM_POTENCIA(rs.getInt("NUM_POTENCIA"));
                M.setNUM_VELOCIDADE_FINAL(rs.getDouble("NUM_VELOCIDADE_FINAL"));
                M.setNUM_AUTONOMIA(rs.getDouble("NUM_AUTONOMIA"));
                M.setDSC_MOTORIZACAO(rs.getString("DSC_MOTORIZACAO"));
                M.setDESC_TIPOMOTORIZACAO(rs.getString("DESC_TIPOMOTORIZACAO"));
                lstTv.add(M);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstTv;
    }

    public int Incluir(Motorizacao M) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_inc_motorizacao(?, ?, ?, ?, ?, ?)}");
            cst.setInt(1, M.getNUM_POTENCIA());
            cst.setDouble(2, M.getNUM_VELOCIDADE_FINAL());
            cst.setDouble(3, M.getNUM_AUTONOMIA());
            cst.setInt(4, M.getSEQ_TIPOMOTORIZACAO());
            cst.setString(5, M.getDSC_MOTORIZACAO());
            cst.registerOutParameter(6, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(6);
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

    public int Alterar(Motorizacao M) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_alt_motorizacao(?, ?, ?, ?, ?, ?)}");
            cst.setInt(1, M.getNUM_POTENCIA());
            cst.setDouble(2, M.getNUM_VELOCIDADE_FINAL());
            cst.setDouble(3, M.getNUM_AUTONOMIA());
            cst.setInt(4, M.getSEQ_TIPOMOTORIZACAO());
            cst.setString(5, M.getDSC_MOTORIZACAO());
            cst.setInt(6, M.getSEQ_MOTORIZACAO());

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

    public int Excluir(int SEQ_MOTORIZACAO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_del_motorizacao(?)}");
            cst.setInt(1, SEQ_MOTORIZACAO);

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

    public int ConsultarSeq(String NOM_MOTORIZACAO) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT M.SEQ_MOTORIZACAO FROM SGA.MOTORIZACAO M WHERE M.DSC_MOTORIZACAO = '" + NOM_MOTORIZACAO + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_MOTORIZACAO");
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
