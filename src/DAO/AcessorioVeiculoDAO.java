package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.AcessorioVeiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcessorioVeiculoDAO {

    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();

    public AcessorioVeiculo ConsultarAcessorio(int SEQ_ACESSORIO) throws ClassNotFoundException {
        AcessorioVeiculo av = null;
        try {
            objConn.Connect();
            String sql = "SELECT AV.SEQ_ACESSORIOVEICULO, AV.SEQ_ACESSORIO, AV.SEQ_VEICULO, A.NOM_ACESSORIO, V.NOM_VEICULO FROM SGA.ACESSORIOVEICULO AV INNER JOIN SGA.VEICULO V ON (V.SEQ_VEICULO = AV.SEQ_VEICULO) INNER JOIN SGA.ACESSORIO A ON (A.SEQ_ACESSORIO = AV.SEQ_ACESSORIO) WHERE AV.SEQ_ACESSORIO = " + SEQ_ACESSORIO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            av = (AcessorioVeiculo) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return av;
    }

    public AcessorioVeiculo ConsultarVeiculo(int SEQ_VEICULO) throws ClassNotFoundException {
        AcessorioVeiculo av = null;
        try {
            objConn.Connect();
            String sql = "SELECT AV.SEQ_ACESSORIOVEICULO, AV.SEQ_ACESSORIO, AV.SEQ_VEICULO, A.NOM_ACESSORIO, V.NOM_VEICULO FROM SGA.ACESSORIOVEICULO AV INNER JOIN SGA.VEICULO V ON (V.SEQ_VEICULO = AV.SEQ_VEICULO) INNER JOIN SGA.ACESSORIO A ON (A.SEQ_ACESSORIO = AV.SEQ_ACESSORIO) WHERE AV.SEQ_VEICULO = " + SEQ_VEICULO;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            av = (AcessorioVeiculo) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return av;
    }

    public ArrayList<AcessorioVeiculo> Consultar() throws ClassNotFoundException {
        ArrayList<AcessorioVeiculo> lstAV = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT AV.SEQ_ACESSORIOVEICULO, AV.SEQ_ACESSORIO, AV.SEQ_VEICULO, A.NOM_ACESSORIO, V.NOM_VEICULO FROM SGA.ACESSORIOVEICULO AV INNER JOIN SGA.VEICULO V ON (V.SEQ_VEICULO = AV.SEQ_VEICULO) INNER JOIN SGA.ACESSORIO A ON (A.SEQ_ACESSORIO = AV.SEQ_ACESSORIO)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                AcessorioVeiculo a = new AcessorioVeiculo();
                a.setSEQ_ACESSORIOVEICULO(rs.getInt("SEQ_ACESSORIOVEICULO"));
                a.setSEQ_VEICULO(rs.getInt("SEQ_VEICULO"));
                a.setSEQ_ACESSORIO(rs.getInt("SEQ_ACESSORIO"));
                a.setNOM_ACESSORIO(rs.getString("NOM_ACESSORIO"));
                lstAV.add(a);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstAV;
    }

    public int Incluir(AcessorioVeiculo av) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_inc_acessorioveiculo(?, ?, ?)}");
            cst.setInt(1, av.getSEQ_ACESSORIO());
            cst.setInt(2, av.getSEQ_VEICULO());
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

    public int Alterar(AcessorioVeiculo av) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_alt_acessorioveiculo(?, ?, ?)}");
            cst.setInt(1, av.getSEQ_ACESSORIO());
            cst.setInt(2, av.getSEQ_VEICULO());
            cst.setInt(3, av.getSEQ_ACESSORIOVEICULO());

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

    public int Excluir(int SEQ_ACESSORIOVEICULO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.sp_del_acessorioveiculo(?)}");
            cst.setInt(1, SEQ_ACESSORIOVEICULO);

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
