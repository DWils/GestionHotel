
package fr.afpa.main;

public class Chambre {
	private int numero;
	private String nom;
	private String superficie;
	private String vue;
	private float tarif;
	private String[] options;
	private String occupation;
	private Reservation[] listeReservation;
	private static int reservee;
	private static int ocuppee;
	
	
	public Chambre(int num , String n ,String sup, String v ,float t , String[] opts, Reservation[] listeR ) {
		numero = num;
		nom = n;
		superficie = sup;
		vue = v;
		tarif = t;
		options = opts;
		listeReservation = listeR;
		
	}
	
	public Chambre() {
		numero = 0;
		nom = new String("");
		superficie = new String("");;
		vue = new String("");;
		tarif = 0;
		options = new String[10];
		listeReservation = new Reservation[3];
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
	
	public void setTarif(float tf) {
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

//	public String getEtat() {
//		return etat;
//	}

//	public void setEtat(String et) {
//		etat = et;
//	}

	public String getVue() {
		return vue;
	}

	public void setVue(String v) {
		vue = v;
	}

	public Reservation[] getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(Reservation[] listeR) {
		listeReservation = listeR;
	}

	public static int getReservee() {
		return reservee;
	}

	public static void setReservee(int reservee) {
		Chambre.reservee = reservee;
	}

	public static int getOcuppee() {
		return ocuppee;
	}

	public static void setOcuppee(int oc) {
		ocuppee = oc;
	}
}
