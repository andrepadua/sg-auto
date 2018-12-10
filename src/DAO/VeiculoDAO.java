package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.Veiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();
    
    public Veiculo Consultar(int SEQ_VEICULO) throws ClassNotFoundException {
        Veiculo V = null;
        try {
            objConn.Connect();
            String sql = "SELECT V.SEQ_VEICULO, V.NOM_VEICULO, TV.SEQ_TIPOVEICULO, C.SEQ_CONCESSIONARIA, TV.NOM_TIPOVEICULO, C.NOM_CONCESSIONARIA FROM SGA.VEICULO V INNER JOIN SGA.TIPOVEICULO TV ON (TV.SEQ_TIPOVEICULO = V.SEQ_TIPOVEICULO) INNER JOIN SGA.CONCESSIONARIA C ON (C.SEQ_CONCESSIONARIA = V.SEQ_CONCESSIONARIA) WHERE V.SEQ_VEICULO = " + SEQ_VEICULO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            //V = (Veiculo) rs.getStatement();
            while (rs.next()) {
                V.setSEQ_VEICULO(rs.getInt("SEQ_VEICULO"));
                V.setNOM_VEICULO(rs.getString("NOM_VEICULO"));
                V.setSEQ_TIPOVEICULO(rs.getInt("SEQ_TIPOVEICULO"));
                //V.getSEQ_CONCESSIONARIA(rs.getInt("SEQ_CONCESSIONARIA"));
                V.setNOM_TIPOVEICULO(rs.getString("NOM_TIPOVEICULO"));
                V.setNOM_CONCESSIONARIA(rs.getString("NOM_CONCESSIONARIA"));
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return V;
    }

    public ArrayList<Veiculo> Consultar() throws ClassNotFoundException {
        ArrayList<Veiculo> lstV = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT V.SEQ_VEICULO, V.NOM_VEICULO, NULL SEQ_TIPOVEICULO, NULL SEQ_CONCESSIONARIA, TV.NOM_TIPOVEICULO, C.NOM_CONCESSIONARIA FROM SGA.VEICULO V INNER JOIN SGA.TIPOVEICULO TV ON (TV.SEQ_TIPOVEICULO = V.SEQ_TIPOVEICULO) INNER JOIN SGA.CONCESSIONARIA C ON (C.SEQ_CONCESSIONARIA = V.SEQ_CONCESSIONARIA)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Veiculo V = new Veiculo();
                V.setSEQ_VEICULO(rs.getInt("SEQ_VEICULO"));
                V.setNOM_VEICULO(rs.getString("NOM_VEICULO"));
                V.setNOM_TIPOVEICULO(rs.getString("NOM_TIPOVEICULO"));
                V.setNOM_CONCESSIONARIA(rs.getString("NOM_CONCESSIONARIA"));
                lstV.add(V);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstV;
    }

    public ArrayList<Veiculo> ConsultarSeq(int SEQ_VEICULO) throws ClassNotFoundException {
        ArrayList<Veiculo> lstV = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT V.SEQ_VEICULO, V.NOM_VEICULO, TV.SEQ_TIPOVEICULO, C.SEQ_CONCESSIONARIA, TV.NOM_TIPOVEICULO, C.NOM_CONCESSIONARIA FROM SGA.VEICULO V INNER JOIN SGA.TIPOVEICULO TV ON (TV.SEQ_TIPOVEICULO = V.SEQ_TIPOVEICULO) INNER JOIN SGA.CONCESSIONARIA C ON (C.SEQ_CONCESSIONARIA = V.SEQ_CONCESSIONARIA) WHERE V.SEQ_VEICULO = " + SEQ_VEICULO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Veiculo V = new Veiculo();
                V.setSEQ_VEICULO(rs.getInt("SEQ_VEICULO"));
                V.setNOM_VEICULO(rs.getString("NOM_VEICULO"));
                V.setNOM_TIPOVEICULO(rs.getString("NOM_TIPOVEICULO"));
                V.setNOM_CONCESSIONARIA(rs.getString("NOM_CONCESSIONARIA"));
                lstV.add(V);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstV;
    }
    
    public int Incluir(Veiculo V) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call sp_inc_veiculo(?, ?, ?, ?)}");
            cst.setString(1, V.getNOM_VEICULO());
            cst.setInt(2, V.getSEQ_TIPOVEICULO());
            cst.setInt(3, V.getSEQ_CONCESSIONARIA());
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

    public int Alterar(Veiculo V) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call sp_alt_veiculo(?, ?, ?, ?)}");
            cst.setString(1, V.getNOM_VEICULO());
            cst.setInt(2, V.getSEQ_TIPOVEICULO());
            cst.setInt(3, V.getSEQ_CONCESSIONARIA());
            cst.setInt(4, V.getSEQ_VEICULO());

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

    public int Excluir(int SEQ_VEICULO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call sp_del_veiculo(?)}");
            cst.setInt(1, SEQ_VEICULO);

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
    public String ConsultarNome(int SEQ_VEICULO) throws ClassNotFoundException {
        String Nome = null;
        try {
            objConn.Connect();
            String sql = "SELECT V.NOM_VEICULO FROM SGA.VEICULO V WHERE V.SEQ_VEICULO = " + SEQ_VEICULO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Nome = rs.getString("NOM_VEICULO");
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return Nome;
    }
}
