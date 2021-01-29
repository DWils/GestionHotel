package fr.afpa.services;

import java.util.Random;

import java.util.Scanner;

import fr.afpa.beans.Client;
import fr.afpa.main.Entier;

public class Inscription {
	private String numero;
	private static boolean employes = false;
	private String prenom;
	private String telephone;
	private String listReservation;
	static String[] clientId = new String[50];
	static Client[] file = new Client[50];
	private static GestionChambre hotel = new GestionChambre();

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

		String str = "";
		Scanner saisieUtilisateur = new Scanner(System.in);
		Client user = new Client();
		System.out.print("Inconnu.....Inscrivez vous, nom : ");
		user.setNom(saisieUtilisateur.nextLine());
		System.out.print("... prenom : ");
		user.setPrenom(saisieUtilisateur.nextLine());
		for (int i = 0; i < 10; i++) {
			String code = Integer.toString((int) (Math.random() * 9) + 0);
			str = str + code;
		}
		user.setIdClient(str);
		System.out.println("Votre code est : " + str);

		return user;
	}

	public static Client login(GestionChambre hotel) {
		Client cl = new Client();
		boolean client = false;
		boolean exist = false;
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.print("Nouveau sur notre plateforme?  Y | N ");
		String demande = saisieUtilisateur.nextLine();
		if (demande.equals("Y")) {

			cl = inscrire();
			System.out.print("Entrez votre code d'identification :");
			demande = saisieUtilisateur.nextLine();
			if (demande.equals(cl.getIdClient())) {

				Clientmenu();

			} else {
				System.out.print("Erreur d'authentification ,R��sasayer ou inscrvez vous:");
				cl = inscrire();

			}
		}

		if (demande.equals("N")) {
			System.out.print("Entrer votre numero d'identification");
			demande = saisieUtilisateur.nextLine();
			if (demande.startsWith("GH") && demande.length() == 6) {
				employes = true;
				employeMenu(hotel);
			}

			if (demande.length() == 10 && Entier.isInt(demande)) {
				if (demande.equals(cl.getIdClient())) {

					Clientmenu();

				} else {
					System.out.print("Erreur d'authentification ,R��sasayer ou inscrvez vous:");
					cl = inscrire();

				}

			}
		}
		return cl;
	}

	public static void affichageMenu() {
		System.out.println("_____________________MENU HOTEL CDA JAVA _____________________");
		System.out.println("   A- Afficher l'�tat de l'hotel");
		System.out.println("   B- Afficher le nombre de chambres r�serv�es");
		System.out.println("   C- Afficher le nombre de chambre libre");
		System.out.println("   D- Afficher le numero de la premi�re chambre vide");
		System.out.println("   E- Afficher le numero de la derni�re chambre vide");
		System.out.println("   F- Reserver une chambre ");
		System.out.println("   G- Liberer une chambre");
		System.out.println("   H- Modifier une reservation");
		System.out.println("   I- Annuler une reservation");
		System.out.println("   J- Afficher le CA � une date donn�e");
		System.out.println("_______________________________________________________________");
	}

	public static void employeMenu(GestionChambre hotel) {
		Scanner saisieUtilisateur = new Scanner(System.in);

		
		String key = "";
		while (!key.equals("Q")) {
			affichageMenu();
			System.out.println("Quels informations recherchez vous ? :");
			key = saisieUtilisateur.next();
			switch (key) {
			case "A":
				hotel.afficheEtatHotel(hotel);
				break;
			case "B":
				hotel.afficherNbResa();
				break;
			case "C":
				hotel.afficherNbLibre();
				break;
			case "D":
				hotel.afficherPremiereChambre(hotel);
				break;
			case "E":
				hotel.afficherDerniereChambre(hotel);
				break;
			case "F":
				hotel.reserverChambre(hotel);

			}
		}
	}

	public static void Clientmenu() {
		System.out.print("GG menu:");
	}

	public static void ListAt() {
		for (int i = 0; i < file.length; i++) {
			if (file[i] != null) {
				System.out.println("client n�" + i + " --->" + file[i]);
			}
		}
	}

}
