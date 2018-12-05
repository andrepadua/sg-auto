/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PecaDAO;
import MODELS.Peca;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class PecaBUS {
    
        public Peca Consultar(int SEQ_PECA) throws ClassNotFoundException {
        PecaDAO pcDao = new PecaDAO();
        return pcDao.Consultar(SEQ_PECA);
    }

    public ArrayList<Peca> Consultar() throws ClassNotFoundException {
        PecaDAO pcDao = new PecaDAO();
        return pcDao.Consultar();
    }
    
    public ArrayList<Peca> ConsultarSeq(int SEQ_PECA) throws ClassNotFoundException {
        PecaDAO pcDao = new PecaDAO();
        return pcDao.ConsultarSeq(SEQ_PECA);
    }
    
    public int Incluir(Peca pc) {
        int SEQ_PECA = 0;
        PecaDAO pcDao = new PecaDAO();
        SEQ_PECA   = pcDao.Incluir(pc);
        return SEQ_PECA;
    }

    public int Alterar(Peca pc) {
        int v_count_rows;
        PecaDAO CDao = new PecaDAO();
        v_count_rows = CDao.Alterar(pc);
        return v_count_rows;
    }

    public int Excluir(int SEQ_PECA) {
        int v_count_rows;
        PecaDAO pcDao = new PecaDAO();
        v_count_rows = pcDao.Excluir(SEQ_PECA);
        return v_count_rows;
    }
    public int fc_get_seq(String NOM_PECA) throws ClassNotFoundException {
        PecaDAO pDao = new PecaDAO();
        return pDao.ConsultarSeq(NOM_PECA);
    }
}
