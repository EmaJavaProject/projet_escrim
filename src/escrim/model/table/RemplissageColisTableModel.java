package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.MaterielManager;
import escrim.manager.MedicamentManager;
import escrim.metiers.Materiel;
import escrim.metiers.Medicament;

/**
 * The Class RemplissageColisTableModel.
 */
@SuppressWarnings("serial")
public class RemplissageColisTableModel extends EscrimTableModel {
	
	/** The liste materiel. */
	private List<Materiel> listeMateriel = new ArrayList<Materiel>();
	
	/** The Materiel column name. */
	private String[] MaterielColumnName = { "Type", "Denomination",
			"Observations", "Quantite", "uid" };
	
	/** The uid colis to manage. */
	private int uidColisToManage;

	/**
	 * Instantiates a new remplissage colis table model.
	 *
	 * @param allMateriel the all materiel
	 * @param uidColis the uid colis
	 */
	public RemplissageColisTableModel(boolean allMateriel, int uidColis) {
		uidColisToManage = uidColis;
		if (allMateriel) {
			listeMateriel = MaterielManager.loadOutsideColis(uidColisToManage);
		} else {
			listeMateriel = MaterielManager.loadByColis(uidColisToManage);
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return 5;
	}

	/**
	 * Refresh model.
	 *
	 * @param allMateriel the all materiel
	 */
	public void refreshModel(boolean allMateriel) {
		if (allMateriel) {
			listeMateriel = MaterielManager.loadOutsideColis(uidColisToManage);

		} else {
			listeMateriel = MaterielManager.loadByColis(uidColisToManage);
		}
		fireTableDataChanged();

	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeMateriel != null) {
			return listeMateriel.size();
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return MaterielColumnName[columnIndex];
	}

	/* (non-Javadoc)
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
			return Integer.class;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Materiel materiel = listeMateriel.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return materiel.getType();
		case 1:
			return materiel.getDenomination();
		case 2:
			if (materiel.getType() == "Materiel") {
				return materiel.getObservations();
			} else {
				if (materiel instanceof Medicament) {
					Medicament tempMed = MedicamentManager
							.createTempMedicament();
					tempMed = (Medicament) materiel;
					return tempMed.getDosage();
				}
			}
		case 3:
			return materiel.getQuantite();
		case 4:
			return materiel.getUid();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			listeMateriel.get(rowIndex).setType(
					aValue == null ? null : aValue.toString());
			break;
		case 1:
			listeMateriel.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			if (listeMateriel.get(rowIndex).getType() == "Materiel") {
				listeMateriel.get(rowIndex).setObservations(
						aValue == null ? null : aValue.toString());
			} else {
				if (listeMateriel.get(rowIndex) instanceof Medicament) {
					((Medicament) listeMateriel.get(rowIndex))
							.setDosage(aValue == null ? null : aValue
									.toString());
				}
			}
			break;
		case 3:
			listeMateriel.get(rowIndex).setQuantite(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		}
	}

	/* (non-Javadoc)
	 * @see escrim.model.table.EscrimTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;

	}

}
