package escrim.metiers;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@DiscriminatorColumn(name = "DTYPE")
public class Materiel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// uid pour unique ID :)
	private int uid;
	private String denomination;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Colis colis;
	private String observations;
	@Column(name = "Dtype")
	private String type;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
