package escrim.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Localisation {
	
	@Id
	private int numeroSector;
	
	@OneToMany(mappedBy="localisation")
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
	

}
