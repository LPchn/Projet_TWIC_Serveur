package com.dao;

import java.util.List;
import com.modele.Ville;

public interface VilleDao {
	List<Ville> getVille() throws DaoException;
	Ville getVilleByCodePostal(String codePostal) throws DaoException;
	void supprimerVille(String codeCommune) throws DaoException;
	void ajouterVille(Ville ville) throws DaoException;
	void modifierVille(String codeCommune, Ville ville) throws DaoException;
}