package escrim.manager;

import java.util.Date;
import java.util.List;

import escrim.dao.MedicamentDao;
import escrim.metiers.Medicament;

public class MedicamentManager {

	public void createMedicaments(String denomination, String principeActif, String dosage, Date dLU,int quantite, String lot, String classeThera, int dotationU7) {
		Medicament medicament = new Medicament();
		medicament.setClasseThera(classeThera);
		medicament.setDlu(dLU);
		medicament.setDosage(dosage);
		medicament.setDotationU7(dotationU7);
		medicament.setQuantite(quantite);
		medicament.setDenomination(denomination);
		medicament.setLot(lot);
		medicament.setPrincipeActif(principeActif);
		MedicamentDao.create(medicament);
	}

	public void updateMedicaments(int uid, String denomination, String principeActif, String dosage, Date dLU,int quantite, String lot, String classeThera, int dotationU7) {
		Medicament medicament = loadMedicament(uid);
		medicament.setClasseThera(classeThera);
		medicament.setDlu(dLU);
		medicament.setDosage(dosage);
		medicament.setDotationU7(dotationU7);
		medicament.setQuantite(quantite);
		medicament.setDenomination(denomination);
		medicament.setLot(lot);
		medicament.setPrincipeActif(principeActif);
		MedicamentDao.update(medicament, uid);
	}

	public void deleteMedicaments(int uid) {
		Medicament deleteMedicaments = loadMedicament(uid);
		MedicamentDao.remove(deleteMedicaments);
	}

	public static Medicament loadMedicament(int uid) {
		return MedicamentDao.load(uid);
	}
	
	public static List<Medicament> loadAllMedicaments() {
		return MedicamentDao.loadAll();
	}
}
