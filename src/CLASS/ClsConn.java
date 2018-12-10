package Class;

import BEAN.appBean;
import java.sql.*;

public class ClsConn {

    private String messageException;
    public Connection con = null;
    appBean ab = new appBean();

    public void Connect() throws SQLException, ClassNotFoundException {
                                                   
        try {
            Class.forName(ab.getClassforname());
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(ab.getUrl(), ab.getUsername(), ab.getPassword());
            this.messageException = "OK";
        } catch (SQLException ex) {
            this.messageException = ex.getMessage();
        }
    }

    public void Disconnect() throws SQLException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            this.messageException = ex.getMessage();
        }
    }

    public boolean isConnected() throws SQLException {
        return con.isClosed();
    }

    /**
     * @return the messageException
     */
    public String getMessageException() {
        return messageException;
    }

    /**
     * @param messageException the messageException to set
     */
    public void setMessageException(String messageException) {
        this.messageException = messageException;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

}