package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.modele.Ville;

//@Repository
public class VilleDaoImpl implements VilleDao {

	// Attribut

	private DaoFactory daoFactory;

	// Constructeur

	public VilleDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Méthode

	public List<Ville> getVille() throws DaoException {

		List<Ville> villes = new ArrayList<>();

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = this.daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM ville_france ORDER BY Nom_commune ASC");
			try {
				resultat = statement.executeQuery();
				try {
					while (resultat.next()) {
						String code = resultat.getString("Code_commune_INSEE");
						String nom = resultat.getString("Nom_commune");
						String codePostal = resultat.getString("Code_postal");
						String libelle = resultat.getString("Libelle_acheminement");
						String ligne = resultat.getString("Ligne_5");
						String latitude = resultat.getString("Latitude");
						String longitude = resultat.getString("Longitude");

						Ville ville = new Ville(code, nom, codePostal, libelle, ligne, latitude, longitude);
						villes.add(ville);
					}
				
				}finally {
					resultat.close();
				}
			}finally {
				statement.close();
			}	
		} catch (SQLException e) {
			throw new DaoException(DaoException.ERREUR);
		}finally {
			closeConnexion(connexion);
		}
		return (villes);
	}

	public Ville getVilleByCodePostal(String codePostal) throws DaoException {

		Ville ville = null;

		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = this.daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM ville_france WHERE Code_postal = ?");
			try {
				statement.setString(1, codePostal);
				resultat = statement.executeQuery();
				try {
					while (resultat.next()) {
						String code = resultat.getString("Code_commune_INSEE");
						String nom = resultat.getString("Nom_commune");
						String codPostal = resultat.getString("Code_postal");
						String libelle = resultat.getString("Libelle_acheminement");
						String ligne = resultat.getString("Ligne_5");
						String latitude = resultat.getString("Latitude");
						String longitude = resultat.getString("Longitude");

						ville = new Ville(code, nom, codPostal, libelle, ligne, latitude, longitude);
					}
				} finally {
					resultat.close();
				}
			} finally {
				statement.close();
			}
		} catch (SQLException e) {
			throw new DaoException(DaoException.ERREUR);		
		}finally {
			closeConnexion(connexion);
		}
		return(ville);
    }
    

	/**
	 * Permet d'ajouter une ville dans la base de données
	 * Récupère les informations fournies par l'utilisateur dans le corps de l'URL
	 * @throws DaoException 
	 */
	public void ajouterVille(Ville ville) throws DaoException {

		Connection connexion = null;
		PreparedStatement statement = null;	

		String code = ville.getCode();
		String nom = ville.getNom();
		String codePostal = ville.getCodePostal();
		String libelle = ville.getLibelle();
		String ligne = ville.getLigne();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();

		if(code!=null && nom!=null && codePostal!=null && libelle!=null && ligne!=null && latitude!=null && longitude!=null) {
			try {
				connexion = this.daoFactory.getConnection();
				statement = connexion.prepareStatement("INSERT INTO ville_france VALUES (?,?,?,?,?,?,?);");
				try {
					statement.setString(1, code);
					statement.setString(2, nom);
					statement.setString(3, codePostal);
					statement.setString(4, libelle);
					statement.setString(5, ligne);
					statement.setString(6, latitude);
					statement.setString(7, longitude);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}		
			catch(SQLException e) {
				throw new DaoException(DaoException.ERREUR);							
			}finally {
				closeConnexion(connexion);
			}
		}	
    }
    
   public void modifierVille(String codeCommune, Ville ville) throws DaoException {
    
    	Connection connexion = null;
		PreparedStatement statement = null;
		
		String nomCommune = ville.getNom();
		String codePostal = ville.getCodePostal();
		String libelle = ville.getLibelle();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();
		String ligne5 = ville.getLigne();
		
		try {
			connexion = this.daoFactory.getConnection();
			
			if(nomCommune != null) {
				statement = connexion.prepareStatement("UPDATE ville_france SET Nom_commune = (?)"						
						+ " WHERE code_commune_INSEE = (?)");	
				try {
					statement.setString(1, nomCommune);
					statement.setString(2, codeCommune);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}
			if(codePostal != null) {
				statement = connexion.prepareStatement("UPDATE ville_france SET Code_postal = (?)"						
						+ " WHERE code_commune_INSEE = (?)");				
				try {
					statement.setString(1, codePostal);
					statement.setString(2, codeCommune);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}
			if(libelle != null) {
				statement = connexion.prepareStatement("UPDATE ville_france SET Libelle_acheminement = (?)"						
						+ " WHERE code_commune_INSEE = (?)");
				try {
					statement.setString(1, libelle);
					statement.setString(2, codeCommune);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}
			if(ligne5 != null) {
				statement = connexion.prepareStatement("UPDATE ville_france SET Ligne_5 = (?)"						
						+ " WHERE code_commune_INSEE = (?)");				
				try {
					statement.setString(1, ligne5);
					statement.setString(2, codeCommune);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}
			if(latitude != null) {
				statement = connexion.prepareStatement("UPDATE ville_france SET Latitude = (?)"						
						+ " WHERE code_commune_INSEE = (?)");				
				try {
					statement.setString(1, latitude);
					statement.setString(2, codeCommune);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}
			if(longitude != null) {
				statement = connexion.prepareStatement("UPDATE ville_france SET Longitude = (?)"						
						+ " WHERE code_commune_INSEE = (?)");				
				try {
					statement.setString(1, longitude);
					statement.setString(2, codeCommune);
					statement.executeUpdate();
				}finally {
					statement.close();
				}
			}	
		}
		catch(SQLException e) {
			throw new DaoException(DaoException.ERREUR);
		}finally {
			closeConnexion(connexion);
		}		
	}    
    
    /*
     * Supprime la ville avec le code commune Insee "codeCommune" 
     */
    
	public void supprimerVille(String codeCommune) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;		
			
		try {
			connexion = this.daoFactory.getConnection();
			statement = connexion.prepareStatement("DELETE FROM ville_france WHERE code_commune_INSEE = (?)");				
			try {
				statement.setString(1, codeCommune);
				statement.executeUpdate();
			}finally {
				statement.close();
			}
			
		}catch(SQLException e) {
			throw new DaoException(DaoException.ERREUR);
		}finally {
			closeConnexion(connexion);
		}
						
    }
	
	private void closeConnexion(Connection connexion) {
		try {
			if(connexion != null) {
				connexion.close();
			}
		}
		catch(SQLException e) {
		}
	}
}