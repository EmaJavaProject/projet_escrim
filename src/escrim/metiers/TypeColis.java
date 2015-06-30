/**
 * 
 */
package escrim.metiers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class TypeColis.
 *
 * @author Martin
 */

@Table
@Entity
@NamedQueries({
	@NamedQuery(name="TypeColis.loadAll",
				query="SELECT t FROM TypeColis t"),
	@NamedQuery(name="TypeColis.findByName",
				query="SELECT t FROM TypeColis t where t.designation= \':type\'")
})
public class TypeColis {

	/** The uid. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	
	/** The designation. */
	private String designation;
	
	/** The hauteur. */
	private float hauteur;
	
	/** The longueur. */
	private float longueur;
	
	/** The largeur. */
	private float largeur;
	
	/** The volume. */
	private float volume;
	
	/** The poids max. */
	private float poidsMax;

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
	 * Gets the hauteur.
	 *
	 * @return the hauteur
	 */
	public float getHauteur() {
		return hauteur;
	}

	/**
	 * Sets the hauteur.
	 *
	 * @param hauteur the new hauteur
	 */
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * Gets the longueur.
	 *
	 * @return the longueur
	 */
	public float getLongueur() {
		return longueur;
	}

	/**
	 * Sets the longueur.
	 *
	 * @param longueur the new longueur
	 */
	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	/**
	 * Gets the largeur.
	 *
	 * @return the largeur
	 */
	public float getLargeur() {
		return largeur;
	}

	/**
	 * Sets the largeur.
	 *
	 * @param largeur the new largeur
	 */
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	public float getVolume() {
		return volume;
	}

	/**
	 * Sets the volume.
	 */
	public void setVolume() {
		this.volume = getLargeur() * getLongueur() * getHauteur();
	}

	/**
	 * Gets the poids max.
	 *
	 * @return the poids max
	 */
	public float getPoidsMax() {
		return poidsMax;
	}

	/**
	 * Sets the poids max.
	 *
	 * @param poidsMax the new poids max
	 */
	public void setPoidsMax(float poidsMax) {
		this.poidsMax = poidsMax;
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
