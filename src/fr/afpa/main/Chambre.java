package fr.afpa.main;

import java.time.LocalDate;

public class Chambre {
	private int numero;
	private String nom;
	private double tarif;
	private String[] options;
	private boolean libre;
	
	public Chambre(int num , String n , double t , String[] opts ) {
		numero = num;
		nom = n;
		tarif = t;
		options = opts;
		libre = true;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getTarif() {
		return tarif;
	}
	
	public String[] getOptions () {
		return options;
	}
	
	public void setNumero(int num) {
		numero = num;
	}
	
	public void setNom(String n) {
		nom = n;
	}
	
	public void setTarif(double tf) {
		tarif = tf;
	}
	
	public void setOptions(String[] opts) {
		options = opts;
	}
	
	public void isLibre(boolean l) {
		libre = l;
	}
	
}
