package fr.bouget.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bouget.jpa.model.Croisiere;

/**
 * @author Philippe
 *
 */
public interface CroisiereRepository extends JpaRepository<Croisiere, Integer> {
	
	/* Ici, on ajoute une méthode pour la recherche par la propriété "nom".
	 * Pas besoin d'implémenter quoi que ce soit, le framework s'en charge.
	 * Le simple fait de l'ajouter suffit !
	 */
	public Croisiere findByNom(String nom);

}
