/**
 * 
 */
package escrim.metiers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * The Class Colis.
 *
 * @author Martin
 */
@Entity
public class Colis {

	/** The uid. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	
	/** The affectation. */
	private String affectation;
	
	/** The optionnel. */
	private boolean optionnel;
	
	/** The secteur. */
	private int secteur;
	
	/** The type colis. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private TypeColis typeColis = new TypeColis();
	
	/** The numero colis. */
	private int numeroColis;
	
	/** The designation. */
	private String designation;
	
	/** The valeur. */
	private float valeur;
	
	/** The iata. */
	private String iata;
	
	/** The projection. */
	private float projection;
	
	/** The observation. */
	private String observation;
	
	/** The liste config du colis. */
	@ManyToMany
	private List<ConfigurationHopital> listeConfigDuColis;

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
	 * Gets the affectation.
	 *
	 * @return the affectation
	 */
	public String getAffectation() {
		return affectation;
	}

	/**
	 * Sets the affectation.
	 *
	 * @param affectation the new affectation
	 */
	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}

	/**
	 * Checks if is optionnel.
	 *
	 * @return true, if is optionnel
	 */
	public boolean isOptionnel() {
		return optionnel;
	}

	/**
	 * Sets the optionnel.
	 *
	 * @param optionnel the new optionnel
	 */
	public void setOptionnel(boolean optionnel) {
		this.optionnel = optionnel;
	}

	/**
	 * Gets the secteur.
	 *
	 * @return the secteur
	 */
	public int getSecteur() {
		return secteur;
	}

	/**
	 * Sets the secteur.
	 *
	 * @param secteur the new secteur
	 */
	public void setSecteur(int secteur) {
		this.secteur = secteur;
	}

	/**
	 * Gets the type colis.
	 *
	 * @return the type colis
	 */
	public TypeColis getTypeColis() {
		return typeColis;
	}

	/**
	 * Sets the type colis.
	 *
	 * @param typeColis the new type colis
	 */
	public void setTypeColis(TypeColis typeColis) {
		this.typeColis = typeColis;
	}

	/**
	 * Gets the numero colis.
	 *
	 * @return the numero colis
	 */
	public int getNumeroColis() {
		return numeroColis;
	}

	/**
	 * Sets the numero colis.
	 *
	 * @param numeroColis the new numero colis
	 */
	public void setNumeroColis(int numeroColis) {
		this.numeroColis = numeroColis;
	}

	/**
	 * Gets the valeur.
	 *
	 * @return the valeur
	 */
	public float getValeur() {
		return valeur;
	}

	/**
	 * Sets the valeur.
	 *
	 * @param valeur the new valeur
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	/**
	 * Gets the iata.
	 *
	 * @return the iata
	 */
	public String getIata() {
		return iata;
	}

	/**
	 * Sets the iata.
	 *
	 * @param iata the new iata
	 */
	public void setIata(String iata) {
		this.iata = iata;
	}

	/**
	 * Gets the projection.
	 *
	 * @return the projection
	 */
	public float getProjection() {
		return projection;
	}

	/**
	 * Sets the projection.
	 *
	 * @param projection the new projection
	 */
	public void setProjection(float projection) {
		this.projection = projection;
	}

	/**
	 * Gets the observation.
	 *
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * Sets the observation.
	 *
	 * @param observation the new observation
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * Gets the liste config du colis.
	 *
	 * @return the liste config du colis
	 */
	public List<ConfigurationHopital> getListeConfigDuColis() {
		return listeConfigDuColis;
	}

	/**
	 * Sets the liste config du colis.
	 *
	 * @param listeConfigDuColis the new liste config du colis
	 */
	public void setListeConfigDuColis(
			List<ConfigurationHopital> listeConfigDuColis) {
		this.listeConfigDuColis = listeConfigDuColis;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
