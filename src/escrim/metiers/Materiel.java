package escrim.metiers;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * 
 * @author Martin Usé
 * @brief classe de gestion du Materiel
 */

@Entity
public class Materiel {
	
	@Id
	private int id;
	private String denomination;
	private int conteneur;
	private String observations;
	private int quantite;
	
	
	Materiel() {
		
	}
	
	Materiel(int id, String denomation, int conteneur, String observations, int quantite) {
		this.id = id;
		this.denomination = denomation;
		this.conteneur = conteneur;
		this.observations = observations;
		this.quantite = quantite;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public int getConteneur() {
		return conteneur;
	}
	public void setConteneur(int conteneur) {
		this.conteneur = conteneur;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
