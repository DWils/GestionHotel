package fr.afpa.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean employes = false;
		boolean client = false;
		Inscription client1 = new Inscription();
		boolean gotaccount = false;
		boolean inscription = false;
		Hotel hotel = new Hotel();

		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.print("Saisir votre numero d'identification:");
		client1.setId(saisieUtilisateur.nextLine());
		String entrer = client1.getId();
		

		/*
		*/

		for (int i = 0; i < client1.getClientId().length; i++) {
			if (client1.getClientId()[i] == entrer) {
				gotaccount = true;
				System.out.print("Connecte!");
			}
			if (i == client1.getClientId().length - 1 && gotaccount == false) {
				inscription = true;
			}
		}

		for (int i = 0; i < client1.getClientId().length; i++) {
			if (client1.getClientId()[i] == null && inscription == true) {
				client1.getClientId()[i] = client1.getId();

			}
		}
//		if(inscription == true) 
//		{
//			Inscription.inscrire();
//			
//		}

		String[] dataChambres = { "Type chambre;Taille;Vues;Occupation;tarif;Nombre;Options",
				"Chambre Vue Piscine;44 metres carres;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche a� repasser sur demande|Telephone |Television par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
				"Chambre Vue Jardin;44 metres carres;Jardin, Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche a� repasser sur demande|Telephone |Television par cable|Climatisation|Bouilloire électrique|Concierge 24h/24",
				"Chambre Vue Ocean;44 metres carres;Partielle Ocean et Foret ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche a� repasser sur demande|Telephone |Acces Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Chambre vue imprenable sur l'ocean;44 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche à repasser sur demande|Telephone |Acces Internet haut debit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite CDA;82 metres carres;Ocean et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut débit sans fil|Lecteur DVD sur demande|Television par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Executive;140 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;550;5;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Ambassadeur;230 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;1650;7;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Royale;342  metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;2400;4;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Acces Internet haut débit sans fil|Lecteur DVD sur demande|Television par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

		hotel.readDataChambre(dataChambres);
		
		

		
		if(entrer.length() == 10 && Entier.isInt(entrer)){
	          client = true ;
	          System.out.print("________________________PORTAIL CLIENT__________________________");
	         
	          
	          
	      }
	     if(entrer.startsWith("GH") && entrer.length() == 6) {
	         employes = true;
	         System.out.print("________________________PORTAIL EMPLOYEE_______________________");
	        
	         String key ="";
	         while (!key.equals("Q")) {
	        	 System.out.println("\n");
	        	 menuEmploye();	
	        	  System.out.println("Quels informations recherchez vous ? :");
	      		  key = saisieUtilisateur.next();
	      		  switch(key) {
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
		
	}
	
	public static void menuEmploye(){
		System.out.println("___________MENU HOTEL CDA JAVA _________________");
		System.out.println("   A-Afficher l��tat de l�h�tel");
		System.out.println("   B-Afficher le nombre de chambres r�serv�es");
		System.out.println("   C- Afficher le nombre de chambre libre");
		System.out.println("   D-Afficher le num�ro de la premi�re chambre vide");
		System.out.println("   E-Afficher le num�ro de la derni�re chambre vide");
		System.out.println("   F-R�server une chambre ");
		System.out.println("   G-Lib�rer une chambre");
		System.out.println("   H-Modifier une r�servation");
		System.out.println("   I-Annuler une r�servation");
		System.out.println("   J-Afficher le CA � une date donn�e");

		System.out.println("________________________________________________");
	}
		
		
	}


