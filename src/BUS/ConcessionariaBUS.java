package BUS;

import DAO.ConcessionariaDAO;
import MODELS.Concessionaria;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class ConcessionariaBUS {
    
        public Concessionaria Consultar(int SEQ_CONCESSIONARIA) throws ClassNotFoundException {
        ConcessionariaDAO CDao = new ConcessionariaDAO();
        return CDao.Consultar(SEQ_CONCESSIONARIA);
    }

    public ArrayList<Concessionaria> Consultar() throws ClassNotFoundException {
        ConcessionariaDAO CDao = new ConcessionariaDAO();
        return CDao.Consultar();
    }
    public ArrayList<Concessionaria> ConsultarSeq(int SEQ_CONCESSIONARIA) throws ClassNotFoundException {
        ConcessionariaDAO CDao = new ConcessionariaDAO();
        return CDao.ConsultarSeq(SEQ_CONCESSIONARIA);
    }
    public int Incluir(Concessionaria C) {
        int SEQ_CONCESSIONARIA = 0;
        ConcessionariaDAO CDao = new ConcessionariaDAO();
        SEQ_CONCESSIONARIA   = CDao.Incluir(C);
        return SEQ_CONCESSIONARIA;
    }

    public int Alterar(Concessionaria C) {
        int v_count_rows;
        ConcessionariaDAO CDao = new ConcessionariaDAO();
        v_count_rows = CDao.Alterar(C);
        return v_count_rows;
    }

    public int Excluir(int SEQ_CONCESSIONARIA) {
        int v_count_rows;
        ConcessionariaDAO CDao = new ConcessionariaDAO();
        v_count_rows = CDao.Excluir(SEQ_CONCESSIONARIA);
        return v_count_rows;
    }
    public int fc_get_seq(String NOM_CONCESSIONARIA) throws ClassNotFoundException {
        ConcessionariaDAO cDao = new ConcessionariaDAO();
        return cDao.ConsultarSeq(NOM_CONCESSIONARIA);
    }
}
