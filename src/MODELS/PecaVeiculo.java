/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author Thiago Xavier
 */
public class PecaVeiculo {
    private int SEQ_PECAVEICULO;
    private int SEQ_PECA;
    private int SEQ_VEICULO;

    private String NOM_PECA;
    private String NOM_VEICULO;
    
    /**
     * @return the SEQ_PECAVEICULO
     */
    public int getSEQ_PECAVEICULO() {
        return SEQ_PECAVEICULO;
    }

    /**
     * @param SEQ_PECAVEICULO the SEQ_PECAVEICULO to set
     */
    public void setSEQ_PECAVEICULO(int SEQ_PECAVEICULO) {
        this.SEQ_PECAVEICULO = SEQ_PECAVEICULO;
    }

    /**
     * @return the SEQ_PECA
     */
    public int getSEQ_PECA() {
        return SEQ_PECA;
    }

    /**
     * @param SEQ_PECA the SEQ_PECA to set
     */
    public void setSEQ_PECA(int SEQ_PECA) {
        this.SEQ_PECA = SEQ_PECA;
    }

    /**
     * @return the SEQ_VEICULO
     */
    public int getSEQ_VEICULO() {
        return SEQ_VEICULO;
    }

    /**
     * @param SEQ_VEICULO the SEQ_VEICULO to set
     */
    public void setSEQ_VEICULO(int SEQ_VEICULO) {
        this.SEQ_VEICULO = SEQ_VEICULO;
    }

    /**
     * @return the NOM_PECA
     */
    public String getNOM_PECA() {
        return NOM_PECA;
    }

    /**
     * @param NOM_PECA the NOM_PECA to set
     */
    public void setNOM_PECA(String NOM_PECA) {
        this.NOM_PECA = NOM_PECA;
    }

    /**
     * @return the NOM_VEICULO
     */
    public String getNOM_VEICULO() {
        return NOM_VEICULO;
    }

    /**
     * @param NOM_VEICULO the NOM_VEICULO to set
     */
    public void setNOM_VEICULO(String NOM_VEICULO) {
        this.NOM_VEICULO = NOM_VEICULO;
    }
}
