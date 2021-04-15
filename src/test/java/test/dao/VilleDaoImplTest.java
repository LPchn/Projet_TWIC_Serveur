package test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dao.DaoException;
import com.dao.DaoFactory;
import com.dao.VilleDao;
import com.modele.Ville;

public class VilleDaoImplTest {

	@Test
	public void testSupprimerVille() throws DaoException {	
		DaoFactory dao = DaoFactory.getInstance();
		VilleDao villeDao = dao.getUtilisateurDao();
		List<Ville> villesAvantSupression = villeDao.getVille();
		int indiceAleatoire = (int) Math.round(Math.random()*villesAvantSupression.size());
		String codeASupprimer = villesAvantSupression.get(indiceAleatoire).getCode();
		System.out.println(codeASupprimer);
		villeDao.supprimerVille(codeASupprimer);                   //On supprime une ville
		List<Ville> villes = villeDao.getVille();           //On recupere la nouvelle liste de villes
		boolean villePresente = false;
		for(int i = 0; i<villes.size(); i++) {
			if (villes.get(i).getCode().equals(codeASupprimer)) {
				villePresente = true;
			}
		}
		Assert.assertFalse(villePresente);		
	}

}
