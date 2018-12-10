package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.Peca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();

    public Peca Consultar(int SEQ_PECA) throws ClassNotFoundException {
        Peca pc = null;
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PECA, P.NOM_PECA, NULL SEQ_FORNECEDOR, NULL FLG_PROD_MONT, F.NOM_FORNECEDOR, DECODE(P.FLG_PROD_MONT, 1, 'Sim', 0, 'Não') PROD_MONTADORA FROM SGA.PECA P INNER JOIN SGA.FORNECEDOR F ON (P.SEQ_FORNECEDOR = F.SEQ_FORNECEDOR) WHERE P.SEQ_PECA = " + SEQ_PECA;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            pc = (Peca) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return pc;
    }

    public ArrayList<Peca> Consultar() throws ClassNotFoundException {
        ArrayList<Peca> lstP = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PECA, P.NOM_PECA, NULL SEQ_FORNECEDOR, NULL FLG_PROD_MONT, F.NOM_FORNECEDOR, DECODE(P.FLG_PROD_MONT, 1, 'Sim', 0, 'Não') PROD_MONTADORA FROM SGA.PECA P INNER JOIN SGA.FORNECEDOR F ON (P.SEQ_FORNECEDOR = F.SEQ_FORNECEDOR)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Peca pc = new Peca();
                pc.setSEQ_PECA(rs.getInt("SEQ_PECA"));
                pc.setNOM_PECA(rs.getString("NOM_PECA"));
                pc.setNOM_FORNECEDOR(rs.getString("NOM_FORNECEDOR"));
                pc.setPROD_MONTADORA(rs.getString("PROD_MONTADORA"));
                lstP.add(pc);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstP;
    }

    public ArrayList<Peca> ConsultarSeq(int SEQ_PECA) throws ClassNotFoundException {
        ArrayList<Peca> lstP = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PECA, P.NOM_PECA, NULL SEQ_FORNECEDOR, NULL FLG_PROD_MONT, F.NOM_FORNECEDOR, DECODE(P.FLG_PROD_MONT, 1, 'Sim', 0, 'Não') PROD_MONTADORA FROM SGA.PECA P INNER JOIN SGA.FORNECEDOR F ON (P.SEQ_FORNECEDOR = F.SEQ_FORNECEDOR) WHERE P.SEQ_PECA = " + SEQ_PECA;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Peca pc = new Peca();
                pc.setSEQ_PECA(rs.getInt("SEQ_PECA"));
                pc.setNOM_PECA(rs.getString("NOM_PECA"));
                pc.setNOM_FORNECEDOR(rs.getString("NOM_FORNECEDOR"));
                pc.setPROD_MONTADORA(rs.getString("PROD_MONTADORA"));
                lstP.add(pc);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstP;
    }

    public int Incluir(Peca pc) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_inc_peca(?, ?, ?, ?)}");
            cst.setString(1, pc.getNOM_PECA());
            cst.setInt(2, pc.getSEQ_FORNECEDOR());
            cst.setInt(3, pc.getFLG_PROD_MONT());
            cst.registerOutParameter(4, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(4);
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

    public int Alterar(Peca pc) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_alt_peca(?, ?, ?, ?)}");
            cst.setString(1, pc.getNOM_PECA());
            cst.setInt(2, pc.getSEQ_FORNECEDOR());
            cst.setInt(3, pc.getFLG_PROD_MONT());
            cst.setInt(4, pc.getSEQ_PECA());

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

    public int Excluir(int SEQ_PECA) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_del_peca(?)}");
            cst.setInt(1, SEQ_PECA);

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

    public int ConsultarSeq(String NOM_PECA) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT P.SEQ_PECA FROM SGA.PECA P WHERE P.NOM_PECA = '" + NOM_PECA + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_PECA");
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
