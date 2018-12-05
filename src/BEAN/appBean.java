package BEAN;

public final class appBean {

    private String titulo;
    private String tituloExtenso;
    private String siglaSistema;
    private String nomeSistema;

    private String username;
    private String password;
    private String server;
    private String sid;

    public appBean() {
        this.setTitulo("SGA");
        this.setTituloExtenso("Sistema de Gerenciamento de Automóvel");
        this.setSiglaSistema("SGA_SISTEMA");
        this.setNomeSistema("NOM_SISTEMA");

        this.setUsername("sga");
        this.setPassword("sga");
        //this.server = "192.168.0.7";
        //this.sid = "SAAED";

        this.setServer("localhost");
        this.setSid("XE");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloExtenso() {
        return tituloExtenso;
    }

    public void setTituloExtenso(String tituloExtenso) {
        this.tituloExtenso = tituloExtenso;
    }

    public String getSiglaSistema() {
        return siglaSistema;
    }

    public void setSiglaSistema(String siglaSistema) {
        this.siglaSistema = siglaSistema;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
