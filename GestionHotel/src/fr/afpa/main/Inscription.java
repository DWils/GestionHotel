package fr.afpa.main;

public class Inscription {
	private String numero;
	private String prenom;
	private String telephone;
	private String listReservation;
	String[] clientId= new String[50]; 
	

	public void setId(String id) {
		
		numero = id;
	}
	public String getId() {
		return numero;
	}

	public void connexion() {
		
	}
	

	public String[] getClientId() {
		return clientId;
	}
	
}