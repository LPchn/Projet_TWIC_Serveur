package com.blo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.DaoException;
import com.modele.Ville;

@Service
public interface VilleBlo {	
	List<Ville> getInfoVille(String parametre) throws DaoException;
	void modifierVille(String codeCommune, Ville ville) throws DaoException;
	void supprimerVille(String codeCommune) throws DaoException;
	void ajouteVille(Ville ville) throws DaoException;

}