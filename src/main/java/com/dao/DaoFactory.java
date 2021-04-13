package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.conf.JDBCConfiguration;

public class DaoFactory {
	
	//Attributs
	
    private String url;
    private String username;
    private String password;
    
    //Constructeur

    public DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    //Méthode
    
    public static DaoFactory getInstance() {
        try {
            Class.forName(JDBCConfiguration.DRIVER);
        } catch (ClassNotFoundException e) {
        }
        DaoFactory instance = new DaoFactory(JDBCConfiguration.HOST, JDBCConfiguration.USER, JDBCConfiguration.MDP);
        return instance;
    }

    public Connection getConnection() throws SQLException {
    	Connection connexion = DriverManager.getConnection(url,username,password);       
        return connexion;
    }

    //Récupération du Dao
    
    public VilleDao getUtilisateurDao() {
        return new VilleDaoImpl(this);
    }
}