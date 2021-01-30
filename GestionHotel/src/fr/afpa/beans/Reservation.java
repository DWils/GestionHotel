package fr.afpa.beans;

import java.time.LocalDate;

public class Reservation {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Client client;
	private float facture;
	
	public Reservation(LocalDate deb , LocalDate fin, Client cl, float uneFacture){
	
		dateDebut = deb;
		dateFin = fin;
		client = cl;
		facture = uneFacture;
		
	}
	
	public LocalDate getDateDebut(){
		return dateDebut;
	}
	
	public void setDateDebut(LocalDate dd) {
		dateFin = dd;
	}
	
	
	public LocalDate getDateFin(){
		return dateFin;
	}
	
	public void setDateFin(LocalDate df) {
		dateFin = df;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client cl) {
		client = cl;
	}
	
	public float getFacture() {
		return facture;
	}

	public void setFacture(float facture) {
		this.facture = facture;
	}
	
	public void afficherReservation() {
		
		System.out.println(client.getIdClient() + " " + client.getNom() + " du " 
				+ dateDebut + " au " + dateFin + " pour un montant de " + facture);
	}

	
	
}
