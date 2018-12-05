
package BUS;

import DAO.FornecedorDAO;
import MODELS.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class FornecedorBUS {
    
        public Fornecedor Consultar(int SEQ_FORNECEDOR) throws ClassNotFoundException {
        FornecedorDAO FDao = new FornecedorDAO();
        return FDao.Consultar(SEQ_FORNECEDOR);
    }

    public ArrayList<Fornecedor> Consultar() throws ClassNotFoundException {
        FornecedorDAO FDao = new FornecedorDAO();
        return FDao.Consultar();
    }
    
    public ArrayList<Fornecedor> ConsultarSeq(int SEQ_FORNECEDOR) throws ClassNotFoundException {
        FornecedorDAO FDao = new FornecedorDAO();
        return FDao.ConsultarSeq(SEQ_FORNECEDOR);
    }
    
    public int Incluir(Fornecedor F) {
        int SEQ_FORNECEDOR = 0;
        FornecedorDAO FDao = new FornecedorDAO();
        SEQ_FORNECEDOR   = FDao.Incluir(F);
        return SEQ_FORNECEDOR;
    }

    public int Alterar(Fornecedor F) {
        int v_count_rows;
        FornecedorDAO FDao = new FornecedorDAO();
        v_count_rows = FDao.Alterar(F);
        return v_count_rows;
    }

    public int Excluir(int SEQ_FORNECEDOR) {
        int v_count_rows;
        FornecedorDAO FDao = new FornecedorDAO();
        v_count_rows = FDao.Excluir(SEQ_FORNECEDOR);
        return v_count_rows;
    }
    public int fc_get_seq(String NOM_FORNECEDOR) throws ClassNotFoundException {
        FornecedorDAO fDao = new FornecedorDAO();
        return fDao.ConsultarSeq(NOM_FORNECEDOR);
    }
}
