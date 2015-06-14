/**
 * 
 */
package escrim.metiers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Martin
 *
 */
@Entity
public class TypeColis implements Metier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private float hauteur;
	private float longueur;
	private float largeur;
	private float volume;
	private float poidsMax;

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

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(float poidsMax) {
		this.poidsMax = poidsMax;
	}

}
