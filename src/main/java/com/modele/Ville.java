package com.modele;

public class Ville {
	
	//Attribut
	
	private String code;
	private String nom;
	private String codePostal;
	private String libelle;
	private String ligne;
	private String latitude;
	private String longitude;
	
	public Ville() {		
	}
	
	public Ville(String code, String nom, String codePostal, String libelle, String ligne, String latitude,
			String longitude) {
		this.code = code;
		this.nom = nom;
		this.codePostal = codePostal;
		this.libelle = libelle;
		this.ligne = ligne;
		this.latitude = latitude;
		this.longitude = longitude;
	}	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}	
}	