package by.bsuir.bocharenko.rms.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
    private static EMFactory instance;
    private EntityManagerFactory emf;
    private static String dbname;
    private static String port;
    private static String username;
    private static String password;
    private String URL = "jdbc:mysql://localhost/";
    private String Driver = "com.mysql.jdbc.Driver";
    
    public EMFactory() throws SQLException{
        try {
            Class.forName(Driver);
            java.util.Properties connectionProperties = new java.util.Properties();
            connectionProperties.put("driver", Driver);
            connectionProperties.put("user", username);
            connectionProperties.put("password", password);
            Connection con = DriverManager.getConnection(URL, connectionProperties);
            
            String query = "CREATE DATABASE IF NOT EXISTS " + dbname;

            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        
        Map properties = new HashMap();
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:"+port+"/"+dbname);
        properties.put("hibernate.connection.username", username);
        properties.put("hibernate.connection.password", password);
        emf = Persistence.createEntityManagerFactory("RMS", properties);
    }
    
    public static EMFactory getInstance(){
        if(instance==null)
            try {
                instance = new EMFactory();
        } catch (SQLException ex) {
            Logger.getLogger(EMFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        EMFactory.port = port;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        EMFactory.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        EMFactory.password = password;
    }

    public static String getDbname() {
        return dbname;
    }

    public static void setDbname(String dbname) {
        EMFactory.dbname = dbname;
    }
    
    
}
