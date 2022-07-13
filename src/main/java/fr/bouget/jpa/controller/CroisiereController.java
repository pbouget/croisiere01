package fr.bouget.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.jpa.model.Croisiere;
import fr.bouget.jpa.model.Paquebot;
import fr.bouget.jpa.repository.CroisiereRepository;
import fr.bouget.jpa.repository.PaquebotRepository;



/**
 * @author Philippe
 *
 */
@RestController
@CrossOrigin("*")
public class CroisiereController {

	@Autowired
	private CroisiereRepository croisiereRepo;

	@Autowired
	private PaquebotRepository paquebotRepo;


	@GetMapping("/accueil")
	@ResponseBody
	public String home()
	{
		init();
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Regardez dans votre base de données MySQL <strong>JPA</strong></h1>");
		sb.append("<p>Vous devez avoir 2 tables dans votre base de données :</p>");
		sb.append("<ul><li><a href='http://localhost:8080/croisieres'>Liste des croisières enregistrées</a></li>");
		sb.append("<li><a href='http://localhost:8080/paquebots'>Liste des paquebots enregistrés</a></li></ul>");
		return  sb.toString();
	}

	@GetMapping(value = "/croisieres")
	public ResponseEntity<?> getAllCroisieres(){
		List<Croisiere> liste = null;
		try
		{
			liste = croisiereRepo.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	@GetMapping(value = "/paquebots")
	public ResponseEntity<?> getAllPaquebots(){
		List<Paquebot> liste = null;
		try
		{
			liste = paquebotRepo.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	/**
	 * Méthode d'initialisation (démo)
	 */
	private void init()
	{
		Paquebot p1 = new Paquebot("Queen Mary III", 50000);
		p1 = paquebotRepo.save(p1);

		Paquebot p2 = new Paquebot("Goeland ", 25000);
		p2 = paquebotRepo.save(p2);

		Croisiere c1 = new Croisiere("Mer Egée", 15);
		Croisiere c2 = new Croisiere("Mer Caspienne", 7);
		Croisiere c3 = new Croisiere("Adriatique", 8);
		c1.setPaquebot(p1);
		c2.setPaquebot(p1);
		c3.setPaquebot(p2);

		croisiereRepo.save(c1);
		croisiereRepo.save(c2);
		croisiereRepo.save(c3);

		//Modification de la durée (moins 2 jours) de la croisière Adriatique
		Croisiere croisiere = croisiereRepo.findByNom("Adriatique");
		if (croisiere != null) {
			croisiere.setDuree(croisiere.getDuree() - 2);
			croisiereRepo.saveAndFlush(croisiere);
		}

	}

}



