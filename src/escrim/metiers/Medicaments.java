/**
 * 
 */
package escrim.metiers;

import javax.persistence.Entity;

/**
 * @author Martin
 *
 */
@Entity
public class Medicaments extends Materiel {
	
	private String principeActif;
	private String dosage;
	private String dlu;
	private String lot;
	//Classe th�rapeuthique
	private String classeThera;
	private int dotationU7;
	

	public String getPrincipeActif() {
		return principeActif;
	}

	public void setPrincipeActif(String principeActif) {
		this.principeActif = principeActif;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDlu() {
		return dlu;
	}

	public void setDlu(String dlu) {
		this.dlu = dlu;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getClasseThera() {
		return classeThera;
	}

	public void setClasseThera(String classeThera) {
		this.classeThera = classeThera;
	}

	public int getDotationU7() {
		return dotationU7;
	}

	public void setDotationU7(int dotationU7) {
		this.dotationU7 = dotationU7;
	}

	public Medicaments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicaments(int id, String denomation, Colis colis,
			String observations, int quantite) {
		super(id, denomation, colis, observations, quantite);
		// TODO Auto-generated constructor stub
	}
	
	

}