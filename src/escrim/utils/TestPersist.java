package escrim.utils;

import java.util.List;

import escrim.metiers.Localisation;
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

		GestionPersistance.addObjetToDB(local1);

		GestionPersistance.addObjetToDB(local2);

		GestionPersistance.addObjetToDB(local3);

		List<Metier> listeTest = GestionPersistance
				.getAllObjectFromDB("Localisation");
		for (Metier metier : listeTest) {
			System.out.println(((Localisation) metier).getNumeroSector());
		}

	}
}
