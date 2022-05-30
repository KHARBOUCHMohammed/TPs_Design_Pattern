public class AppliDomotique {

	public static void main(String[] args) {

		IGuirlande guirlande = new GuirlandeDeBase();
		guirlande.demarrer();
		guirlande.arret();
		System.out.println();

/*
//		GuirlandeCouleur
		System.out.println("On change les couleurs -> rouge et vert");
		guirlande = new GuirlandeCouleur(true, true, false, guirlande);
		guirlande.demarrer();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();

//		GuirlandeClignotante
		System.out.println("On démarre le clignotement");
		guirlande = new GuirlandeClignotante(1000, guirlande);
		guirlande.demarrer();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("On change les couleurs -> rouge et bleu");
		guirlande.setCouleur(true, false, true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("On change les couleurs -> vert et bleu");
		guirlande.setCouleur(false, true, true);
*/

	}

}
