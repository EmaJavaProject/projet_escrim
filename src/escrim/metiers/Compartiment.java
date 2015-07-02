package escrim.metiers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The Class Compartiment.
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Compartiment.loadAll", query = "SELECT c FROM Compartiment c"),
		@NamedQuery(name = "Compartiment.findCompartimentIntoTransport", query = "SELECT c FROM Compartiment c where c.transport.uid = :uid"),
		@NamedQuery(name = "Compartiment.findCompartimentOutsideTransport", query = "SELECT c FROM Compartiment c where c.transport is NULL"), })
public class Compartiment {

	/** The uid. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;

	/** The nom. */
	private String nom;

	/** The hauteur. */
	private float hauteur;

	/** The largeur. */
	private float largeur;

	/** The longueur. */
	private float longueur;

	/** The volume. */
	private float volume;

	/** The poids. */
	private float poids;

	/** The transport. */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Transport transport;

	/**
	 * Gets the transport.
	 *
	 * @return the transport
	 */
	public Transport getTransport() {
		return transport;
	}

	/**
	 * Sets the transport.
	 *
	 * @param transport
	 *            the new transport
	 */
	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	/** The liste colis dans compartiment. */
	@OneToMany
	private List<Colis> listeColisDansCompartiment;

	/**
	 * Instantiates a new compartiment.
	 */
	public Compartiment() {

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
	 * @param uid
	 *            the new uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
	 * @param hauteur
	 *            the new hauteur
	 */
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
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
	 * @param largeur
	 *            the new largeur
	 */
	public void setLargeur(float largeur) {
		this.largeur = largeur;
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
	 * @param longueur
	 *            the new longueur
	 */
	public void setLongueur(float longueur) {
		this.longueur = longueur;
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
		this.volume = this.getLongueur() * this.getHauteur()
				* this.getLargeur();
	}

	/**
	 * Gets the poids.
	 *
	 * @return the poids
	 */
	public float getPoids() {
		return poids;
	}

	/**
	 * Sets the poids.
	 *
	 * @param poids
	 *            the new poids
	 */
	public void setPoids(float poids) {
		this.poids = poids;
	}

	/**
	 * Gets the liste colis dans compartiment.
	 *
	 * @return the liste colis dans compartiment
	 */
	public List<Colis> getListeColisDansCompartiment() {
		return listeColisDansCompartiment;
	}

	/**
	 * Sets the liste colis dans compartiment.
	 *
	 * @param colisDansCompartiment
	 *            the new liste colis dans compartiment
	 */
	public void setListeColisDansCompartiment(List<Colis> colisDansCompartiment) {
		listeColisDansCompartiment = colisDansCompartiment;
	}

}
