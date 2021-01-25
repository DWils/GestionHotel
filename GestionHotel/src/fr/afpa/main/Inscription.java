package fr.afpa.main;

import java.util.Scanner;

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
	
	public static Client inscrire() {
		Scanner saisieUtilisateur = new Scanner(System.in);
		Client user = new Client();
		System.out.print("Inscrivez vous, nom : ");
		user.setNom(saisieUtilisateur.nextLine());
		System.out.print("Inscrivez vous, prenom : ");
		user.setPrenom(saisieUtilisateur.nextLine());
		return user;
	}
}
