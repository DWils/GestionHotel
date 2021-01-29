
package fr.afpa.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import fr.afpa.beans.CategorieChambre;
import fr.afpa.beans.Chambre;
import fr.afpa.beans.Client;
import fr.afpa.beans.Reservation;

public class GestionChambre {

	private Chambre[] listeChambres;
	private CategorieChambre[] listeCategorieChambre;
	private float chiffreAffaire;
	Scanner saisieUtilisateur = new Scanner(System.in);
	String[] dataSplit = null;
	String[] listeOptions = null;
	Chambre chambre = new Chambre();
	int numeroChambre = 1;
	LocalDate dateDebutLD = null;
	LocalDate dateFinLD = null;

	int nbChambre = 0;

	public GestionChambre(Chambre[] ch, float ca) {
		listeChambres = ch;
		chiffreAffaire = ca;
	}

	public GestionChambre(Chambre[] ch) {
		listeChambres = ch;
		chiffreAffaire = (float) 0;
	}

	public GestionChambre() {
		listeChambres = new Chambre[65];
		chiffreAffaire = (float) 0;
	}

	public Chambre[] getListeChambres() {
		return listeChambres;

	}

	public void setListeChambres(Chambre[] lc) {
		listeChambres = lc;
	}

	public float getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(float ca) {
		chiffreAffaire = ca;
	}

	public void readDataChambre(String[] data) {
//		for (int i = 1; i < data.length; i++) {
//
//			dataSplit = data[i].split(";");
//
//			nbChambre = nbChambre + Integer.parseInt(dataSplit[5]);
//
//		}
		// System.out.println(nbChambre); //Check up nombre total de chambre
		listeCategorieChambre = new CategorieChambre[data.length - 1];
		
		//chambre = new Chambre();
		for (int i = 1; i < data.length; i++) {
			dataSplit = data[i].split(";");
			listeOptions = dataSplit[6].split("\\|");
			listeChambres = new Chambre[Integer.parseInt(dataSplit[5])];
			listeCategorieChambre[i - 1] = new CategorieChambre(dataSplit[0], dataSplit[1], dataSplit[2], Float.parseFloat(dataSplit[4]) , listeOptions, dataSplit[3], listeChambres);
			
			for (int j = 0; j < Integer.parseInt(dataSplit[5]); j++) {
				listeCategorieChambre[i - 1].getListeChambres()[j] = new Chambre();
			}
			
		}
	}

	public void afficheListeTypeChambre(GestionChambre hotel) {
		String roomName = "";
		int i = 0;
		for (int j = 0; j < hotel.getListeChambres().length; j++) {

			if (isChambreLibre(hotel.getListeChambres()[j])
					&& !(hotel.getListeChambres()[j].getNom().equals(roomName))) {

				System.out.println("----------------------------------------------");
				System.out.println("Type n° " + (hotel.getListeChambres()[j].getNumero() / 100) + " "
						+ hotel.getListeChambres()[j].getNom() + " " + hotel.getListeChambres()[j].getTarif()
						+ " euros \n" + hotel.getListeChambres()[j].getOccupation() + "\n " + "Superficie : "
						+ hotel.getListeChambres()[j].getSuperficie() + "\n " + "Vue : "
						+ hotel.getListeChambres()[j].getVue() + "\n " + "Liste options :");
				afficheOptions(hotel.getListeChambres()[j].getOptions());
				System.out.println("----------------------------------------------");

			}
			roomName = hotel.getListeChambres()[j].getNom();
		}

	}

	public Chambre[] getListeTypeChambre() {

		return listeCategorieChambre;
	}

	public void setListeTypeChambre(CategorieChambre[] ltc) {
		listeCategorieChambre = ltc;
	}

	public void afficheOptions(String[] options) {
		for (int i = 0; i < options.length; i++) {
			System.out.println("   " + options[i]);

		}
	}

	public void afficheEtatHotel() {
	
		for (int i = 0; i < listeCategorieChambre.length; i++) {
			listeCatgorieChambre[i].afficheCategorieChambre();
//			System.out.println("----------------------------------------------");
//			System.out.println("Chambre n° " + hotel.getListeChambres()[i].getNumero() + " "
//					+ hotel.getListeChambres()[i].getNom() + " " + hotel.getListeChambres()[i].getTarif() + " euros"
//					+ "\n " + hotel.getListeChambres()[i].getOccupation() + "\n " + "Superficie : "
//					+ hotel.getListeChambres()[i].getSuperficie() + "\n " + "Vue : "
//					+ hotel.getListeChambres()[i].getVue() + "\n " + "Liste options :");
//			afficheOptions(listeChambres[i].getOptions());
//			if (hotel.getListeChambres()[i].getListeReservation()[0] != null) {
//				for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
//					System.out.println("----------------------------------------------");
//					System.out.println(hotel.getListeChambres()[i].getListeReservation()[i].getClient().getNom() + " "
//							+ hotel.getListeChambres()[i].getListeReservation()[j].getDateDebut() + " - "
//							+ hotel.getListeChambres()[i].getListeReservation()[j].getDateFin());
//				}
//			} else {
//				System.out.println("----------------------------------------------");
//				System.out.println("Pas de réservation en cours");
//			}
//			System.out.println("----------------------------------------------");
		}
	}

	public void afficherNbResa() {
		Chambre ch = new Chambre();
		System.out.println(ch.nbReservee);
	}

	public void afficherNbLibre() {
		Chambre ch = new Chambre();
		System.out.println(listeChambres.length - ch.nbReservee - ch.nbOcuppee);
	}

	public void afficherPremiereChambre(GestionChambre hotel) {
		for (int i = 0; i < hotel.listeChambres.length; i++) {
			if (hotel.getListeChambres()[i] != null) {
				int compteur = 0;
				for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
					if (hotel.getListeChambres()[i].getListeReservation()[j] == null) {
						compteur++;
					}
				}
				if (compteur == 3) {
					System.out.println(hotel.getListeChambres()[i].getNumero());
					break;
				}
			}
		}
	}

	public boolean isChambreLibre(Chambre chambre) {
		boolean found = false;
		if (chambre != null) {
			int compteur = 0;
			for (int j = 0; j < chambre.getListeReservation().length; j++) {
				if (chambre.getListeReservation()[j] == null) {
					compteur++;
				}
				if (compteur > 0) {
					found = true;
					break;
				}
			}

		}

		return found;
	}

	public void afficherDerniereChambre(GestionChambre hotel) {
		for (int i = hotel.listeChambres.length - 1; i >= 0; i--) {
			int compteur = 0;
			for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
				if (hotel.getListeChambres()[i].getListeReservation()[j] == null) {
					compteur++;
				}
			}
			if (compteur == 3) {
				System.out.println(hotel.getListeChambres()[i].getNumero());
				break;
			}

		}

	}

	public void reserverChambre(GestionChambre hotel) {
		System.out.println("Bienvenue dans la reservation de chambre");
		Client client = null;
		Inscription inscription = new Inscription();
		client = inscription.inscrire();
		System.out.println("Quel dates voulez-vous reserver ?");
		do {
			System.out.println("date de debut :(Respectez le format : jj/mm/aaaa)");
			String dateDebut = saisieUtilisateur.nextLine();
			dateDebutLD = LocalDate.parse(dateDebut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		} while (dateDebutLD.isBefore(LocalDate.now()));

		do {
			System.out.println("date de fin :(Respectez le format : jj/mm/aaaa)");
			String dateFin = saisieUtilisateur.nextLine();
			dateFinLD = LocalDate.parse(dateFin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} while ((dateFinLD.isBefore(LocalDate.now())) || (dateFinLD.isBefore(dateDebutLD)));

		int key = 0;
		while (key != -1) {
			afficheListeTypeChambre(hotel);
			System.out.println("Quelle chambre souhaitez-vous prendre ? (pour annuler votre demande tapez -1)");
			key = saisieUtilisateur.nextInt();
			if (key >= 1 && key <= 8) {
				Chambre typeChoisi = hotel.listeCategorieChambre[key - 1];
				for (int i = 0; i < hotel.getListeChambres().length; i++) {
					{
						if (typeChoisi.getNom().equals(hotel.getListeChambres()[i].getNom())
								&& isChambreLibre(hotel.getListeChambres()[i])) {
							System.out.println(
									"Nous vous attribuons la chambre n° " 
									+ hotel.getListeChambres()[i].getNumero()+"\n"
									+ "Le montant de votre réservation est de "
									+ hotel.getListeChambres()[i].getTarif() * ChronoUnit.DAYS.between(dateDebutLD, dateFinLD) + " euros"
									);
									int j3 = 0;
									while (j3 < hotel.getListeChambres()[i].getListeReservation().length) {
										if(hotel.getListeChambres()[i].getListeReservation()[j3] == null) {
											hotel.getListeChambres()[i].getListeReservation()[j3] = new Reservation(dateDebutLD, dateFinLD, client);
											hotel.getListeChambres()[0].setReservee(hotel.getListeChambres()[0].getReservee()+1);
											j3 = 100;
										}
										j3++;
									} 
									
						}
					}

				}
			}

		}

	}
}
