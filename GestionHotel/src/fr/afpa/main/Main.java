package fr.afpa.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] infosChambre = null;
		String[] listeOptions = null;
		Chambre chambre = new Chambre();
		int numeroChambre = 0;
		int nbChambre = 0;
		Inscription client1 = new Inscription();
		boolean gotaccount = false;
		boolean inscription = false;

		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.print("Saisir votre numero d'identification:");
		client1.setId(saisieUtilisateur.nextLine());
		String entrer = client1.getId();

		/*
		*/

		for (int i = 0; i < client1.getClientId().length; i++) {
			if (client1.getClientId()[i] == entrer) {
				gotaccount = true;
				System.out.print("Connecté!");
			}
			if (i == client1.getClientId().length - 1 && gotaccount == false) {
				inscription = true;
			}
		}

		for (int i = 0; i < client1.getClientId().length; i++) {
			if (client1.getClientId()[i] == null && inscription == true) {
				client1.getClientId()[i] = client1.getId();
				inscription = false;

			}
		}

		String[] dataChambres = { "Type chambre;Taille;Vues;Occupation;tarif;Nombre;Options",
				"Chambre Vue Piscine;44 mètres carrés;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
				"Chambre Vue Jardin;44 mètres carrés;Jardin, Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
				"Chambre Vue Océan;44 mètres carrés;Partielle Océan et Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Chambre vue imprenable sur l'océan;44 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite CDA;82 mètres carrés;Océan et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Executive;140 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;550;5;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Ambassadeur;230 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;1650;7;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Royale;342  mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;2400;4;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

		for (int i2 = 1; i2 < dataChambres.length; i2++) {

			infosChambre = dataChambres[i2].split(";");

			nbChambre = nbChambre + Integer.parseInt(infosChambre[5]);
			
		}
		System.out.println(nbChambre); //Check up nombre total de chambre
		Chambre[] enregistrementChambre = new Chambre[nbChambre];
		chambre = new Chambre();
		for (int i = 1; i < dataChambres.length; i++) {
			infosChambre = dataChambres[i].split(";");

			for (int j = 0; j < Integer.parseInt(infosChambre[5]) ; j++) {
				numeroChambre++;
				enregistrementChambre[numeroChambre-1] = new Chambre();
				enregistrementChambre[numeroChambre-1].setNumero(numeroChambre);
				enregistrementChambre[numeroChambre-1].setNom(infosChambre[0]);
				
			}
		}
		
		for (Chambre chambre2 : enregistrementChambre) {
			System.out.println(chambre2.getNumero() + chambre2.getNom());
		}
		
		
	}

}
