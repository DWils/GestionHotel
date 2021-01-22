package fr.apfa.main;
package fr.afpa.main;

public class Chambre {
	private int numero;
	private String nom;
	private String superficie;
	private String vue;
	private double tarif;
	private String[] options;
	private String occupation;
	private String etat;
	
	
	public Chambre(int num , String n ,String sup, String v ,double t , String[] opts ) {
		numero = num;
		nom = n;
		superficie = sup;
		vue = v;
		tarif = t;
		options = opts;
		setEtat("libre");
	}
	
	public Chambre() {
		
	}

	public int getNumero() {
		return numero;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String sup) {
		superficie = sup;
	}

	public double getTarif() {
		return tarif;
	}
	
	public String[] getOptions () {
		return options;
	}
	
	public void setNumero(int num) {
		numero = num;
	}
	
	public void setNom(String n) {
		nom = n;
	}
	
	public void setTarif(double tf) {
		tarif = tf;
	}
	
	public void setOptions(String[] opts) {
		options = opts;
	}
	
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String oc) {
		occupation = oc;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String et) {
		etat = et;
	}

	public String getVue() {
		return vue;
	}

	public void setVue(String v) {
		vue = v;
	}
}
