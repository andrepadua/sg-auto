package BUS;

import DAO.TipoVeiculoDAO;
import MODELS.TipoVeiculo;
import java.util.ArrayList;

/**
 *
 * @author andreferreira
 */
public class TipoVeiculoBUS {
    
    public TipoVeiculo Consultar(int SEQ_TIPOVEICULO) throws ClassNotFoundException {
        TipoVeiculoDAO tvDao = new TipoVeiculoDAO();
        return tvDao.Consultar(SEQ_TIPOVEICULO);
    }

    public ArrayList<TipoVeiculo> Consultar() throws ClassNotFoundException {
        TipoVeiculoDAO tvDao = new TipoVeiculoDAO();
        return tvDao.Consultar();
    }
    
    public int Incluir(TipoVeiculo tv) {
        int SEQ_TIPOVEICULO = 0;
        TipoVeiculoDAO tvDao = new TipoVeiculoDAO();
        SEQ_TIPOVEICULO = tvDao.Incluir(tv);
        return SEQ_TIPOVEICULO;
    }

    public int Alterar(TipoVeiculo tv) {
        int v_count_rows;
        TipoVeiculoDAO tvDao = new TipoVeiculoDAO();
        v_count_rows = tvDao.Alterar(tv);
        return v_count_rows;
    }

    public int Excluir(int SEQ_TIPOVEICULO) {
        int v_count_rows;
        TipoVeiculoDAO tvDao = new TipoVeiculoDAO();
        v_count_rows = tvDao.Excluir(SEQ_TIPOVEICULO);
        return v_count_rows;
    }
    public int fc_get_seq(String NOM_TIPOVEICULO) throws ClassNotFoundException {
        TipoVeiculoDAO tvDao = new TipoVeiculoDAO();
        return tvDao.ConsultarSeq(NOM_TIPOVEICULO);
    }
}
