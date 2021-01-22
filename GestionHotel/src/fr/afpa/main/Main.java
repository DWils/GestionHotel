package fr.afpa.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] infosChambre = null;
		String[] listeOptions = null;
		Hotel hotel = new Hotel();
		Chambre chambre = new Chambre();
		int numeroChambre = 0;
		Inscription client1 = new Inscription();
		boolean gotaccount = false;
		boolean inscription = false;

		Scanner saisieUtilisateur = new Scanner(System.in);
		System.out.print("Saisir votre numero d'identification:");
		client1.setId(saisieUtilisateur.nextLine());
		String entrer = client1.getId();

		/*
		*/

		for (int i = 0; i < client1.getClientId().length; i++) {
			if (client1.getClientId()[i] == entrer) {
				gotaccount = true;
				System.out.print("Connect�!");
			}
			if (i == client1.getClientId().length - 1 && gotaccount == false) {
				inscription = true;
			}
		}

		for (int i = 0; i < client1.getClientId().length; i++) {
			if (client1.getClientId()[i] == null && inscription == true) {
				client1.getClientId()[i] = client1.getId();
				inscription = false;

			}

			String[] listeChambres = { "Type chambre;Taille;Vues;Occupation;tarif;Nombre;Options",
					"Chambre Vue Piscine;44 m�tres carr�s;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
					"Chambre Vue Jardin;44 m�tres carr�s;Jardin, For�t ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
					"Chambre Vue Oc�an;44 m�tres carr�s;Partielle Oc�an et For�t ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Chambre vue imprenable sur l'oc�an;44 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite CDA;82 m�tres carr�s;Oc�an et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite Executive;140 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;550;5;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite Ambassadeur;230 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;1650;7;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
					"Suite Royale;342  m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;2400;4;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

			for (int i2 = 1; i2 < listeChambres.length; i2++) {
				infosChambre = listeChambres[i2].split(";");
				for (int j = 0; j < infosChambre.length; j++) {
					for (int j2 = 0; j2 < Integer.parseInt(infosChambre[5]); j2++) {
						numeroChambre++;
						switch (j) {
						case 0:
							chambre.setNom(infosChambre[j]);
							break;
						case 1:
							chambre.setSuperficie(infosChambre[j]);
							break;
						case 2:
							chambre.setVue(infosChambre[j]);
						case 3:
							chambre.setOccupation(infosChambre[j]);
						case 4:
							chambre.setVue(infosChambre[j]);
						case 6:
							listeOptions = infosChambre[6].split("\\|");
							chambre.setOptions(listeOptions);
						default:
							break;
						}

					}

				}

			}
		}
	}
}