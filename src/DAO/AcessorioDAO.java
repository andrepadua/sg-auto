package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.Acessorio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcessorioDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();

    public Acessorio Consultar(int SEQ_ACESSORIO) throws ClassNotFoundException {
        Acessorio a = null;
        try {
            objConn.Connect();
            String sql = "SELECT A.SEQ_ACESSORIO, A.NOM_ACESSORIO, A.VAL_ACESSORIO, NULL SEQ_MOTORIZACAO, NULL SEQ_FORNECEDOR, M.DSC_MOTORIZACAO, F.NOM_FORNECEDOR FROM SGA.ACESSORIO A INNER JOIN SGA.MOTORIZACAO M ON (M.SEQ_MOTORIZACAO = A.SEQ_MOTORIZACAO) INNER JOIN SGA.FORNECEDOR F ON (F.SEQ_FORNECEDOR = A.SEQ_FORNECEDOR) WHERE A.SEQ_ACESSORIO = " + SEQ_ACESSORIO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            a = (Acessorio) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Acessorio> Consultar() throws ClassNotFoundException {
        ArrayList<Acessorio> lstA = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT A.SEQ_ACESSORIO, A.NOM_ACESSORIO, A.VAL_ACESSORIO, NULL SEQ_MOTORIZACAO, NULL SEQ_FORNECEDOR, M.DSC_MOTORIZACAO, F.NOM_FORNECEDOR FROM SGA.ACESSORIO A INNER JOIN SGA.MOTORIZACAO M ON (M.SEQ_MOTORIZACAO = A.SEQ_MOTORIZACAO) INNER JOIN SGA.FORNECEDOR F ON (F.SEQ_FORNECEDOR = A.SEQ_FORNECEDOR)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Acessorio a = new Acessorio();
                a.setSEQ_ACESSORIO(rs.getInt("SEQ_ACESSORIO"));
                a.setNOM_ACESSORIO(rs.getString("NOM_ACESSORIO"));
                a.setVAL_ACESSORIO(rs.getDouble("VAL_ACESSORIO"));
                a.setDSC_MOTORIZACAO(rs.getString("DSC_MOTORIZACAO"));
                a.setNOM_FORNECEDOR(rs.getString("NOM_FORNECEDOR"));
                lstA.add(a);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstA;
    }

    public ArrayList<Acessorio> ConsultarSeq(int SEQ_ACESSORIO) throws ClassNotFoundException {
        ArrayList<Acessorio> lstA = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT A.SEQ_ACESSORIO, A.NOM_ACESSORIO, A.VAL_ACESSORIO, NULL SEQ_MOTORIZACAO, NULL SEQ_FORNECEDOR, M.DSC_MOTORIZACAO, F.NOM_FORNECEDOR FROM SGA.ACESSORIO A INNER JOIN SGA.MOTORIZACAO M ON (M.SEQ_MOTORIZACAO = A.SEQ_MOTORIZACAO) INNER JOIN SGA.FORNECEDOR F ON (F.SEQ_FORNECEDOR = A.SEQ_FORNECEDOR) WHERE A.SEQ_ACESSORIO = " + SEQ_ACESSORIO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Acessorio a = new Acessorio();
                a.setSEQ_ACESSORIO(rs.getInt("SEQ_ACESSORIO"));
                a.setNOM_ACESSORIO(rs.getString("NOM_ACESSORIO"));
                a.setVAL_ACESSORIO(rs.getDouble("VAL_ACESSORIO"));
                a.setDSC_MOTORIZACAO(rs.getString("DSC_MOTORIZACAO"));
                a.setNOM_FORNECEDOR(rs.getString("NOM_FORNECEDOR"));
                lstA.add(a);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstA;
    }

    public int Incluir(Acessorio a) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_inc_acessorio(?, ?, ?, ?, ?)}");
            cst.setString(1, a.getNOM_ACESSORIO());
            cst.setDouble(2, a.getVAL_ACESSORIO());
            cst.setInt(3, a.getSEQ_MOTORIZACAO());
            cst.setInt(4, a.getSEQ_FORNECEDOR());
            cst.registerOutParameter(5, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(5);
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

    public int Alterar(Acessorio a) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_alt_acessorio(?, ?, ?, ?, ?)}");
            cst.setString(1, a.getNOM_ACESSORIO());
            cst.setDouble(2, a.getVAL_ACESSORIO());
            cst.setInt(3, a.getSEQ_MOTORIZACAO());
            cst.setInt(4, a.getSEQ_FORNECEDOR());
            cst.setInt(5, a.getSEQ_ACESSORIO());

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

    public int Excluir(int SEQ_ACESSORIO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.PKG_ACESSORIO.sp_del_acessorio(?)}");
            cst.setInt(1, SEQ_ACESSORIO);

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

    public int ConsultarSeq(String NOM_ACESSORIO) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT A.SEQ_ACESSORIO FROM SGA.ACESSORIO A WHERE A.NOM_ACESSORIO = '" + NOM_ACESSORIO + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_ACESSORIO");
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
