/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.*;

/**
 *
 * @author andreferreira
 */
public class ClsConn {

    private String messageException;
    public Connection con = null;

    public void Connect() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost/sg-auto?user=crawdio&password=crawdio";
                                           
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url, "crawdio", "crawdio");
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