package escrim.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String denomination;
	private float poidsMax;
	@OneToMany
	private List<Compartiment> listeCompartiments;

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

	public float getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(float poidsMax) {
		this.poidsMax = poidsMax;
	}

}
