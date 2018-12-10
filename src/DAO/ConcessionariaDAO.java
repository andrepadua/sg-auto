package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.Concessionaria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConcessionariaDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();

    public Concessionaria Consultar(int SEQ_CONCESSIONARIA) throws ClassNotFoundException {
        Concessionaria C = null;
        try {
            objConn.Connect();
            String sql = "SELECT C.SEQ_CONCESSIONARIA, C.NOM_CONCESSIONARIA, C.NUM_CNPJ, C.DSC_RAZAO_SOCIAL, C.END_CONCESSIONARIA, C.NOM_CONTATO, C.NUM_TELEFONE_CONTATO FROM SGA.CONCESSIONARIA C WHERE C.SEQ_CONCESSIONARIA = " + SEQ_CONCESSIONARIA;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            C = (Concessionaria) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return C;
    }

    public ArrayList<Concessionaria> Consultar() throws ClassNotFoundException {
        ArrayList<Concessionaria> lstC = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT C.SEQ_CONCESSIONARIA, C.NOM_CONCESSIONARIA, C.NUM_CNPJ, C.DSC_RAZAO_SOCIAL, C.END_CONCESSIONARIA, C.NOM_CONTATO, C.NUM_TELEFONE_CONTATO FROM SGA.CONCESSIONARIA C";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Concessionaria C = new Concessionaria();
                C.setSEQ_CONCESSIONARIA(rs.getInt("SEQ_CONCESSIONARIA"));
                C.setNOM_CONCESSIONARIA(rs.getString("NOM_CONCESSIONARIA"));
                C.setNUM_CNPJ(rs.getString("NUM_CNPJ"));
                C.setDSC_RAZAO_SOCIAL(rs.getString("DSC_RAZAO_SOCIAL"));
                C.setEND_CONCESSIONARIA(rs.getString("END_CONCESSIONARIA"));
                C.setNOM_CONTATO(rs.getString("NOM_CONTATO"));
                C.setNUM_TELEFONE_CONTATO(rs.getString("NUM_TELEFONE_CONTATO"));
                lstC.add(C);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstC;
    }

    public ArrayList<Concessionaria> ConsultarSeq(int SEQ_CONCESSIONARIA) throws ClassNotFoundException {
        ArrayList<Concessionaria> lstC = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT C.SEQ_CONCESSIONARIA, C.NOM_CONCESSIONARIA, C.NUM_CNPJ, C.DSC_RAZAO_SOCIAL, C.END_CONCESSIONARIA, C.NOM_CONTATO, C.NUM_TELEFONE_CONTATO FROM SGA.CONCESSIONARIA C WHERE C.SEQ_CONCESSIONARIA = " + SEQ_CONCESSIONARIA;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Concessionaria C = new Concessionaria();
                C.setSEQ_CONCESSIONARIA(rs.getInt("SEQ_CONCESSIONARIA"));
                C.setNOM_CONCESSIONARIA(rs.getString("NOM_CONCESSIONARIA"));
                C.setNUM_CNPJ(rs.getString("NUM_CNPJ"));
                C.setDSC_RAZAO_SOCIAL(rs.getString("DSC_RAZAO_SOCIAL"));
                C.setEND_CONCESSIONARIA(rs.getString("END_CONCESSIONARIA"));
                C.setNOM_CONTATO(rs.getString("NOM_CONTATO"));
                C.setNUM_TELEFONE_CONTATO(rs.getString("NUM_TELEFONE_CONTATO"));
                lstC.add(C);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstC;
    }
    
    public int Incluir(Concessionaria C) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_inc_concessionaria(?, ?, ?, ?, ?, ?, ?)}");
            cst.setString(1, C.getNOM_CONCESSIONARIA());
            cst.setString(2, C.getNUM_CNPJ());
            cst.setString(3, C.getDSC_RAZAO_SOCIAL());
            cst.setString(4, C.getEND_CONCESSIONARIA());
            cst.setString(5, C.getNOM_CONTATO());
            cst.setString(6, C.getNUM_TELEFONE_CONTATO());
            cst.registerOutParameter(7, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(7);
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

    public int Alterar(Concessionaria C) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_alt_concessionaria(?, ?, ?, ?, ?, ?, ?)}");
            cst.setString(1, C.getNOM_CONCESSIONARIA());
            cst.setString(2, C.getNUM_CNPJ());
            cst.setString(3, C.getDSC_RAZAO_SOCIAL());
            cst.setString(4, C.getEND_CONCESSIONARIA());
            cst.setString(5, C.getNOM_CONTATO());
            cst.setString(6, C.getNUM_TELEFONE_CONTATO());
            cst.setInt(7, C.getSEQ_CONCESSIONARIA());

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

    public int Excluir(int SEQ_CONCESSIONARIA) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_del_fornecedor(?)}");
            cst.setInt(1, SEQ_CONCESSIONARIA);

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
    public int ConsultarSeq(String NOM_CONCESSIONARIA) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT C.SEQ_CONCESSIONARIA FROM SGA.CONCESSIONARIA C WHERE C.NOM_CONCESSIONARIA = '" + NOM_CONCESSIONARIA + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_CONCESSIONARIA");
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
