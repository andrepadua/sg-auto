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
public class Peca {
    private int SEQ_PECA;
    private String NOM_PECA;
    private int SEQ_FORNECEDOR;
    private int FLG_PROD_MONT;
    
    private String NOM_FORNECEDOR;
    private String PROD_MONTADORA;
    
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
     * @return the SEQ_FORNECEDOR
     */
    public int getSEQ_FORNECEDOR() {
        return SEQ_FORNECEDOR;
    }

    /**
     * @param SEQ_FORNECEDOR the SEQ_FORNECEDOR to set
     */
    public void setSEQ_FORNECEDOR(int SEQ_FORNECEDOR) {
        this.SEQ_FORNECEDOR = SEQ_FORNECEDOR;
    }

    /**
     * @return the FLG_PROD_MONT
     */
    public int getFLG_PROD_MONT() {
        return FLG_PROD_MONT;
    }

    /**
     * @param FLG_PROD_MONT the FLG_PROD_MONT to set
     */
    public void setFLG_PROD_MONT(int FLG_PROD_MONT) {
        this.FLG_PROD_MONT = FLG_PROD_MONT;
    }

    /**
     * @return the NOM_FORNECEDOR
     */
    public String getNOM_FORNECEDOR() {
        return NOM_FORNECEDOR;
    }

    /**
     * @param NOM_FORNECEDOR the NOM_FORNECEDOR to set
     */
    public void setNOM_FORNECEDOR(String NOM_FORNECEDOR) {
        this.NOM_FORNECEDOR = NOM_FORNECEDOR;
    }

    /**
     * @return the PROD_MONTADORA
     */
    public String getPROD_MONTADORA() {
        return PROD_MONTADORA;
    }

    /**
     * @param PROD_MONTADORA the PROD_MONTADORA to set
     */
    public void setPROD_MONTADORA(String PROD_MONTADORA) {
        this.PROD_MONTADORA = PROD_MONTADORA;
    }
}
