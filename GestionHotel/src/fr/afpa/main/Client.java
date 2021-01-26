package fr.afpa.main;

public class Client {
	private String nom;
	private String prenom;
	private String telephone;

	private String idClient;
	private int NbReservation ;
	private Reservation reservation = new Reservation(null, null, null);

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public int getNbReservation() {
		return NbReservation;
	}
	public void setNbReservation(int nbReservation) {
		NbReservation = nbReservation;
	}





}
