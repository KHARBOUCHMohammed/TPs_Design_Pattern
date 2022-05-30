package exo2a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppliDomotique {
	
	public static int saisieNomClasse() {
		int choix = 1;
		System.out.println("Taper 0 pour finir, 1 pour connecter une cafetière et 2 pour une radio");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			choix = Integer.parseInt(in.readLine());
		}
		catch (IOException e) {}
		return choix;
	}

	public static void connecter(int type) {
		// A compléter
	}
	
	public static void main(String[] args) {
		int type = 0;
		while ((type = saisieNomClasse()) != 0){
			// A compléter
		}
		// A compléter pour afficher les éléments connectés
	}

}
