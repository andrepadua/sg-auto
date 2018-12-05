package BUS;

import DAO.PerfilDAO;
import MODELS.Perfil;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class PerfilBUS {
    
    public Perfil Consultar(int SEQ_PERFIL) throws ClassNotFoundException {
        PerfilDAO pDao = new PerfilDAO();
        return pDao.Consultar(SEQ_PERFIL);
    }

    public int fc_get_seq(String NOM_PERFIL) throws ClassNotFoundException {
        PerfilDAO pDao = new PerfilDAO();
        return pDao.ConsultarSeq(NOM_PERFIL);
    }
    
    public ArrayList<Perfil> Consultar() throws ClassNotFoundException {
        PerfilDAO pDao = new PerfilDAO();
        return pDao.Consultar();
    }
}
