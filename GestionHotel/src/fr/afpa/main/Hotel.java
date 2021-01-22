package fr.afpa.main;

public class Hotel {

	private Chambre[] chambres;
	private float chiffreAffaire;
	
	public Hotel(Chambre[] ch , float ca) {
		chambres = ch;
		chiffreAffaire = ca;
	}
	
	public Hotel() {
		
	}

	public Chambre[] getChambres() {
		return chambres;
	}
	public void setChambres(Chambre[] chambres) {
		this.chambres = chambres;
	}
	public float getChiffreAffaire() {
		return chiffreAffaire;
	}
	public void setChiffreAffaire(float chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}
}
