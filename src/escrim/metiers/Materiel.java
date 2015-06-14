package escrim.metiers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Martin Usé
 * @brief classe de gestion du Materiel
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Materiel implements Metier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// uid pour unique ID :)
	private int uid;
	private String denomination;
	@ManyToOne
	private Colis colis;
	private String observations;
	private int quantite;

	public Materiel() {

	}

	Materiel(int id, String denomation, Colis colis, String observations,
			int quantite) {
		this.uid = id;
		this.denomination = denomation;
		this.colis = colis;
		this.observations = observations;
		this.quantite = quantite;

	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public int getId() {
		return uid;
	}

	public void setId(int id) {
		this.uid = id;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
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
