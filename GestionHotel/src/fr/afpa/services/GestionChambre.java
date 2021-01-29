
package fr.afpa.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
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

		// chambre = new Chambre();
		for (int i = 1; i < data.length; i++) {
			dataSplit = data[i].split(";");
			listeOptions = dataSplit[6].split("\\|");
			listeChambres = new Chambre[Integer.parseInt(dataSplit[5])];
			listeCategorieChambre[i - 1] = new CategorieChambre(dataSplit[0], dataSplit[1], dataSplit[2],
					Float.parseFloat(dataSplit[4]), listeOptions, dataSplit[3], listeChambres);

			for (int j = 0; j < Integer.parseInt(dataSplit[5]); j++) {
				listeCategorieChambre[i - 1].getListeChambres()[j] = new Chambre();
			}

		}
	}

	public void afficheListeCategorieChambre() {
		for (int i = 0; i < listeCategorieChambre.length; i++) {
			boolean flagCat = false;
			for (int j = 0; j < listeCategorieChambre[i].getListeChambres().length; j++) {
				if (isChambreLibre(listeCategorieChambre[i].getListeChambres()[j])) {
					flagCat = true;
				}
			}
			if (flagCat) {
				listeCategorieChambre[i].afficheCategorieChambre();
			}
		}
	}

	public CategorieChambre[] getListeCategorieChambre() {

		return listeCategorieChambre;
	}

	public void setListeCategorieChambre(CategorieChambre[] catChambre) {
		listeCategorieChambre = catChambre;
	}

//	public void afficheOptions(String[] options) {
//		for (int i = 0; i < options.length; i++) {
//			System.out.println("   " + options[i]);
//
//		}
//	}

	public void afficheEtatHotel() {

		for (int i = 0; i < listeCategorieChambre.length; i++) {
			listeCategorieChambre[i].afficheCategorieChambre();
			for (int j = 0; j < listeCategorieChambre[i].getListeChambres().length; j++) {
				boolean flagResa = false;
				listeCategorieChambre[i].getListeChambres()[j].afficherChambre();
				for (int j2 = 0; j2 < listeCategorieChambre[i].getListeChambres()[j]
						.getListeReservation().length; j2++) {
					
					if (listeCategorieChambre[i].getListeChambres()[j].getListeReservation()[j2] != null) {
						listeCategorieChambre[i].getListeChambres()[j].getListeReservation()[j2].afficherReservation();
						flagResa = true;
					}
				}
				if (!flagResa) {
					System.out.println("Pas de réservation en cours");
				}
			}
		}
	}

	public void afficherNbResa() {
		System.out.println(Chambre.nbReservee);
	}

	public void afficherNbLibre() {
		System.out.println(65 - Chambre.nbReservee - Chambre.nbOcuppee);
	}

	public void afficherPremiereChambre() {
		for (int i = 0; i < listeCategorieChambre.length; i++) {
			// int compteur = 0;
			if (listeCategorieChambre[i] != null) {
				for (int j = 0; j < listeCategorieChambre[i].getListeChambres().length; j++) {
					if (listeCategorieChambre[i].getListeChambres()[j] != null) {
						for (int j2 = 0; j2 < listeCategorieChambre[i].getListeChambres()[j]
								.getListeReservation().length; j2++) {
							if (listeCategorieChambre[i].getListeChambres()[j].getListeReservation()[j2] == null) {
								listeCategorieChambre[i].getListeChambres()[j].afficherChambre();
								break;
							}
						}
					}
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

	public void afficherDerniereChambre() {
		for (int i = listeCategorieChambre.length-1; i >= 0; i--) {
			// int compteur = 0;
			if (listeCategorieChambre[i] != null) {
				for (int j = listeCategorieChambre[i].getListeChambres().length ; j >= 0; j--) {
					if (listeCategorieChambre[i].getListeChambres()[j] != null) {
						for (int j2 = 0; j2 < listeCategorieChambre[i].getListeChambres()[j].getListeReservation().length; j2++) {
							if (listeCategorieChambre[i].getListeChambres()[j].getListeReservation()[j2] == null) {
								listeCategorieChambre[i].getListeChambres()[j].afficherChambre();
								break;
							}
						}
					}
				}
			}
		}

	}

	public void reserverChambre() {
		System.out.println("Bienvenue dans la reservation de chambre");
		Client client = null;
		String str = null;
		Scanner saisieUtilisateur = new Scanner(System.in);
		
		client = Inscription.inscrire();
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
			afficheListeCategorieChambre();
			System.out.println("Quelle chambre souhaitez-vous prendre ? (pour annuler votre demande tapez -1)");
			key = saisieUtilisateur.nextInt();
			if (key >= 1 && key <= 8) {
				System.out.println("Vous avez choisi : ");
				listeCategorieChambre[key - 1].afficheCategorieChambre();;
				boolean flagResa = false;
				for (int i = 0; i < listeCategorieChambre[key - 1].getListeChambres().length; i++) {
					if (isChambreLibre(listeCategorieChambre[key - 1].getListeChambres()[i]) && !(flagResa)) {
						System.out.println("Nous vous attribuons la chambre n° "
								+ listeCategorieChambre[key - 1].getListeChambres()[i].getNumero() + "\n"
								+ "Le montant de votre réservation est de "
								+ listeCategorieChambre[key - 1].getTarif() * (ChronoUnit.DAYS.between(dateDebutLD, dateFinLD)+1) + " euros");
						
						flagResa = true;
					}
				}
			}

		}
	}

}
