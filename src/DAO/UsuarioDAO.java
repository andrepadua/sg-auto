package DAO;

import BEAN.appBean;
import Class.ClsConn;
import MODELS.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    ClsConn objConn = new ClsConn();
    appBean ab = new appBean();
    
    public Usuario Consultar(String NOM_USUARIO) throws ClassNotFoundException {
        Usuario u = null;
        try {
            objConn.Connect();
            String sql = "SELECT U.SEQ_USUARIO, U.NOM_USUARIO, U.LOGINNAME, NULL SEQ_PERFIL, P.NOM_PERFIL FROM SGA.USUARIO U INNER JOIN SGA.PERFIL P ON (P.SEQ_PERFIL = U.SEQ_PERFIL) WHERE U.NOM_USUARIL LIKE %" + NOM_USUARIO + "%";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            u = (Usuario) rs.getStatement();

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return u;
    }

    public ArrayList<Usuario> Consultar() throws ClassNotFoundException {
        ArrayList<Usuario> lstU = new ArrayList<>();
        try {
            objConn.Connect();
            String sql = "SELECT U.SEQ_USUARIO, U.NOM_USUARIO, U.LOGINNAME, NULL SEQ_PERFIL, P.NOM_PERFIL FROM SGA.USUARIO U INNER JOIN SGA.PERFIL P ON (P.SEQ_PERFIL = U.SEQ_PERFIL)";
            PreparedStatement stm = objConn.con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setSEQ_USUARIO (rs.getInt("SEQ_USUARIO"));
                u.setNOM_USUARIO(rs.getString("NOM_USUARIO"));
                u.setLOGINNAME(rs.getString("LOGINNAME"));
                u.setNOM_PERFIL(rs.getString("NOM_PERFIL"));
                lstU.add(u);
            }

            rs.close();
            stm.close();
            objConn.Disconnect();
        } catch (SQLException ex) {
            objConn.setMessageException(ex.getMessage());
        }
        return lstU;
    }

    public int Incluir(Usuario u) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.PKG_USUARIO.sp_inc_usuario(?, ?, ?, ?)}");
            cst.setString(1, u.getNOM_USUARIO());
            cst.setString(2, u.getLOGINNAME());
            cst.setInt(3, u.getSEQ_PERFIL());
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

    public int Alterar(Usuario u) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.PKG_USUARIO.sp_alt_usuario(?, ?, ?, ?)}");
            cst.setString(1, u.getNOM_USUARIO());
            cst.setString(2, u.getLOGINNAME());
            cst.setInt(3, u.getSEQ_PERFIL());
            cst.setInt(4, u.getSEQ_USUARIO());
            
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

    public int Excluir(int SEQ_USUARIO) {
        Connection cn = null;
        CallableStatement cst = null;
        int id = 0;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(ab.getUrl());

            cst = cn.prepareCall("{call SGA.PKG_USUARIO.sp_del_usuario(?)}");
            cst.setInt(1, SEQ_USUARIO);

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
}
