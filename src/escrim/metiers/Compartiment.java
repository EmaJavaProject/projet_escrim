package escrim.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compartiment implements Metier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private float hauteur;
	private float largeur;
	private float longueur;
	private float volume;
	private float poids;
	@OneToMany
	private List<Colis> ColisDansCompartiement;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public float getHauteur() {
		return hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public List<Colis> getColisDansCompartiement() {
		return ColisDansCompartiement;
	}

	public void setColisDansCompartiement(List<Colis> colisDansCompartiement) {
		ColisDansCompartiement = colisDansCompartiement;
	}
}
