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

	public Chambre[] getChambres() {
		return listeChambres;
	}
	public void setChambres(Chambre[] chambres) {
		listeChambres = chambres;
	}
	public float getChiffreAffaire() {
		return chiffreAffaire;
	}
	public void setChiffreAffaire(float ca) {
		chiffreAffaire = ca;
	}

	public void afficheListeChambre(Hotel hotel) {
		for (int i = 0; i < listeChambres.length; i++) {
			System.out.println("----------------------------------------------");
			System.out.println("Chambre n° " 
								+ listeChambres[i].getNumero() + " " 
								+ listeChambres[i].getNom() + "\n "
								+ listeChambres[i].getOccupation() + "\n "
								+ "Superficie : " + listeChambres[i].getSuperficie() + "\n "
								+ "Vue : " + listeChambres[i].getVue() + "\n "
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
}
