
package fr.afpa.main;

public class Hotel {

	private Chambre[] listeChambres;
	private float chiffreAffaire;

	public Hotel(Chambre[] ch, float ca) {
		listeChambres = ch;
		chiffreAffaire = ca;
	}

	public Hotel(Chambre[] ch) {
		listeChambres = ch;
		chiffreAffaire = (float) 0;
	}

	public Hotel() {
		listeChambres = new Chambre[65];
		chiffreAffaire = (float) 0;
	}

	public Chambre[] getListeChambres() {
		return listeChambres;
	}

	public void setListeChambres(Chambre[] chambres) {
		listeChambres = chambres;
	}

	public float getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(float ca) {
		chiffreAffaire = ca;
	}

	public void afficheListeChambre(Hotel hotel) {
		Chambre chambre = new Chambre();
		int compteur = 0;
		for (int i = 0; i < hotel.getListeChambres().length; i++) {
			if (chambre.getNom() != hotel.getListeChambres()[i].getNom()) {
				compteur++;
				System.out.println("----------------------------------------------");
				System.out.println(compteur + "-Type de Chambre : " + hotel.getListeChambres()[i].getNom() + "\n "
						+ hotel.getListeChambres()[i].getOccupation() + "\n " + "Superficie : "
						+ hotel.getListeChambres()[i].getSuperficie() + "\n " + "Vue : "
						+ hotel.getListeChambres()[i].getVue() + "\n " + "Liste options :");
				afficheOptions(listeChambres[i].getOptions());
				System.out.println("----------------------------------------------");
			}
			chambre = hotel.getListeChambres()[i];
		}

	}

	public void afficheOptions(String[] options) {
		for (int i = 0; i < options.length; i++) {
			System.out.println("   " + options[i]);

		}
	}

	public void afficheEtatHotel(Hotel hotel) {
		for (int i = 0; i < hotel.getListeChambres().length; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Chambre n° " + hotel.getListeChambres()[i].getNumero() + " "
					+ hotel.getListeChambres()[i].getNom() + " " + hotel.getListeChambres()[i].getTarif() + " euros"
					+ "\n " + hotel.getListeChambres()[i].getOccupation() + "\n " + "Superficie : "
					+ hotel.getListeChambres()[i].getSuperficie() + "\n " + "Vue : "
					+ hotel.getListeChambres()[i].getVue() + "\n " + "Liste options :");
			afficheOptions(listeChambres[i].getOptions());
			if (hotel.getListeChambres()[i].getListeReservation()[0] != null) {
				for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
					System.out.println("----------------------------------------------");
					System.out.println(hotel.getListeChambres()[i].getListeReservation()[i].getClient().getNom() + " "
							+ hotel.getListeChambres()[i].getListeReservation()[i].getDateDebut() + " - "
							+ hotel.getListeChambres()[i].getListeReservation()[i].getDateFin());
				}
			} else {
				System.out.println("----------------------------------------------");
				System.out.println("Pas de réservation en cours");
			}
			System.out.println("----------------------------------------------");
		}
	}

	public void afficherNbResa() {
		Chambre ch = new Chambre();
		System.out.println(ch.getReservee());
	}

	public void afficherNbLibre() {
		Chambre ch = new Chambre();
		System.out.println(listeChambres.length - ch.getReservee() - ch.getOcuppee());
	}

	public void afficherPremiereChambre(Hotel hotel) {

		for (int i = 0; i < hotel.listeChambres.length; i++) {
			int compteur = 0;
			for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
				if (hotel.getListeChambres()[i].getListeReservation()[j] == null) {
					compteur++;
				}
			}
			if (compteur == 3) {
				System.out.println(hotel.getListeChambres()[i]);
			}

		}
	}

	public void afficherDerniereChambre(Hotel hotel) {
		for (int i = hotel.listeChambres.length - 1; i <= 0; i--) {
			int compteur = 0;
			for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
				if (hotel.getListeChambres()[i].getListeReservation()[j] == null) {
					compteur++;
				}
			}
			if (compteur == 3) {
				System.out.println(hotel.getListeChambres()[i]);
			}

		}

	}

	public void reserverChambre(Hotel hotel) {
		System.out.println("Bienvenue dans la réservation de chambre");
		Client client = null;
		Inscription inscription = new Inscription();
		client = inscription.inscrire();
		int key = 0;
		while(key != -1) {
			afficheListeChambre(hotel);
			System.out.println("Quelle chambre souhaitez-vous prendre ? (en valeur numerique svp)");
		}
//		int key = 0;
//		switch()
		
		
		
	}

}
