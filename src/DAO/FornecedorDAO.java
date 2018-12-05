package DAO;

import Class.ClsConn;
import FORM.frmLogin;
import MODELS.Fornecedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class FornecedorDAO {
    
        ClsConn objConn = new ClsConn();

    public Fornecedor Consultar(int SEQ_FORNECEDOR) throws ClassNotFoundException {
        Fornecedor F = null;
        try {
            objConn.Connect();
            String sql = "SELECT F.SEQ_FORNECEDOR, F.NOM_FORNECEDOR, F.NOM_FANTASIA, F.NUM_CNPJ, F.DSC_RAZAO_SOCIAL, F.END_FORNECEDOR, F.NOM_CONTATO, F.NUM_TELEFONE_CONTATO FROM ACME9.FORNECEDOR F WHERE F.SEQ_FORNECEDOR = " + SEQ_FORNECEDOR;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            F = (Fornecedor) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return F;
    }

    public ArrayList<Fornecedor> Consultar() throws ClassNotFoundException {
        ArrayList<Fornecedor> lstTv = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT F.SEQ_FORNECEDOR, F.NOM_FORNECEDOR, F.NOM_FANTASIA, F.NUM_CNPJ, F.DSC_RAZAO_SOCIAL, F.END_FORNECEDOR, F.NOM_CONTATO, F.NUM_TELEFONE_CONTATO FROM ACME9.FORNECEDOR F";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Fornecedor F = new Fornecedor();
                F.setSEQ_FORNECEDOR(rs.getInt("SEQ_FORNECEDOR"));
                F.setNOM_FORNECEDOR(rs.getString("NOM_FORNECEDOR"));
                F.setNOM_FANTASIA(rs.getString("NOM_FANTASIA"));
                F.setNUM_CNPJ(rs.getString("NUM_CNPJ"));
                F.setDSC_RAZAO_SOCIAL(rs.getString("DSC_RAZAO_SOCIAL"));
                F.setEND_FORNECEDOR(rs.getString("END_FORNECEDOR"));
                F.setNOM_CONTATO(rs.getString("NOM_CONTATO"));
                F.setNUM_TELEFONE_CONTATO(rs.getString("NUM_TELEFONE_CONTATO"));
                lstTv.add(F);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstTv;
    }

    public ArrayList<Fornecedor> ConsultarSeq(int SEQ_FORNECEDOR) throws ClassNotFoundException {
        ArrayList<Fornecedor> lstTv = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT F.SEQ_FORNECEDOR, F.NOM_FORNECEDOR, F.NOM_FANTASIA, F.NUM_CNPJ, F.DSC_RAZAO_SOCIAL, F.END_FORNECEDOR, F.NOM_CONTATO, F.NUM_TELEFONE_CONTATO FROM ACME9.FORNECEDOR F WHERE F.SEQ_FORNECEDOR = " + SEQ_FORNECEDOR;
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Fornecedor F = new Fornecedor();
                F.setSEQ_FORNECEDOR(rs.getInt("SEQ_FORNECEDOR"));
                F.setNOM_FORNECEDOR(rs.getString("NOM_FORNECEDOR"));
                F.setNOM_FANTASIA(rs.getString("NOM_FANTASIA"));
                F.setNUM_CNPJ(rs.getString("NUM_CNPJ"));
                F.setDSC_RAZAO_SOCIAL(rs.getString("DSC_RAZAO_SOCIAL"));
                F.setEND_FORNECEDOR(rs.getString("END_FORNECEDOR"));
                F.setNOM_CONTATO(rs.getString("NOM_CONTATO"));
                F.setNUM_TELEFONE_CONTATO(rs.getString("NUM_TELEFONE_CONTATO"));
                lstTv.add(F);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstTv;
    }
    
    public int Incluir(Fornecedor F) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Guaruenglish?user=crawdio&password=crawdio");

            cst = cn.prepareCall("{call ACME9.PKG_FORNECEDOR.sp_inc_fornecedor(?, ?, ?, ?, ?, ?, ?, ?)}");
            cst.setString(1, F.getNOM_FORNECEDOR());
            cst.setString(2, F.getNOM_FANTASIA());
            cst.setString(3, F.getNUM_CNPJ());
            cst.setString(4, F.getDSC_RAZAO_SOCIAL());
            cst.setString(5, F.getEND_FORNECEDOR());
            cst.setString(6, F.getNOM_CONTATO());
            cst.setString(7, F.getNUM_TELEFONE_CONTATO());
            cst.registerOutParameter(8, java.sql.Types.INTEGER);

            int r = cst.executeUpdate();
            if (r > 0) {
                id = cst.getInt(8);
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

    public int Alterar(Fornecedor F) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Guaruenglish?user=crawdio&password=crawdio");

            cst = cn.prepareCall("{call ACME9.PKG_FORNECEDOR.sp_alt_fornecedor(?, ?, ?, ?, ?, ?, ?, ?)}");
            cst.setString(1, F.getNOM_FORNECEDOR());
            cst.setString(2, F.getNOM_FANTASIA());
            cst.setString(3, F.getNUM_CNPJ());
            cst.setString(4, F.getDSC_RAZAO_SOCIAL());
            cst.setString(5, F.getEND_FORNECEDOR());
            cst.setString(6, F.getNOM_CONTATO());
            cst.setString(7, F.getNUM_TELEFONE_CONTATO());
            cst.setInt(8, F.getSEQ_FORNECEDOR());

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

    public int Excluir(int SEQ_FORNECEDOR) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection("jdbc:mysql://localhost/Guaruenglish?user=crawdio&password=crawdio");

            cst = cn.prepareCall("{call ACME9.PKG_FORNECEDOR.sp_del_fornecedor(?)}");
            cst.setInt(1, SEQ_FORNECEDOR);

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
    public int ConsultarSeq(String NOM_FORNECEDOR) throws ClassNotFoundException {
        int Seq = 0;
        try {
            objConn.Connect();
            String sql = "SELECT F.SEQ_FORNECEDOR FROM ACME9.FORNECEDOR F WHERE F.NOM_FORNECEDOR = '" + NOM_FORNECEDOR + "'";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Seq = rs.getInt("SEQ_FORNECEDOR");
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
