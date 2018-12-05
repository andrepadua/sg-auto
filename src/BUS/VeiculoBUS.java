package BUS;

import DAO.VeiculoDAO;
import MODELS.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class VeiculoBUS {
    
        public Veiculo Consultar(int SEQ_VEICULO) throws ClassNotFoundException {
        VeiculoDAO VDao = new VeiculoDAO();
        return VDao.Consultar(SEQ_VEICULO);
    }

    public ArrayList<Veiculo> Consultar() throws ClassNotFoundException {
        VeiculoDAO VDao = new VeiculoDAO();
        return VDao.Consultar();
    }
    
    public ArrayList<Veiculo> ConsultarSeq(int SEQ_VEICULO) throws ClassNotFoundException {
        VeiculoDAO VDao = new VeiculoDAO();
        return VDao.ConsultarSeq(SEQ_VEICULO);
    }
    
    public int Incluir(Veiculo V) {
        int SEQ_VEICULO = 0;
        VeiculoDAO VDao = new VeiculoDAO();
        SEQ_VEICULO = VDao.Incluir(V);
        return SEQ_VEICULO;
    }

    public int Alterar(Veiculo V) {
        int v_count_rows;
        VeiculoDAO VDao = new VeiculoDAO();
        v_count_rows = VDao.Alterar(V);
        return v_count_rows;
    }

    public int Excluir(int SEQ_VEICULO) {
        int v_count_rows;
        VeiculoDAO VDao = new VeiculoDAO();
        v_count_rows = VDao.Excluir(SEQ_VEICULO);
        return v_count_rows;
    }
    
    public String ConsultarNome(int SEQ_VEICULO) throws ClassNotFoundException {
        VeiculoDAO VDao = new VeiculoDAO();
        return VDao.ConsultarNome(SEQ_VEICULO);
    }
}
