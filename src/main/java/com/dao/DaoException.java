package com.dao;

public class DaoException extends Exception {
	
	public static final String ERREUR = "Erreur dans la base de donneés.";
	
	//Constructeur
	
	public DaoException (String message) {
		super(message);
	}
}