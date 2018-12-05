package BUS;

import DAO.TipoMotorizacaoDAO;
import MODELS.TipoMotorizacao;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class TipoMotorizacaoBUS {
    
        public TipoMotorizacao Consultar(int SEQ_TIPOMOTORIZACAO) throws ClassNotFoundException {
        TipoMotorizacaoDAO tmDao = new TipoMotorizacaoDAO();
        return tmDao.Consultar(SEQ_TIPOMOTORIZACAO);
    }

    public ArrayList<TipoMotorizacao> Consultar() throws ClassNotFoundException {
        TipoMotorizacaoDAO tmDao = new TipoMotorizacaoDAO();
        return tmDao.Consultar();
    }
    
    public int Incluir(TipoMotorizacao tm) {
        int SEQ_TIPOMOTORIZACAO = 0;
        TipoMotorizacaoDAO tmDao = new TipoMotorizacaoDAO();
        SEQ_TIPOMOTORIZACAO = tmDao.Incluir(tm);
        return SEQ_TIPOMOTORIZACAO;
    }

    public int Alterar(TipoMotorizacao tm) {
        int v_count_rows;
        TipoMotorizacaoDAO tmDao = new TipoMotorizacaoDAO();
        v_count_rows = tmDao.Alterar(tm);
        return v_count_rows;
    }

    public int Excluir(int SEQ_TIPOMOTORIZACAO) {
        int v_count_rows;
        TipoMotorizacaoDAO tmDao = new TipoMotorizacaoDAO();
        v_count_rows = tmDao.Excluir(SEQ_TIPOMOTORIZACAO);
        return v_count_rows;
    }
    
    public int fc_get_seq(String DESC_TIPOMOTORIZACAO) throws ClassNotFoundException {
        TipoMotorizacaoDAO tmDao = new TipoMotorizacaoDAO();
        return tmDao.ConsultarSeq(DESC_TIPOMOTORIZACAO);
    }
}
