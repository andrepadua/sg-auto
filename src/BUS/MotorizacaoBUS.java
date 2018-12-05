package BUS;

import DAO.MotorizacaoDAO;
import MODELS.Motorizacao;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class MotorizacaoBUS {
    
        public Motorizacao Consultar(int SEQ_MOTORIZACAO) throws ClassNotFoundException {
        MotorizacaoDAO MDao = new MotorizacaoDAO();
        return MDao.Consultar(SEQ_MOTORIZACAO);
    }

    public ArrayList<Motorizacao> Consultar() throws ClassNotFoundException {
        MotorizacaoDAO MDao = new MotorizacaoDAO();
        return MDao.Consultar();
    }
    
    public ArrayList<Motorizacao> ConsultarSeq(int SEQ_MOTORIZACAO) throws ClassNotFoundException {
        MotorizacaoDAO MDao = new MotorizacaoDAO();
        return MDao.ConsultarSeq(SEQ_MOTORIZACAO);
    }
    
    public int Incluir(Motorizacao M) {
        int SEQ_MOTORIZACAO = 0;
        MotorizacaoDAO MDao = new MotorizacaoDAO();
        SEQ_MOTORIZACAO = MDao.Incluir(M);
        return SEQ_MOTORIZACAO;
    }

    public int Alterar(Motorizacao M) {
        int v_count_rows;
        MotorizacaoDAO MDao = new MotorizacaoDAO();
        v_count_rows = MDao.Alterar(M);
        return v_count_rows;
    }

    public int Excluir(int SEQ_MOTORIZACAO) {
        int v_count_rows;
        MotorizacaoDAO MDao = new MotorizacaoDAO();
        v_count_rows = MDao.Excluir(SEQ_MOTORIZACAO);
        return v_count_rows;
    }
    
    public int fc_get_seq(String NOM_MOTORIZACAO) throws ClassNotFoundException {
        MotorizacaoDAO mDao = new MotorizacaoDAO();
        return mDao.ConsultarSeq(NOM_MOTORIZACAO);
    }
}
