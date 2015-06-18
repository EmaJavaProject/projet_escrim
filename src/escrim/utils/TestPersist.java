package escrim.utils;

import java.util.List;

import escrim.manager.GestionPersistance;
import escrim.metiers.Localisation;
import escrim.metiers.Materiel;
import escrim.metiers.Medicament;
import escrim.metiers.Metier;

public class TestPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Localisation local1 = new Localisation();
		local1.setNumeroSector(1);
		Localisation local2 = new Localisation();
		local2.setNumeroSector(2);
		Localisation local3 = new Localisation();
		local3.setNumeroSector(3);
		
		Materiel mat = new Materiel();
		mat.setObservations("test1");
		
		Medicament medic = new Medicament();
		medic.setPrincipeActif("test 2");

		GestionPersistance.addObjetToDB(local1);

		GestionPersistance.addObjetToDB(local2);

		GestionPersistance.addObjetToDB(local3);
		
		GestionPersistance.addObjetToDB(mat);
		GestionPersistance.addObjetToDB(medic);
		
		List<Metier> listeTest = GestionPersistance
				.getAllObjectFromDB("Localisation");
		for (Metier metier : listeTest) {
			System.out.println(((Localisation) metier).getNumeroSector());
		}
		
		Localisation local4 = (Localisation)GestionPersistance.getOneObjectFromDB("Localisation", 1);
		System.out.println(((Localisation) local4).getNumeroSector());
	}
}
