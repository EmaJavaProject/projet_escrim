package ihm;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import escrim.manager.MedicamentManager;
import escrim.metiers.Medicament;

public class MedicamentTableModel extends EscrimTableModel {
	private List<Medicament> listeMedicament = new ArrayList();
	public String[] medicColName = { "", "Dénomination",
		"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
		"Classe Thérapeutique", "Dotation U7", "uid" };

	public MedicamentTableModel() {
		listeMedicament = MedicamentManager.loadAllMedicaments();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return medicColName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeMedicament != null) {
			return listeMedicament.size();
		} else
			return 0;
	}

	@Override
	public int getColumnCount() {
		return 10;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Medicament medicament = listeMedicament.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return medicament.getDenomination();
		case 2:
			return medicament.getPrincipeActif();
		case 3:
			return medicament.getDosage();
		case 4:
			return medicament.getDlu();
		case 5:
			return medicament.getQuantite();
		case 6:
			return medicament.getLot();
		case 7:
			return medicament.getClasseThera();
		case 8:
			return medicament.getDotationU7();
		case 9:
			return medicament.getId();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return Date.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return Integer.class;
		case 9:
			return Integer.class;
		}
		return null;
	}

	public void addRow() {
		listeMedicament.add(0, null);
		fireTableDataChanged();
	}
}
