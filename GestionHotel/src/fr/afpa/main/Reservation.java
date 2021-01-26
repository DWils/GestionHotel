package fr.afpa.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reservation {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private static Client client;
	private static int count = 0;

	
	public Reservation(LocalDate deb , LocalDate fin, Client cl){
	
		dateDebut = deb;
		dateFin = fin;
		client = cl;
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

	public static Client getClient(String string) {
		return client;
	}

	public static void setClient(Client cl) {
		client = cl;
	}
	public static void reserverCl(Client cl,Chambre chambre,Hotel hotel) {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy"); // format de la date 
	Scanner saisieUtilisateur = new Scanner(System.in);	
	System.out.println("Date de debut : "  );
	String debut = saisieUtilisateur.next();
	System.out.println("Date de fin : "  );
	String fin = saisieUtilisateur.next();
	LocalDate localDate = LocalDate.parse(debut, formatter);
	LocalDate localDate2 = LocalDate.parse(debut, formatter);
	Reservation reservation = new Reservation(localDate, localDate2, cl);
	
	System.out.println("ca commence le ; " +  reservation.getDateDebut());
		
		
		for (int i=0;i<chambre.getListeReservation().length;i++) {
			if(chambre.getListeReservation()[i]==null) {
				chambre.getListeReservation()[i]=reservation;
				System.out.println("inscrit");
				count = count +1;
				//System.out.print(count);
				cl.setNbReservation(count);
				//System.out.println(cl.getNbReservation());
				Inscription.Clientmenu();
				break;
			}
			else {System.out.println("Vous avez atteint le max de reservation");}
		}
		
	}
	public static void annuler(Client cl,Chambre chambre) {
		Scanner saisieUtilisateur = new Scanner(System.in);	
		
		System.out.println("Quels reservation souhaitez vous annuler ?Taper son numero : "  );
		for (int i=0;i<chambre.getListeReservation().length;i++) {
			System.out.println(  chambre.getListeReservation()[i]);
		if(i==0 && chambre.getListeReservation()[i] != null ) {
			System.out.println("Annuler la premiere ?  "  );
		}
		if(i>0 && chambre.getListeReservation()[i] != null ) {
			System.out.println(" ou la " +(i+1)+ "ème"  );
		}
		}
		int fin = saisieUtilisateur.nextInt();
		chambre.getListeReservation()[fin] = null;
		count = count -1;
		cl.setNbReservation(count);
		
		Inscription.Clientmenu();
	}
	}
	

