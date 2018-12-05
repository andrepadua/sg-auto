/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.AcessorioDAO;
import MODELS.Acessorio;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class AcessorioBUS {

    public Acessorio Consultar(int SEQ_ACESSORIO) throws ClassNotFoundException {
        AcessorioDAO aDao = new AcessorioDAO();
        return aDao.Consultar(SEQ_ACESSORIO);
    }

    public ArrayList<Acessorio> Consultar() throws ClassNotFoundException {
        AcessorioDAO aDao = new AcessorioDAO();
        return aDao.Consultar();
    }
    
    public ArrayList<Acessorio> ConsultarSeq(int SEQ_ACESSORIO) throws ClassNotFoundException {
        AcessorioDAO aDao = new AcessorioDAO();
        return aDao.ConsultarSeq(SEQ_ACESSORIO);
    }

    public int Incluir(Acessorio a) {
        int SEQ_ACESSORIO = 0;
        AcessorioDAO aDao = new AcessorioDAO();
        SEQ_ACESSORIO = aDao.Incluir(a);
        return SEQ_ACESSORIO;
    }

    public int Alterar(Acessorio a) {
        int v_count_rows;
        AcessorioDAO aDao = new AcessorioDAO();
        v_count_rows = aDao.Alterar(a);
        return v_count_rows;
    }

    public int Excluir(int SEQ_ACESSORIO) {
        int v_count_rows;
        AcessorioDAO aDao = new AcessorioDAO();
        v_count_rows = aDao.Excluir(SEQ_ACESSORIO);
        return v_count_rows;
    }
    public int fc_get_seq(String NOM_ACESSORIO) throws ClassNotFoundException {
        AcessorioDAO aDao = new AcessorioDAO();
        return aDao.ConsultarSeq(NOM_ACESSORIO);
    }
}
