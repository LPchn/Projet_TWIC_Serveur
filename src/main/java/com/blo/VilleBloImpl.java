package com.blo;

import java.util.ArrayList;
import java.util.List;

import com.dao.DaoException;
import com.dao.DaoFactory;
import com.dao.VilleDao;
import com.modele.Ville;

public class VilleBloImpl implements VilleBlo {
	
	private DaoFactory daoFactory = DaoFactory.getInstance();
	private VilleDao villeDao = daoFactory.getUtilisateurDao();
	
	public List<Ville> getInfoVille(String parametre) throws DaoException {
		
		List<Ville> villes = new ArrayList<Ville>();
				
		if(parametre == null) {
			villes = villeDao.getVille();
		}
		else {
			Ville ville = villeDao.getVilleByCodePostal(parametre);
			villes.add(ville);
		}		
		return(villes);		
	}
	
	public void modifierVille(String codeCommune, Ville ville) throws DaoException {
		villeDao.modifierVille(codeCommune, ville);
	}
	
	public void supprimerVille(String codeCommune) throws DaoException {
		villeDao.supprimerVille(codeCommune);
	}

	public void ajouteVille(Ville ville) throws DaoException {		
		try {
			villeDao.ajouterVille(ville);
		} 
		catch (DaoException e) {
			throw new DaoException("Erreur dans l'ajout d'une ville.");
		}
	}
}