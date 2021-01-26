package fr.afpa.main;

import java.time.LocalDate;

public class Reservation {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Client client;
	
	public Reservation(LocalDate deb , LocalDate fin, Client cl){
	
		dateDebut = deb;
		dateFin = fin;
		client = cl;
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
}
