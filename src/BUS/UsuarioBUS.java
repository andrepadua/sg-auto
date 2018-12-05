package BUS;

import DAO.UsuarioDAO;
import MODELS.Usuario;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class UsuarioBUS {

    public Usuario Consultar(String NOM_USUARIO) throws ClassNotFoundException {
        UsuarioDAO uDao = new UsuarioDAO();
        return uDao.Consultar(NOM_USUARIO);
    }

    public ArrayList<Usuario> Consultar() throws ClassNotFoundException {
        UsuarioDAO uDao = new UsuarioDAO();
        return uDao.Consultar();
    }

    public int Incluir(Usuario u) {
        int SEQ_USUARIO = 0;
        UsuarioDAO uDao = new UsuarioDAO();
        SEQ_USUARIO = uDao.Incluir(u);
        return SEQ_USUARIO;
    }

    public int Alterar(Usuario u) {
        int v_count_rows;
        UsuarioDAO uDao = new UsuarioDAO();
        v_count_rows = uDao.Alterar(u);
        return v_count_rows;
    }

    public int Excluir(int SEQ_USUARIO) {
        int v_count_rows;
        UsuarioDAO uDao = new UsuarioDAO();
        v_count_rows = uDao.Excluir(SEQ_USUARIO);
        return v_count_rows;
    }
}
