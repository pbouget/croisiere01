package fr.bouget.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author philippe
 * Dans cette classe Entity, les annotations sont
 * toutes mises sur les méthodes getXXXX().
 *
 */
@Entity
public class Croisiere implements Serializable {
	
	public static final long serialVersionUID=987654378L;

	private int id;
	private String nom;
	private int duree;
	private Paquebot paquebot;

/**
 * Constructeur sans argument
 */
	public Croisiere(){
		this(null, 0);
	}

	/**
	 * Constructeur avec 2 arguments
	 * @param nom
	 * @param duree
	 */
	public Croisiere(String nom, int duree)
	{
		this(nom, duree, null);
	}

	/**
	 * Constructeur avec 3 arguments
	 * @param nom
	 * @param duree
	 * @param paquebot
	 */
	public Croisiere(String nom, int duree, Paquebot paquebot){
		this.nom=nom;
		this.duree=duree;
		this.paquebot=paquebot;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Column(length = 45)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// Many Croisières To One Paquebot
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PAQUEBOT_ID")
	public Paquebot getPaquebot() {
		return paquebot;
	}

	public void setPaquebot(Paquebot paquebot) {
		this.paquebot = paquebot;
	}


	@Override
	public String toString(){
		return "Croisière : "+id+" "+nom+" "+duree+" (jours) - "+paquebot;
	}
}
