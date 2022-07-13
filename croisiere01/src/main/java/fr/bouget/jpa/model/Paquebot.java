package fr.bouget.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paquebot implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private double tonnage;

	public Paquebot(){
		this(null,0.0);
	}

	public Paquebot(String nom, double tonnage){
		this.nom=nom;
		this.tonnage=tonnage;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length = 35)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getTonnage() {
		return tonnage;
	}

	public void setTonnage(double tonnage) {
		this.tonnage = tonnage;
	}

	@Override
	public String toString(){
		return "Paquebot : "+id+" "+nom+" "+tonnage;
	}
}
