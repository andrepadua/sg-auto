/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author André
 */
public class Usuario {
    
    private int SEQ_USUARIO;
    private String NOM_USUARIO;
    private String LOGINNAME;
    private int SEQ_PERFIL;
    
    private String NOM_PERFIL;

    /**
     * @return the SEQ_USUARIO
     */
    public int getSEQ_USUARIO() {
        return SEQ_USUARIO;
    }

    /**
     * @param SEQ_USUARIO the SEQ_USUARIO to set
     */
    public void setSEQ_USUARIO(int SEQ_USUARIO) {
        this.SEQ_USUARIO = SEQ_USUARIO;
    }

    /**
     * @return the NOM_USUARIO
     */
    public String getNOM_USUARIO() {
        return NOM_USUARIO;
    }

    /**
     * @param NOM_USUARIO the NOM_USUARIO to set
     */
    public void setNOM_USUARIO(String NOM_USUARIO) {
        this.NOM_USUARIO = NOM_USUARIO;
    }

    /**
     * @return the LOGINNAME
     */
    public String getLOGINNAME() {
        return LOGINNAME;
    }

    /**
     * @param LOGINNAME the LOGINNAME to set
     */
    public void setLOGINNAME(String LOGINNAME) {
        this.LOGINNAME = LOGINNAME;
    }

    /**
     * @return the SEQ_PERFIL
     */
    public int getSEQ_PERFIL() {
        return SEQ_PERFIL;
    }

    /**
     * @param SEQ_PERFIL the SEQ_PERFIL to set
     */
    public void setSEQ_PERFIL(int SEQ_PERFIL) {
        this.SEQ_PERFIL = SEQ_PERFIL;
    }

    /**
     * @return the NOM_PERFIL
     */
    public String getNOM_PERFIL() {
        return NOM_PERFIL;
    }

    /**
     * @param NOM_PERFIL the NOM_PERFIL to set
     */
    public void setNOM_PERFIL(String NOM_PERFIL) {
        this.NOM_PERFIL = NOM_PERFIL;
    }
}
