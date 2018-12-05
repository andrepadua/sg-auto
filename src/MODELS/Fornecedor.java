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
public class Fornecedor {
    private int SEQ_FORNECEDOR;
    private String NOM_FORNECEDOR;
    private String NOM_FANTASIA;
    private String NUM_CNPJ;
    private String DSC_RAZAO_SOCIAL;
    private String END_FORNECEDOR;
    private String NOM_CONTATO;
    private String NUM_TELEFONE_CONTATO;

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
     * @return the NOM_FANTASIA
     */
    public String getNOM_FANTASIA() {
        return NOM_FANTASIA;
    }

    /**
     * @param NOM_FANTASIA the NOM_FANTASIA to set
     */
    public void setNOM_FANTASIA(String NOM_FANTASIA) {
        this.NOM_FANTASIA = NOM_FANTASIA;
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
     * @return the END_FORNECEDOR
     */
    public String getEND_FORNECEDOR() {
        return END_FORNECEDOR;
    }

    /**
     * @param END_FORNECEDOR the END_FORNECEDOR to set
     */
    public void setEND_FORNECEDOR(String END_FORNECEDOR) {
        this.END_FORNECEDOR = END_FORNECEDOR;
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
