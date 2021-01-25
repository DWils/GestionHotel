package fr.afpa.main;

public class Hotel {

	private Chambre[] listeChambres;
	private float chiffreAffaire;
	
	public Hotel(Chambre[] ch , float ca) {
		listeChambres = ch;
		chiffreAffaire = ca;
	}
	
	public Hotel(Chambre[] ch) {
		listeChambres = ch;
		chiffreAffaire = (float)0;
	}
	
	public Hotel() {
		listeChambres = new Chambre[65];
		chiffreAffaire = (float)0;
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
		for (int i = 0; i < hotel.getListeChambres().length; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Chambre n° " 
								+ hotel.getListeChambres()[i].getNumero() + " " 
								+ hotel.getListeChambres()[i].getNom() + "\n "
								+ hotel.getListeChambres()[i].getOccupation() + "\n "
								+ "Superficie : " + hotel.getListeChambres()[i].getSuperficie() + "\n "
								+ "Vue : " + hotel.getListeChambres()[i].getVue() + "\n "
								+ "Liste options :");
			afficheOptions(listeChambres[i].getOptions());
			System.out.println("----------------------------------------------");
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
			System.out.println("Chambre n° " 
								+ hotel.getListeChambres()[i].getNumero() + " " 
								+ hotel.getListeChambres()[i].getNom() + "\n "
								+ hotel.getListeChambres()[i].getOccupation() + "\n "
								+ "Superficie : " + hotel.getListeChambres()[i].getSuperficie() + "\n "
								+ "Vue : " + hotel.getListeChambres()[i].getVue() + "\n "
								+ "Liste options :");
			afficheOptions(listeChambres[i].getOptions());
			if(hotel.getListeChambres()[i].getListeReservation()[0] != null) {
				for (int j = 0; j < hotel.getListeChambres()[i].getListeReservation().length; j++) {
					
				}
				System.out.println("----------------------------------------------");
				System.out.println("Pas de réservation en cours");
			}
			System.out.println("----------------------------------------------");
		}
	}
}
