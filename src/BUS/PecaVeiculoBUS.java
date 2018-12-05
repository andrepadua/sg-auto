package BUS;

import DAO.PecaVeiculoDAO;
import MODELS.PecaVeiculo;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class PecaVeiculoBUS {
    
    public ArrayList<PecaVeiculo> Consultar() throws ClassNotFoundException {
        PecaVeiculoDAO pvDao = new PecaVeiculoDAO();
        return pvDao.Consultar();
    }
    public int Incluir(PecaVeiculo pcv) {
        int SEQ_PECAVEICULO = 0;
        PecaVeiculoDAO pcvDao = new PecaVeiculoDAO();
        SEQ_PECAVEICULO = pcvDao.Incluir(pcv);
        return SEQ_PECAVEICULO;
    }

    public int Alterar(PecaVeiculo pcv) {
        int v_count_rows;
        PecaVeiculoDAO pcvDao = new PecaVeiculoDAO();
        v_count_rows = pcvDao.Alterar(pcv);
        return v_count_rows;
    }

    public int Excluir(int SEQ_PECAVEICULO) {
        int v_count_rows;
        PecaVeiculoDAO pcvDao = new PecaVeiculoDAO();
        v_count_rows = pcvDao.Excluir(SEQ_PECAVEICULO);
        return v_count_rows;
    }
}
