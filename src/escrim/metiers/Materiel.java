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
 * The Class Materiel.
 *
 * @author Martin Usé
 * @brief classe de gestion du Materiel
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public class Materiel {

	/** The uid. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// uid pour unique ID :)
	private int uid;
	
	/** The denomination. */
	private String denomination;
	
	/** The colis. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Colis colis;
	
	/** The observations. */
	private String observations;
	
	/** The type. */
	@Column(name = "Dtype")
	private String type;
	
	/** The quantite. */
	private int quantite;

	/**
	 * Instantiates a new materiel.
	 */
	public Materiel() {

	}

	/**
	 * Instantiates a new materiel.
	 *
	 * @param id the id
	 * @param denomation the denomation
	 * @param colis the colis
	 * @param observations the observations
	 * @param quantite the quantite
	 */
	Materiel(int id, String denomation, Colis colis, String observations,
			int quantite) {
		this.uid = id;
		this.denomination = denomation;
		this.colis = colis;
		this.observations = observations;
		this.quantite = quantite;

	}

	/**
	 * Gets the colis.
	 *
	 * @return the colis
	 */
	public Colis getColis() {
		return colis;
	}

	/**
	 * Sets the colis.
	 *
	 * @param colis the new colis
	 */
	public void setColis(Colis colis) {
		this.colis = colis;
	}

	/**
	 * Gets the uid.
	 *
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * Sets the uid.
	 *
	 * @param uid the new uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * Gets the denomination.
	 *
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * Sets the denomination.
	 *
	 * @param denomination the new denomination
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	/**
	 * Gets the observations.
	 *
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 * Sets the observations.
	 *
	 * @param observations the new observations
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the quantite.
	 *
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * Sets the quantite.
	 *
	 * @param quantite the new quantite
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
