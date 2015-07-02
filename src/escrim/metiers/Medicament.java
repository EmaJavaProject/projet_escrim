/**
 * 
 */
package escrim.metiers;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Medicament.
 *
 * @author Martin
 */
@Entity
@NamedQuery(name = "Medicament.loadAll", query = "SELECT m FROM Medicament m where m.type = :type")
public class Medicament extends Materiel {

	/** The principe actif. */
	private String principeActif;

	/** The dosage. */
	private String dosage;

	/** The dlu. */
	@Temporal(TemporalType.DATE)
	private java.util.Date dlu;

	/** The lot. */
	private String lot;

	/** The classe thera. */
	// Classe thérapeuthique
	private String classeThera;

	/** The dotation u7. */
	private int dotationU7;

	/**
	 * Gets the principe actif.
	 *
	 * @return the principe actif
	 */
	public String getPrincipeActif() {
		return principeActif;
	}

	/**
	 * Sets the principe actif.
	 *
	 * @param principeActif
	 *            the new principe actif
	 */
	public void setPrincipeActif(String principeActif) {
		this.principeActif = principeActif;
	}

	/**
	 * Gets the dosage.
	 *
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * Sets the dosage.
	 *
	 * @param dosage
	 *            the new dosage
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * Gets the dlu.
	 *
	 * @return the dlu
	 */
	public Date getDlu() {
		return dlu;
	}

	/**
	 * Sets the dlu.
	 *
	 * @param dlu
	 *            the new dlu
	 */
	public void setDlu(Date dlu) {
		this.dlu = dlu;
	}

	/**
	 * Gets the lot.
	 *
	 * @return the lot
	 */
	public String getLot() {
		return lot;
	}

	/**
	 * Sets the lot.
	 *
	 * @param lot
	 *            the new lot
	 */
	public void setLot(String lot) {
		this.lot = lot;
	}

	/**
	 * Gets the classe thera.
	 *
	 * @return the classe thera
	 */
	public String getClasseThera() {
		return classeThera;
	}

	/**
	 * Sets the classe thera.
	 *
	 * @param classeThera
	 *            the new classe thera
	 */
	public void setClasseThera(String classeThera) {
		this.classeThera = classeThera;
	}

	/**
	 * Gets the dotation u7.
	 *
	 * @return the dotation u7
	 */
	public int getDotationU7() {
		return dotationU7;
	}

	/**
	 * Sets the dotation u7.
	 *
	 * @param dotationU7
	 *            the new dotation u7
	 */
	public void setDotationU7(int dotationU7) {
		this.dotationU7 = dotationU7;
	}

	/**
	 * Instantiates a new medicament.
	 */
	public Medicament() {
		super();
	}

	/**
	 * Instantiates a new medicament.
	 *
	 * @param id
	 *            the id
	 * @param denomation
	 *            the denomation
	 * @param colis
	 *            the colis
	 * @param observations
	 *            the observations
	 * @param quantite
	 *            the quantite
	 */
	public Medicament(int id, String denomation, Colis colis,
			String observations, int quantite) {
		super(id, denomation, colis, observations, quantite);
	}

}
