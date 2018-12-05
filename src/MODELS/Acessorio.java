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
public class Acessorio {
    private int SEQ_ACESSORIO;
    private String NOM_ACESSORIO;
    private double VAL_ACESSORIO;
    private int SEQ_MOTORIZACAO;
    private int SEQ_FORNECEDOR;
    
    private String DSC_MOTORIZACAO;
    private String NOM_FORNECEDOR;
    
    /**
     * @return the SEQ_ACESSORIO
     */
    public int getSEQ_ACESSORIO() {
        return SEQ_ACESSORIO;
    }

    /**
     * @param SEQ_ACESSORIO the SEQ_ACESSORIO to set
     */
    public void setSEQ_ACESSORIO(int SEQ_ACESSORIO) {
        this.SEQ_ACESSORIO = SEQ_ACESSORIO;
    }

    /**
     * @return the NOM_ACESSORIO
     */
    public String getNOM_ACESSORIO() {
        return NOM_ACESSORIO;
    }

    /**
     * @param NOM_ACESSORIO the NOM_ACESSORIO to set
     */
    public void setNOM_ACESSORIO(String NOM_ACESSORIO) {
        this.NOM_ACESSORIO = NOM_ACESSORIO;
    }

    /**
     * @return the VAL_ACESSORIO
     */
    public double getVAL_ACESSORIO() {
        return VAL_ACESSORIO;
    }

    /**
     * @param VAL_ACESSORIO the VAL_ACESSORIO to set
     */
    public void setVAL_ACESSORIO(double VAL_ACESSORIO) {
        this.VAL_ACESSORIO = VAL_ACESSORIO;
    }

    /**
     * @return the SEQ_MOTORIZACAO
     */
    public int getSEQ_MOTORIZACAO() {
        return SEQ_MOTORIZACAO;
    }

    /**
     * @param SEQ_MOTORIZACAO the SEQ_MOTORIZACAO to set
     */
    public void setSEQ_MOTORIZACAO(int SEQ_MOTORIZACAO) {
        this.SEQ_MOTORIZACAO = SEQ_MOTORIZACAO;
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
     * @return the DSC_MOTORIZACAO
     */
    public String getDSC_MOTORIZACAO() {
        return DSC_MOTORIZACAO;
    }

    /**
     * @param DSC_MOTORIZACAO the DSC_MOTORIZACAO to set
     */
    public void setDSC_MOTORIZACAO(String DSC_MOTORIZACAO) {
        this.DSC_MOTORIZACAO = DSC_MOTORIZACAO;
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
}
