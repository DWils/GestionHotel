package fr.afpa.main;

import java.util.Scanner;

public class Inscription {
	private String numero;
	private String prenom;
	private String telephone;
	private String listReservation;
	static String[] clientId= new String[50]; 
	static Client[] file = new Client[50]; 

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
		System.out.print("Inconnu.....Inscrivez vous, nom : ");
		user.setNom(saisieUtilisateur.nextLine());
		System.out.print("... prenom : ");
		user.setPrenom(saisieUtilisateur.nextLine());
		return user;
	}
	
	public static void login() {
		Client cl = new Client();
		boolean exist = false;
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.print("Nouveau sur notre plateforme?  Y | N ");
		String demande = saisieUtilisateur.nextLine();
		if (demande.equals("Y")) {
			System.out.print("Entrer votre nom la demande sera traité ulterieurement");
			demande = saisieUtilisateur.nextLine();
			for (int i = 0; i < file.length; i++) {
				if (file[i] == null && exist == false) {
					cl= inscrire();
					file[i] = new Inscritpion.inscrire();
					exist = true;
					System.out.println(file[i]);
				}
					}
		if(demande.equals("N")) {
			System.out.print("Entrer votre numero d'identification");
			demande = saisieUtilisateur.nextLine();
			for (int i = 0; i < clientId.length; i++) {
				if(demande == clientId[i]) {
					
				}
				if (i == clientId.length-1 && exist == false) {
					System.out.print("Numero inconnu réessayez");
					login();
				}
			}
		} 
		
	}
}
	public static void ListAt() {
		for (int i = 0; i < file.length; i++) {
			if (file[i] != null) {
			System.out.println("client n°"+ i + " --->"+file[i]);
		}
			}
	}
}