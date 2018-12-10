package BEAN;

public final class appBean {

    private String titulo;
    private String tituloExtenso;
    private String siglaSistema;
    private String nomeSistema;

    private String username;
    private String password;
    private String url;

    public appBean() {
        this.setTitulo("SGA");
        this.setTituloExtenso("Sistema de Gerenciamento de Automóvel");
        this.setSiglaSistema("SGA_SISTEMA");
        this.setNomeSistema("NOM_SISTEMA");

        this.setUsername("sga");
        this.setPassword("sga");
        //this.server = "192.168.0.7";
        //this.sid = "SAAED";

        this.setUrl("jdbc:mysql://localhost/sga?user=sga&password=sga");
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

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
