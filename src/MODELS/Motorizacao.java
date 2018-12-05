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
public class Motorizacao {
    private int SEQ_MOTORIZACAO;    
    private int NUM_POTENCIA;
    private double NUM_VELOCIDADE_FINAL;
    private int SEQ_TIPOMOTORIZACAO;
    private String DSC_MOTORIZACAO;
    private double NUM_AUTONOMIA;
    
    private String DESC_TIPOMOTORIZACAO;
    
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
     * @return the NUM_POTENCIA
     */
    public int getNUM_POTENCIA() {
        return NUM_POTENCIA;
    }

    /**
     * @param NUM_POTENCIA the NUM_POTENCIA to set
     */
    public void setNUM_POTENCIA(int NUM_POTENCIA) {
        this.NUM_POTENCIA = NUM_POTENCIA;
    }

    /**
     * @return the NUM_VELOCIDADE_FINAL
     */
    public double getNUM_VELOCIDADE_FINAL() {
        return NUM_VELOCIDADE_FINAL;
    }

    /**
     * @param NUM_VELOCIDADE_FINAL the NUM_VELOCIDADE_FINAL to set
     */
    public void setNUM_VELOCIDADE_FINAL(double NUM_VELOCIDADE_FINAL) {
        this.NUM_VELOCIDADE_FINAL = NUM_VELOCIDADE_FINAL;
    }

    /**
     * @return the SEQ_TIPOMOTORIZACAO
     */
    public int getSEQ_TIPOMOTORIZACAO() {
        return SEQ_TIPOMOTORIZACAO;
    }

    /**
     * @param SEQ_TIPOMOTORIZACAO the SEQ_TIPOMOTORIZACAO to set
     */
    public void setSEQ_TIPOMOTORIZACAO(int SEQ_TIPOMOTORIZACAO) {
        this.SEQ_TIPOMOTORIZACAO = SEQ_TIPOMOTORIZACAO;
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
     * @return the NUM_AUTONOMIA
     */
    public double getNUM_AUTONOMIA() {
        return NUM_AUTONOMIA;
    }

    /**
     * @param NUM_AUTONOMIA the NUM_AUTONOMIA to set
     */
    public void setNUM_AUTONOMIA(double NUM_AUTONOMIA) {
        this.NUM_AUTONOMIA = NUM_AUTONOMIA;
    }

    /**
     * @return the DESC_TIPOMOTORIZACAO
     */
    public String getDESC_TIPOMOTORIZACAO() {
        return DESC_TIPOMOTORIZACAO;
    }

    /**
     * @param DESC_TIPOMOTORIZACAO the DESC_TIPOMOTORIZACAO to set
     */
    public void setDESC_TIPOMOTORIZACAO(String DESC_TIPOMOTORIZACAO) {
        this.DESC_TIPOMOTORIZACAO = DESC_TIPOMOTORIZACAO;
    }
}
