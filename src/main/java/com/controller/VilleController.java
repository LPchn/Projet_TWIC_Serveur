package com.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.modele.Ville;
import com.blo.VilleBlo;
import com.blo.VilleBloImpl;
import com.dao.DaoException;

@RestController
public class VilleController {
	
	/**
	 * Méthode GET
	 * Listener : écoute sur le réseau les URL de la forme "/ville"
	 * Récupère l'ensemble des villes.
	 * @throws DaoException 
	 */	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelGet(@RequestParam(required = false, value="codePostal") String codePostal) throws DaoException {
		
		VilleBlo villeBlo = new VilleBloImpl();
		List<Ville> villes = villeBlo.getInfoVille(codePostal);		
		return(villes);
	}
	
	/**
	 * Methode PUT
	 * Modifie 0, 1 ou plusieurs parametres de la ville du codeCommune indique
	 * @throws DaoException 
	 */

	@RequestMapping(value = "/ville/{codeCommune}", method = RequestMethod.PUT)
	public void appelPut(@PathVariable String codeCommune, 
			@RequestBody(required = false) Ville ville) throws DaoException {
		VilleBlo villeBlo = new VilleBloImpl();
		villeBlo.modifierVille(codeCommune, ville);
	}
	
	/**
	 * Methode DELETE
	 * Supprime la ville correspondant au codeCommune
	 * @throws DaoException 
	 */
	
	@RequestMapping(value = "/ville/{codeCommune}", method = RequestMethod.DELETE)
	public void appelDelete(@PathVariable String codeCommune) throws DaoException {
		VilleBlo villeBlo = new VilleBloImpl();
		villeBlo.supprimerVille(codeCommune);
	}
		
	/**
	 * Méthode POST
	 * Permet d'ajouter une ville.
	 * Récupère le corps de l'URL, qui contient les données à ajouter.
	 * @param ville
	 * @throws DaoException 
	 */
	@RequestMapping(value= "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody(required = false) Ville ville) throws DaoException {
		
		VilleBlo villeBlo = new VilleBloImpl();
		try {
			villeBlo.ajouteVille(ville);
		}
		catch(DaoException e) {
			throw new DaoException("Erreur dans l'ajout d'une ville.");
		}		
	}
}