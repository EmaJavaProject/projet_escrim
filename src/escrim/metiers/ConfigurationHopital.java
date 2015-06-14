package escrim.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ConfigurationHopital implements Metier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String denomination;
	@ManyToMany
	private List<Colis> listeColis;

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

	public List<Colis> getListeColis() {
		return listeColis;
	}

	public void setListeColis(List<Colis> listeColis) {
		this.listeColis = listeColis;
	}

}
