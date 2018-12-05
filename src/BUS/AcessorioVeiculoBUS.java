/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.AcessorioVeiculoDAO;
import MODELS.AcessorioVeiculo;
import java.util.ArrayList;

/**
 *
 * @author Thiago Xavier
 */
public class AcessorioVeiculoBUS {

    public AcessorioVeiculo ConsultarAcessorio(int SEQ_ACESSORIO) throws ClassNotFoundException {
        AcessorioVeiculoDAO avDao = new AcessorioVeiculoDAO();
        return avDao.ConsultarAcessorio(SEQ_ACESSORIO);
    }

    public AcessorioVeiculo ConsultarVeiculo(int SEQ_VEICULO) throws ClassNotFoundException {
        AcessorioVeiculoDAO avDao = new AcessorioVeiculoDAO();
        return avDao.ConsultarVeiculo(SEQ_VEICULO);
    }

    public ArrayList<AcessorioVeiculo> Consultar() throws ClassNotFoundException {
        AcessorioVeiculoDAO avDao = new AcessorioVeiculoDAO();
        return avDao.Consultar();
    }

    public int Incluir(AcessorioVeiculo av) {
        int SEQ_ACESSORIOVEICULO = 0;
        AcessorioVeiculoDAO avDao = new AcessorioVeiculoDAO();
        SEQ_ACESSORIOVEICULO = avDao.Incluir(av);
        return SEQ_ACESSORIOVEICULO;
    }

    public int Alterar(AcessorioVeiculo av) {
        int v_count_rows;
        AcessorioVeiculoDAO avDao = new AcessorioVeiculoDAO();
        v_count_rows = avDao.Alterar(av);
        return v_count_rows;
    }

    public int Excluir(int SEQ_ACESSORIOVEICULO) {
        int v_count_rows;
        AcessorioVeiculoDAO avDao = new AcessorioVeiculoDAO();
        v_count_rows = avDao.Excluir(SEQ_ACESSORIOVEICULO);
        return v_count_rows;
    }
}
