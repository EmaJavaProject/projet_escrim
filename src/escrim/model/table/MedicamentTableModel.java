package escrim.model.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import escrim.manager.MedicamentManager;
import escrim.metiers.Medicament;

/**
 * The Class MedicamentTableModel.
 */
@SuppressWarnings("serial")
public class MedicamentTableModel extends EscrimTableModel {

	/** The liste medicament. */
	private List<Medicament> listeMedicament = MedicamentManager
			.loadAllMedicament();

	/** The Medicament column name. */
	private String[] MedicamentColumnName = { "", "Dénomination",
			"Principe Actif", "Dosage", "DLU", "Quantité", "Lot",
			"Classe Thérapeutique", "Dotation U7" };

	/** The formatter. */
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	/**
	 * Instantiates a new medicament table model.
	 */
	public MedicamentTableModel() {
		listeMedicament = MedicamentManager.loadAllMedicament();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return MedicamentColumnName[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeMedicament != null) {
			return listeMedicament.size();
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 9;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
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
			try {
				return formatter.format(Medicament.getDlu());
			} catch (Exception e) {
				return Medicament.getDlu();
			}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
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

	/**
	 * Validate persistance.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void validatePersistance(int rowIndex) {
		MedicamentManager.createMedicament(listeMedicament.get(rowIndex));
	}

	/**
	 * Refresh model.
	 */
	public void refreshModel() {
		listeMedicament = MedicamentManager.loadAllMedicament();
		fireTableDataChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
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
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return Integer.class;

		}
		return null;
	}

	/**
	 * Adds the element.
	 */
	public void addElement() {
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeMedicament.add(getRowCount(),
				MedicamentManager.createTempMedicament());
		fireTableRowsInserted(0, getRowCount());
	}

	/**
	 * Removes the element.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void removeElement(int rowIndex) {
		super.setRemove(true);
		super.setAddition(false);
		super.setEdition(false);
		persistData(rowIndex, true);
	}

	/**
	 * Persist data.
	 *
	 * @param rowIndex
	 *            the row index
	 * @param validate
	 *            the validate
	 */
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
						(Integer) getValueAt(rowIndex, getColumnCount()));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				MedicamentManager.removeMedicament((Integer) getValueAt(
						rowIndex, getColumnCount()));
				super.setRemove(false);
			}
		}

		refreshModel();

	}

	/**
	 * Update element.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void updateElement(int rowIndex) {
		super.setEditedRow(rowIndex);
		super.setEdition(true);
		super.setAddition(false);
		super.setRemove(false);
	}
}
