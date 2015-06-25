package escrim.model.table;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import escrim.manager.MedicamentManager;
import escrim.metiers.Medicament;

@SuppressWarnings("serial")
public class MedicamentTableModel extends EscrimTableModel {
	private List<Medicament> listeMedicament = MedicamentManager
			.loadAllMedicament();
	private String[] MedicamentColumnName = { "", "Dénomination",
			"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
			"Classe Thérapeutique", "Dotation U7", "uid" };
	DateFormat formatter = new SimpleDateFormat("dd/mm/yy");

	public MedicamentTableModel() {
		listeMedicament = MedicamentManager.loadAllMedicament();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return MedicamentColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeMedicament != null) {
			return listeMedicament.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 10;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Medicament Medicament = listeMedicament.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return Medicament.getDenomination();
		case 2:
			return Medicament.getPrincipeActif();
		case 3:
			return Medicament.getDosage();
		case 4:
			return Medicament.getDlu();
		case 5:
			return Medicament.getQuantite();
		case 6:
			return Medicament.getLot();
		case 7:
			return Medicament.getClasseThera();
		case 8:
			return Medicament.getDotationU7();
		case 9:
			return Medicament.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeMedicament.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			listeMedicament.get(rowIndex).setPrincipeActif(
					aValue == null ? null : aValue.toString());
			break;
		case 3:
			listeMedicament.get(rowIndex).setDosage(
					aValue == null ? null : aValue.toString());
			break;
		case 4:
			try {
				listeMedicament.get(rowIndex).setDlu(
						aValue == null ? new Date() : formatter.parse(aValue
								.toString()));
			} catch (ParseException e) {
				// Ici faut renvoyer un msg d'erreur
			}
			break;
		case 5:
			listeMedicament.get(rowIndex).setQuantite(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		case 6:
			listeMedicament.get(rowIndex).setLot(
					aValue == null ? null : aValue.toString());
			break;
		case 7:
			listeMedicament.get(rowIndex).setClasseThera(
					aValue == null ? null : aValue.toString());
			break;
		case 8:
			listeMedicament.get(rowIndex).setDotationU7(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		default:
			break;
		}
	}

	public void validatePersistance(int rowIndex) {
		MedicamentManager.createMedicament(listeMedicament.get(rowIndex));
	}

	public void refreshModel() {
		listeMedicament = MedicamentManager.loadAllMedicament();
		fireTableDataChanged();
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
			return String.class;
		case 5:
			return String.class;
		case 6:
			return Integer.class;

		}
		return null;
	}

	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeMedicament.add(getRowCount(),
				MedicamentManager.createTempMedicament());
		fireTableRowsInserted(0, getRowCount());
	}

	public void removeElement(int rowIndex) {
		super.setRemove(true);
		super.setAddition(false);
		super.setEdition(false);
		persistData(rowIndex, true);
	}

	public void persistData(int rowIndex, boolean validate) {
		if (validate) {
			if (super.isAddition() && !super.isEdition() && !super.isRemove()) {
				MedicamentManager.createMedicament(listeMedicament
						.get(rowIndex));
				super.setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				MedicamentManager.updateMedicament(
						listeMedicament.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount() - 1));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				MedicamentManager.removeMedicament((Integer) getValueAt(
						rowIndex, getColumnCount() - 1));
				super.setRemove(false);
			}
		}

		refreshModel();

	}

	public void updateElement(int rowIndex) {
		super.setEditedRow(rowIndex);
		super.setEdition(true);
		super.setAddition(false);
		super.setRemove(false);
	}
}
