package fr.afpa.main;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Main {

	public static void main(String[] args) {
		Inscription.login();
		Client cl = new Client();
		String[] infosChambre = null;
		String[] listeOptions = null;
		Hotel hotel = new Hotel();
		Chambre chambre = new Chambre();
		int numeroChambre = 0;
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

			}
<<<<<<< Updated upstream
=======
		}
		if(inscription == true) 
		{
			cl= Inscription.inscrire();
			System.out.println("Votre nom est : "+ cl.getNom());
			
			
			
		}
		
		
>>>>>>> Stashed changes

			String[] listeChambres = { "Type chambre;Taille;Vues;Occupation;tarif;Nombre;Options",
					"Chambre Vue Piscine;44 mètres carrés;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
					"Chambre Vue Jardin;44 mètres carrés;Jardin, Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
					"Chambre Vue Océan;44 mètres carrés;Partielle Océan et Forêt ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Chambre vue imprenable sur l'océan;44 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite CDA;82 mètres carrés;Océan et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite Executive;140 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;550;5;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite Ambassadeur;230 mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;1650;7;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite Royale;342  mètres carrés;Océan;2 adultes et 2 enfants de moins de 12 ans;2400;4;Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

			for (int i2 = 1; i2 < listeChambres.length; i2++) {
				infosChambre = listeChambres[i2].split(";");
				for (int j = 0; j < infosChambre.length; j++) {
					for (int j2 = 0; j2 < Integer.parseInt(infosChambre[5]); j2++) {
						numeroChambre++;
						switch (j) {
						case 0:
							chambre.setNom(infosChambre[j]);
							break;
						case 1:
							chambre.setSuperficie(infosChambre[j]);
							break;
						case 2:
							chambre.setVue(infosChambre[j]);
						case 3:
							chambre.setOccupation(infosChambre[j]);
						case 4:
							chambre.setVue(infosChambre[j]);
						case 6:
							listeOptions = infosChambre[6].split("\\|");
							chambre.setOptions(listeOptions);
						default:
							break;
						}

					}

				}

			}
		}
<<<<<<< Updated upstream
=======
		
		for (Chambre chambre2 : enregistrementChambre) {
			System.out.println(chambre2.getNumero() + chambre2.getNom());}
		
	
		
		 
	     if(entrer.length() == 10 && Entier.isInt(entrer)){
	          client = true ;
	          System.out.print("________________________PORTAIL CLIENT__________________________");
	          
	         
	          
	          
	      }
	     if(entrer.startsWith("GH") && entrer.length() == 6) {
	         employes = true;
	         System.out.print("________________________PORTAIL EMPLOYEE_______________________");
	        
	         String key ="";
	         while (!key.equals("Q")) {
	        	 
	        	  System.out.println("Quels informations recherchez vous ? :");
	      		  key = saisieUtilisateur.next();
	      		  switch(key) {
	      		    case "A": Inscription.ListAt() ; break;
		      		case "B": break;
		      		case "C": break;
		      		case "D": break;
		      		case "E": break;
	      		
	      		  }
	          }
	          
	          

	      }
		
>>>>>>> Stashed changes
	}
}