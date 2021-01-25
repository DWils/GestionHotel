package fr.afpa.main;

import java.time.LocalDate;

public class Reservation {
	private String code;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Client client;
	
	public Reservation(String c , LocalDate deb , LocalDate fin){
		code =  c;
		dateDebut = deb;
		dateFin = fin;
	}
		
	public String getCode() {
		return code;
	}
	
	public void setCode(String c) {
		code = c;
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

	public void setClient(Client client) {
		this.client = client;
	}
}
