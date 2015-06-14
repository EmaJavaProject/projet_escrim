package escrim.utils;

import escrim.metiers.Localisation;

public class TestPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Localisation local = new Localisation();
		local.setNumeroSector(1);

		GestionPersistance.addObjetToDB(local);
		System.out.println(local.getClass().toString());

		local = (Localisation) GestionPersistance.getOneObjectFromDB(
				"Localisation", 1);
		System.out.println(local.getNumeroSector());

	}

}
