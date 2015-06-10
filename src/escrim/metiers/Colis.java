/**
 * 
 */
package escrim.metiers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Martin
 *
 */
@Entity
public class Colis {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	private String affectation;
	private String module;
	private boolean optionnel;
	@ManyToOne
	private Localisation localisation;
	@ManyToOne
	private TypeColis typeColis;
	private int numeroColis;
	private String nomColis;
	@OneToMany(mappedBy="colis",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Materiel> listeMateriel;
	private float valeur;
	private String iata;
	private float projection;
	private String observation;
	@ManyToMany
	private List<ConfigurationHopital> listConfigDuColis;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getAffectation() {
		return affectation;
	}
	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public boolean isOptionnel() {
		return optionnel;
	}
	public void setOptionnel(boolean optionnel) {
		this.optionnel = optionnel;
	}
	public Localisation getSecteur() {
		return localisation;
	}
	public void setSecteur(Localisation localisation) {
		this.localisation = localisation;
	}
	public TypeColis getTypeColis() {
		return typeColis;
	}
	public void setTypeColis(TypeColis typeColis) {
		this.typeColis = typeColis;
	}
	public int getNumeroColis() {
		return numeroColis;
	}
	public void setNumeroColis(int numeroColis) {
		this.numeroColis = numeroColis;
	}
	public String getNomColis() {
		return nomColis;
	}
	public void setNomColis(String nomColis) {
		this.nomColis = nomColis;
	}
	public List<Materiel> getListeMateriel() {
		return listeMateriel;
	}
	public void setListeMateriel(List<Materiel> listeMateriel) {
		this.listeMateriel = listeMateriel;
	}
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}
	public float getProjection() {
		return projection;
	}
	public void setProjection(float projection) {
		this.projection = projection;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public List<ConfigurationHopital> getListConfigDuColis() {
		return listConfigDuColis;
	}
	public void setListConfigDuColis(List<ConfigurationHopital> listConfigDuColis) {
		this.listConfigDuColis = listConfigDuColis;
	}

}