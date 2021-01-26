package fr.afpa.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
//bon fichier
public class Inscription {
	private String numero;
	private static boolean employes = false;
	private String prenom;
	private String telephone;
	private String listReservation;
	static String[] clientId= new String[50]; 
	static Client[] file = new Client[50]; 
	private static Hotel hotel = new Hotel();
	static Client cl = new Client();
	static Chambre chambre = new Chambre();


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
		for (int i =0; i <10; i++) {
		String code = Integer.toString((int) (Math.random()*9)+0);
		str = str + code;
		}
		user.setIdClient(str);
		System.out.println("Votre code est : "+str);
		
		return user;
	}
	
	public static Client login(Hotel hotel) {
		
		boolean client = false;
		boolean exist = false;
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.print("Nouveau sur notre plateforme?  Y | N : ");
		String demande = saisieUtilisateur.nextLine();
		if (demande.equals("Y")) {
			
			cl = inscrire();
			System.out.print("Entrez votre code d'identification : ");
			demande = saisieUtilisateur.nextLine();
			if(demande.equals(cl.getIdClient()) ) {
	        	  
	        	  Clientmenu();
	        	  
	          }
	          else {System.out.print("Erreur d'authentification ,Réésasayer ou inscrvez vous: ");
	          cl = inscrire();
	                   
	          }
					}
		
		
		if(demande.equals("N")) {
			System.out.print("Entrer votre numero d'identification: ");
			demande = saisieUtilisateur.nextLine();
			 if(demande.startsWith("GH") && demande.length() == 6) {
		         employes = true;
		         Employemenu(hotel);
		        }
		        
			if(demande.length() == 10 && Entier.isInt(demande)){
		          if(demande.equals(cl.getIdClient()) ) {
		        	 
		        	  Clientmenu();
		        	  
		          }
		          else {System.out.print("Erreur d'authentification ,Réésasayer ou inscrvez vous: ");
		          cl = inscrire();
		          
		          
		          }
			
				}
			}
		return cl;
		}
		
		
	
	public static void Employemenu(Hotel hotel) {System.out.println("__MENU HOTEL CDA JAVA __");
	Scanner saisieUtilisateur = new Scanner(System.in);
    System.out.println("   A- A-Afficher l’état de l’hôtel");
    System.out.println("   B-Afficher le nombre de chambres réservées");
    System.out.println("   C- Afficher le nombre de chambre libre");
    System.out.println("   D-Afficher le numéro de la première chambre vide");
    System.out.println("   E-Afficher le numéro de la dernière chambre vide");
    System.out.println("   F-Réserver une chambre ");
    System.out.println("   G-Libérer une chambre");
    System.out.println("   H-Modifier une réservation");
    System.out.println("   I-Annuler une réservation");
    System.out.println("   J-Afficher le CA à une date donnée");

    System.out.println("__");
    String key ="";
    while (!key.equals("Q")) {
   	 
   	  System.out.println("Quels informations recherchez vous ? : ");
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
         
             
         case "H":

 		
 		  }
     }
    if(key.equals("Q")) {
    	Inscription.login(hotel);
    }
     }
	public static void Clientmenu() {
	
		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.println("__MENU HOTEL CDA JAVA __");
		System.out.println(cl.getNom() + " " +cl.getPrenom() +" "  );
		
		
		System.out.println("Vous avez " + cl.getNbReservation()+" réservation."  );
		System.out.println("Voulez vous reserver une chambre: Y  |  N : Ou supprimer une reservation : S");
		String key = saisieUtilisateur.next();
		
		if (key.equals("Y")) {
			
			Reservation.reserverCl(cl,chambre,hotel);
		}
		if (key.equals("S")) {
			
			Reservation.annuler(cl,chambre);
		}
		
		else {Inscription.login(hotel);}

		      
	}

	public static void ListAt() {
		for (int i = 0; i < file.length; i++) {
			if (file[i] != null) {
			System.out.println("client n°"+ i + " --->"+file[i]);
		}
			}
	}
}