package fr.afpa.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] infosChambre = null;
		String[] listeOptions = null;
		Chambre chambre = new Chambre();
		int numeroChambre = 0;
		int nbChambre = 0;
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
				"Chambre Vue Piscine;44 metres carres;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche a  repasser sur demande|Telephone |Television par cÃ¢ble|Climatisation|Bouilloire Ã©lectrique|Concierge 24h/24",
				"Chambre Vue Jardin;44 metres carres;Jardin, ForÃªt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche a  repasser sur demande|Telephone |Television par cable|Climatisation|Bouilloire Ã©lectrique|Concierge 24h/24",
				"Chambre Vue Ocean;44 metres carres;Partielle Ocean et Foret ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche a  repasser sur demande|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cÃ¢ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Chambre vue imprenable sur l'ocean;44 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche Ã  repasser sur demande|Telephone |Acces Internet haut debit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cÃ¢ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite CDA;82 metres carres;Ocean et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|Television par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Executive;140 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;550;5;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Ambassadeur;230 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;1650;7;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Royale;342  metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;2400;4;Seche-cheveux|Coffre-fort dans la chambre|Minibar|TÃ©lÃ©phone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|Television par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

		for (int i2 = 1; i2 < dataChambres.length; i2++) {

			infosChambre = dataChambres[i2].split(";");

			nbChambre = nbChambre + Integer.parseInt(infosChambre[5]);
			
		}
		//System.out.println(nbChambre); //Check up nombre total de chambre
		Chambre[] enregistrementChambre = new Chambre[nbChambre];
		hotel = new Hotel(enregistrementChambre);
		chambre = new Chambre();
		for (int i = 1; i < dataChambres.length; i++) {
			infosChambre = dataChambres[i].split(";");

			for (int j = 0; j < Integer.parseInt(infosChambre[5]) ; j++) {
				numeroChambre++;
				hotel.getListeChambres()[numeroChambre-1] = new Chambre();
				hotel.getListeChambres()[numeroChambre-1].setNumero(numeroChambre);
				hotel.getListeChambres()[numeroChambre-1].setNom(infosChambre[0]);
				hotel.getListeChambres()[numeroChambre-1].setSuperficie(infosChambre[1]);
				hotel.getListeChambres()[numeroChambre-1].setVue(infosChambre[2]);
				hotel.getListeChambres()[numeroChambre-1].setOccupation(infosChambre[3]);
				hotel.getListeChambres()[numeroChambre-1].setTarif(Float.parseFloat(infosChambre[4]));
				listeOptions = infosChambre[6].split("\\|");
				hotel.getListeChambres()[numeroChambre-1].setOptions(listeOptions);
				
			}
		}
		
		

		
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
		System.out.println("   A-Afficher l’état de l’hôtel");
		System.out.println("   B-Afficher le nombre de chambres réservées");
		System.out.println("   C- Afficher le nombre de chambre libre");
		System.out.println("   D-Afficher le numéro de la première chambre vide");
		System.out.println("   E-Afficher le numéro de la dernière chambre vide");
		System.out.println("   F-Réserver une chambre ");
		System.out.println("   G-Libérer une chambre");
		System.out.println("   H-Modifier une réservation");
		System.out.println("   I-Annuler une réservation");
		System.out.println("   J-Afficher le CA à une date donnée");

		System.out.println("________________________________________________");
	}
		
		
	}


