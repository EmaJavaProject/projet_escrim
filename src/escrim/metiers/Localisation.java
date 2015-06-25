package escrim.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Localisation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private int numeroSector;
	private String nomSector;

	@OneToMany(mappedBy = "localisation")
	private List<Colis> listeColis;

	public int getNumeroSector() {
		return numeroSector;
	}

	public void setNumeroSector(int numeroSector) {
		this.numeroSector = numeroSector;
	}

	public List<Colis> getListeColis() {
		return listeColis;
	}

	public void setListeColis(List<Colis> listeColis) {
		this.listeColis = listeColis;
	}

	public String getNomSector() {
		return nomSector;
	}

	public void setNomSector(String nomSector) {
		this.nomSector = nomSector;
	}

}
