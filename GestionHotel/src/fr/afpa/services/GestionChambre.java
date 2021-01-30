
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
	private Reservation[] listeReservation;

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
		listeCategorieChambre = new CategorieChambre[data.length - 1];

		for (int i = 1; i < data.length; i++) {
			dataSplit = data[i].split(";");
			listeOptions = dataSplit[6].split("\\|");
			listeChambres = new Chambre[Integer.parseInt(dataSplit[5])];
			listeCategorieChambre[i - 1] = new CategorieChambre(dataSplit[0], dataSplit[1], dataSplit[2],
					Float.parseFloat(dataSplit[4]), listeOptions, dataSplit[3], listeChambres);

			for (int j = 0; j < Integer.parseInt(dataSplit[5]); j++) {
				listeReservation = new Reservation[3];
				listeCategorieChambre[i - 1].getListeChambres()[j] = new Chambre(listeReservation, "libre");
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

	public void afficheEtatHotel() {

		for (int i = 0; i < listeCategorieChambre.length; i++) {
			listeCategorieChambre[i].afficheCategorieChambre();
			for (int j = 0; j < listeCategorieChambre[i].getListeChambres().length; j++) {
				if (listeCategorieChambre[i].getListeChambres()[j] != null) {
					boolean flagResa = false;
					listeCategorieChambre[i].getListeChambres()[j].afficherChambre();
//					for (int j2 = 0; j2 < listeCategorieChambre[i].getListeChambres()[j]
//							.getListeReservation().length; j2++) {
//
//						if (listeCategorieChambre[i].getListeChambres()[j].getListeReservation()[j2] != null) {
//							listeCategorieChambre[i].getListeChambres()[j].getListeReservation()[j2].afficherReservation();
//							flagResa = true;
//						}
//					}
					if (!flagResa) {
						System.out.println("Pas de rÃ©servation en cours");

					}
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
		for (int i = listeCategorieChambre.length - 1; i >= 0; i--) {
			if (listeCategorieChambre[i] != null) {
				for (int j = listeCategorieChambre[i].getListeChambres().length; j >= 0; j--) {
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

	public void reserverChambre() {
		System.out.println("Bienvenue dans la reservation de chambre");
		Client client = null;
		String str = null;
		Scanner saisieUtilisateur = new Scanner(System.in);
		// Passage dans le systeme d'inscription, si le client a déjà réservation, on
		// récupère ses informations
		client = Inscription.inscrire();
		System.out.println("Quel dates voulez-vous reserver ?");
		do {
			System.out.println("date de debut :(Respectez le format : jj/mm/aaaa)");
			String dateDebut = saisieUtilisateur.nextLine();
			dateDebutLD = LocalDate.parse(dateDebut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			// notre client doit entrer une date postérieur à aujourd'hui, sinon il
			// recommence sa saisie
		} while (dateDebutLD.isBefore(LocalDate.now()));

		do {
			System.out.println("date de fin :(Respectez le format : jj/mm/aaaa)");
			String dateFin = saisieUtilisateur.nextLine();
			dateFinLD = LocalDate.parse(dateFin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			// notre client doit entrer une date postérieur à aujourd'hui et la date de
			// début, sinon il recommence sa saisie
		} while ((dateFinLD.isBefore(LocalDate.now())) || (dateFinLD.isBefore(dateDebutLD)));

		int key = 0;
		// si la clé est -1 on quitte la réservation
		while (key != -1) {
			afficheListeCategorieChambre();
			// on donne le choix au client d'annuler sa demande réservation
			System.out.println("Quelle chambre souhaitez-vous prendre ? (pour annuler votre demande tapez -1)");
			key = saisieUtilisateur.nextInt();
			// les clés de 1 à 8 correspondent aux types de chambres
			if (key >= 1 && key <= 8) {

				System.out.println("Vous avez choisi : ");
				listeCategorieChambre[key - 1].afficheCategorieChambre();
				boolean flagResa = false;
				for (int i = 0; i < listeCategorieChambre[key - 1].getListeChambres().length; i++) {
					// la condition est valable si la chambre que nous proposons est libre et qu'on
					// a pas encore effectué la réservation
					if (isChambreLibre(listeCategorieChambre[key - 1].getListeChambres()[i]) && !(flagResa)) {
						System.out.println("Nous vous attribuons la chambre nÂ° "
								+ listeCategorieChambre[key - 1].getListeChambres()[i].getNumero() + "\n"

								+ "Le montant de votre rÃ©servation est de " + listeCategorieChambre[key - 1].getTarif()
										* ChronoUnit.DAYS.between(dateDebutLD, dateFinLD)
								+ " euros");
						System.out.println("Veuillez renseigner le numero de votre carte : ");
						String code = saisieUtilisateur.next();
						afficheFacture(listeCategorieChambre[key - 1], dateDebutLD, dateFinLD);

						for (int j = 0; j < listeCategorieChambre[key - 1].getListeChambres()[i]
								.getListeReservation().length; j++) {
							if (listeCategorieChambre[key - 1].getListeChambres()[i].getListeReservation()[j] == null) {
								listeCategorieChambre[key - 1].getListeChambres()[i]
										.getListeReservation()[j] = new Reservation(dateDebutLD, dateFinLD, client,
												(listeCategorieChambre[key - 1].getTarif()
														* ChronoUnit.DAYS.between(dateDebutLD, dateFinLD)));
								Chambre.nbReservee++;
								break;
							}
						}

						flagResa = true;
					}
				}
			}
			key = -1;
		}
	}

	public void afficheFacture(CategorieChambre catChambre, LocalDate dateDebutLD, LocalDate dateFinLD) {
		long nuite = ChronoUnit.DAYS.between(dateDebutLD, dateFinLD);
		float total = catChambre.getTarif() * nuite;
		System.out.println("                                AFPA-Hotel");
		System.out.println("\n");
		System.out.println("                               www.cda-JAVA.fr");
		System.out.println("\n");
		System.out.println("                               03 00 00 00 00");
		System.out.println("\n");
		System.out.print("Type de chambre");
        for (int i = 0; i < 15; i++) {
        	System.out.print(" ");
        }  
        System.out.print("nombre de nuités"); 
        for (int i = 0; i < 15; i++) {
        	System.out.print(" ");
        }                     
        System.out.print("Prix Unitaire");
        System.out.println("\n");
 
        System.out.print(catChambre.getNom());
        for (int i = 0; i < 15; i++) {
        	System.out.print(" ");
        } 
        System.out.print(nuite);
        for (int i = 0; i < 15; i++) {
        	System.out.print(" ");
        } 
        System.out.print(catChambre.getTarif());
        System.out.println("\n");
             
        System.out.println("Total :" + total);
	}

	public void libererChambre(String info) {

	}

}
