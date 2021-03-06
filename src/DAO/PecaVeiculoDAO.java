package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.PecaVeiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaVeiculoDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();

    public ArrayList<PecaVeiculo> Consultar() throws ClassNotFoundException {
        ArrayList<PecaVeiculo> lstPV = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT PV.SEQ_PECAVEICULO, PV.SEQ_PECA, PV.SEQ_VEICULO, P.NOM_PECA, V.NOM_VEICULO FROM SGA.PECAVEICULO PV INNER JOIN SGA.VEICULO V ON (V.SEQ_VEICULO = PV.SEQ_VEICULO) INNER JOIN SGA.PECA P ON (P.SEQ_PECA = PV.SEQ_PECA)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                PecaVeiculo pv = new PecaVeiculo();
                pv.setSEQ_PECAVEICULO(rs.getInt("SEQ_PECAVEICULO"));
                pv.setSEQ_VEICULO(rs.getInt("SEQ_VEICULO"));
                pv.setSEQ_PECA(rs.getInt("SEQ_PECA"));
                pv.setNOM_PECA(rs.getString("NOM_PECA"));
                lstPV.add(pv);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstPV;
    }

    public int Incluir(PecaVeiculo pcv) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call sp_inc_pecaveiculo(?, ?, ?)}");
            cst.setInt(1, pcv.getSEQ_PECA());
            cst.setInt(2, pcv.getSEQ_VEICULO());
            cst.registerOutParameter(3, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(3);
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

    public int Alterar(PecaVeiculo pcv) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call sp_alt_pecaveiculo(?, ?, ?)}");
            cst.setInt(1, pcv.getSEQ_PECA());
            cst.setInt(2, pcv.getSEQ_VEICULO());
            cst.setInt(3, pcv.getSEQ_PECAVEICULO());

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

    public int Excluir(int SEQ_PECAVEICULO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call sp_del_pecaveiculo(?)}");
            cst.setInt(1, SEQ_PECAVEICULO);

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
}
