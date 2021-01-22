package fr.afpa.main;

public class TestSplit {

	public static void main(String[] args) {
		String [] infosChambre = null;
		String [] listeOptions = null;
		
		String [] listeChambres = {
	            "Type chambre;Taille;Vues;Occupation;tarif;Nombre;Options",
	            "Chambre Vue Piscine;44 m�tres carr�s;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
	            "Chambre Vue Jardin;44 m�tres carr�s;Jardin, For�t ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
	            "Chambre Vue Oc�an;44 m�tres carr�s;Partielle Oc�an et For�t ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
	            "Chambre vue imprenable sur l'oc�an;44 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
	            "Suite CDA;82 m�tres carr�s;Oc�an et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
	            "Suite Executive;140 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;550;5;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
	            "Suite Ambassadeur;230 m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;1650;7;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
	            "Suite Royale;342  m�tres carr�s;Oc�an;2 adultes et 2 enfants de moins de 12 ans;2400;4;S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24"
	            };
		
		for (int i = 1; i < listeChambres.length; i++) {
			infosChambre = listeChambres[i].split(";");
			for (int j = 0; j < infosChambre.length; j++) {
				if(j == 6) {
					System.out.println("--- Options ---");
					listeOptions = infosChambre[6].split("\\|");
					for (int j2 = 0; j2 < listeOptions.length; j2++) {
						System.out.println(listeOptions[j2]);
					}
					System.out.println("---------------");
					 
				}else {
					System.out.println(infosChambre[j]);
				}
			}
			
		}

	}

}
