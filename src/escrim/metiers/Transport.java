package escrim.metiers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The Class Transport.
 */
@Entity
@NamedQuery(name="Transport.loadAll",
query="SELECT t FROM Transport t")
public class Transport {

	/** The uid. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	
	/** The denomination. */
	private String denomination;
	
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

}
