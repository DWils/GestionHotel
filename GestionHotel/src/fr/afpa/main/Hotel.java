package fr.afpa.main;

public class Hotel {

	private Chambre[] listeChambres;
	private float chiffreAffaire;
	
	public Hotel(Chambre[] ch , float ca) {
		listeChambres = ch;
		chiffreAffaire = ca;
	}
	
	public Hotel() {
		
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
}
