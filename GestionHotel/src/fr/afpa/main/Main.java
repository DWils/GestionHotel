package fr.afpa.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Hotel hotel = new Hotel();
		String[] dataChambres = { "Type chambre;Taille;Vues;Occupation;tarif;Nombre;Options",
				"Chambre Vue Piscine;44 metres carres;Piscine Centrale;2 adultes et 2 enfants de moins de 12 ans;300;7;Fer et planche a  repasser sur demande|Telephone |Television par cÃ¢ble|Climatisation|Bouilloire Ã©lectrique|Concierge 24h/24",
				"Chambre Vue Jardin;44 metres carres;Jardin, ForÃªt ou Golf;2 adultes et 2 enfants de moins de 12 ans;314;12;Fer et planche a  repasser sur demande|Telephone |Television par cable|Climatisation|Bouilloire Ã©lectrique|Concierge 24h/24",
				"Chambre Vue Ocean;44 metres carres;Partielle Ocean et Foret ou Golf;2 adultes et 2 enfants de moins de 12 ans;350;8;Fer et planche a  repasser sur demande|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cÃ¢ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Chambre vue imprenable sur l'ocean;44 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;350;10;Fer et planche Ã  repasser sur demande|Telephone |Acces Internet haut debit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cÃ¢ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite CDA;82 metres carres;Ocean et Golf;2 adultes et 2 enfants de moins de 12 ans;450;12;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|Television par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Executive;140 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;550;5;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Ambassadeur;230 metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;1650;7;Seche-cheveux|Coffre-fort dans la chambre|Minibar|Telephone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|TÃ©lÃ©vision par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
				"Suite Royale;342  metres carres;Ocean;2 adultes et 2 enfants de moins de 12 ans;2400;4;Seche-cheveux|Coffre-fort dans la chambre|Minibar|TÃ©lÃ©phone |Acces Internet haut dÃ©bit sans fil|Lecteur DVD sur demande|Television par cable|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

		hotel.readDataChambre(dataChambres);

		Inscription.login(hotel);

	}

}
