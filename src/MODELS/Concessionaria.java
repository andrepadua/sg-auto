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
public class Concessionaria {
    private int SEQ_CONCESSIONARIA;
    private String NOM_CONCESSIONARIA;
    private String NUM_CNPJ;
    private String DSC_RAZAO_SOCIAL;
    private String END_CONCESSIONARIA;
    private String NOM_CONTATO;
    private String NUM_TELEFONE_CONTATO;

    /**
     * @return the SEQ_CONCESSIONARIA
     */
    public int getSEQ_CONCESSIONARIA() {
        return SEQ_CONCESSIONARIA;
    }

    /**
     * @param SEQ_CONCESSIONARIA the SEQ_CONCESSIONARIA to set
     */
    public void setSEQ_CONCESSIONARIA(int SEQ_CONCESSIONARIA) {
        this.SEQ_CONCESSIONARIA = SEQ_CONCESSIONARIA;
    }

    /**
     * @return the NOM_CONCESSIONARIA
     */
    public String getNOM_CONCESSIONARIA() {
        return NOM_CONCESSIONARIA;
    }

    /**
     * @param NOM_CONCESSIONARIA the NOM_CONCESSIONARIA to set
     */
    public void setNOM_CONCESSIONARIA(String NOM_CONCESSIONARIA) {
        this.NOM_CONCESSIONARIA = NOM_CONCESSIONARIA;
    }

    /**
     * @return the NUM_CNPJ
     */
    public String getNUM_CNPJ() {
        return NUM_CNPJ;
    }

    /**
     * @param NUM_CNPJ the NUM_CNPJ to set
     */
    public void setNUM_CNPJ(String NUM_CNPJ) {
        this.NUM_CNPJ = NUM_CNPJ;
    }

    /**
     * @return the DSC_RAZAO_SOCIAL
     */
    public String getDSC_RAZAO_SOCIAL() {
        return DSC_RAZAO_SOCIAL;
    }

    /**
     * @param DSC_RAZAO_SOCIAL the DSC_RAZAO_SOCIAL to set
     */
    public void setDSC_RAZAO_SOCIAL(String DSC_RAZAO_SOCIAL) {
        this.DSC_RAZAO_SOCIAL = DSC_RAZAO_SOCIAL;
    }

    /**
     * @return the END_CONCESSIONARIA
     */
    public String getEND_CONCESSIONARIA() {
        return END_CONCESSIONARIA;
    }

    /**
     * @param END_CONCESSIONARIA the END_CONCESSIONARIA to set
     */
    public void setEND_CONCESSIONARIA(String END_CONCESSIONARIA) {
        this.END_CONCESSIONARIA = END_CONCESSIONARIA;
    }

    /**
     * @return the NOM_CONTATO
     */
    public String getNOM_CONTATO() {
        return NOM_CONTATO;
    }

    /**
     * @param NOM_CONTATO the NOM_CONTATO to set
     */
    public void setNOM_CONTATO(String NOM_CONTATO) {
        this.NOM_CONTATO = NOM_CONTATO;
    }

    /**
     * @return the NUM_TELEFONE_CONTATO
     */
    public String getNUM_TELEFONE_CONTATO() {
        return NUM_TELEFONE_CONTATO;
    }

    /**
     * @param NUM_TELEFONE_CONTATO the NUM_TELEFONE_CONTATO to set
     */
    public void setNUM_TELEFONE_CONTATO(String NUM_TELEFONE_CONTATO) {
        this.NUM_TELEFONE_CONTATO = NUM_TELEFONE_CONTATO;
    }
}
