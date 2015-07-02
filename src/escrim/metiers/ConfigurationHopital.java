package escrim.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The Class ConfigurationHopital.
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "ConfigurationHopital.loadDistinctConfig", query = "SELECT DISTINCT conf.denomination FROM ConfigurationHopital conf"),
		@NamedQuery(name = "ConfigurationHopital.loadAll", query = "SELECT c FROM ConfigurationHopital c") })
public class ConfigurationHopital {

	/** The uid. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;

	/** The denomination. */
	private String denomination;

	/** The liste colis. */
	@ManyToMany(mappedBy = "configurations")
	private List<Colis> colis;

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
	 * @param uid
	 *            the new uid
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
	 * @param denomination
	 *            the new denomination
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	/**
	 * Gets the liste colis.
	 *
	 * @return the liste colis
	 */
	public List<Colis> getListeColis() {
		return colis;
	}

	/**
	 * Sets the liste colis.
	 *
	 * @param listeColis
	 *            the new liste colis
	 */
	public void setListeColis(List<Colis> listeColis) {
		this.colis = listeColis;
	}

	/**
	 * Adds the colis.
	 *
	 * @param pColis the colis
	 */
	public void addColis(Colis pColis) {
		colis.add(pColis);
	}

	/**
	 * Removes the colis.
	 *
	 * @param pColis the colis
	 */
	public void removeColis(Colis pColis) {
		colis.remove(pColis);
	}
}
