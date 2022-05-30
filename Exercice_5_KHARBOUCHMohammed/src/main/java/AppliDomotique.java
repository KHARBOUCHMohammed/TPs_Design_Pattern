import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class AppliDomotique {
	
	static ArrayList<IConnectable> lesConnectes=new ArrayList<>();

	public static String saisieNomClasse() {
		String nomClasse = new String();
		System.out.println("Taper Entrée pour finir ou le nom de la classe de l'objet à connecter");
		BufferedReader in=new BufferedReader(new InputStreamReader( System.in ));
		try {
			nomClasse = in.readLine();
		}
		catch (IOException e) {}
		return nomClasse;
	}

	public static void connecter(String nomClasse) {
		IFabriqueConnectable fabrique = new FabriqueConnectable();
		IConnectable c = fabrique.creer(nomClasse);
		if (c != null) {
			lesConnectes.add(c);
			System.out.println("Ajout d'un nouveau objet " + c);
		}
	}

	private static void definirModeFonctionnement(IConsommable c) {
		BufferedReader in = new BufferedReader(new InputStreamReader( System.in ));
		System.out.println("Quel est le mode de fonctionnement énergétique de l'objet " + c + " (v(eille), n(ormal) ou h(aut)) ?");
		try {
			String mode=in.readLine();
			if (mode.isEmpty())
				mode = "NORMAL";
			switch (mode.charAt(0)) {
	            case 'v':
	            	c.setMode(Mode.VEILLE);
	                break;
	            case 'n':
	            	c.setMode(Mode.NORMAL);
	                break;
	            case 'h':
	            	c.setMode(Mode.HAUT);
	                break;
			}
		}
		catch (IOException e) {}
	}

	private static void definirdureeConnexion(IConsommable c) {
		BufferedReader in=new BufferedReader(new InputStreamReader( System.in ));
		System.out.println("Quelle est la durée de connexion de l'objet " + c + " (en minutes) ?");
		try {
			String s = in.readLine();
			if (s.isEmpty())
				c.setDureeConnexion(10);
			else
				c.setDureeConnexion(Integer.valueOf(s));
		}
		catch (IOException e) {}
	}

	private static void definirPuissance(IConsommable c) {
		BufferedReader in=new BufferedReader(new InputStreamReader( System.in ));
		System.out.println("Quelle est la puissance de l'objet " + c + " (en Watt) ?");
		try {
			String s = in.readLine();
			if (s.isEmpty())
				c.setPuissance(10);
			else
				c.setPuissance(Integer.valueOf(s));
		}
		catch (IOException e) {}
	}

	public static void main(String[] args) {
		String classeEffective;
		while (!(classeEffective = saisieNomClasse()).isEmpty()){
			connecter(classeEffective);
		}
		repartirConsommation();
	}

	private static void repartirConsommation() {
		String critereRepartition = choisirCritereRepartition();
		affecterValeursCritere(critereRepartition);
		repartirConsoSelonCritere(critereRepartition);
	}

	private static String choisirCritereRepartition() {
		String critereRepartition = "d";
		BufferedReader in = new BufferedReader(new InputStreamReader( System.in ));
		System.out.println("Sur quel critère s'effectue la répartition de consommation ? (d(urée), p(uissance), m(ode) ");
		try {
			critereRepartition = (in.readLine());
			if (critereRepartition.isEmpty()) critereRepartition = "d";
		} catch (IOException e) {}
		return critereRepartition;
	}

	private static void affecterValeursCritere(String critereRepartition) {
		switch(critereRepartition.charAt(0)) {
			case 'd':
				affecterDurees();
				break;
			case 'p':
				affecterPuissances();
				break;
			case 'm':
				affecterModes();
				break;
		}
	}

	private static void repartirConsoSelonCritere(String critereRepartition) {
		// A completer
	}

	private static int saisirCoeff() {
		BufferedReader in = new BufferedReader(new InputStreamReader( System.in ));
		System.out.println("Quel est le coefficient à appliquer ? ");
		try {
			String coeff = in.readLine();
			if (coeff.isEmpty()) return 10;
			else return Integer.valueOf(coeff);
		} catch (IOException e) {
			return 10;
		}
	}

	private static void affecterModes() {
		for (IConsommable c : lesConnectes){
			definirModeFonctionnement(c);
		}		
	}

	private static void affecterPuissances() {
		for (IConsommable c : lesConnectes){
			definirPuissance(c);
		}
	}

	private static void affecterDurees() {
		for (IConsommable c : lesConnectes){
			definirdureeConnexion(c);
		}		
	}		

	private static TreeMap<Mode, Double> TauxMode;
	
    static {
    	TauxMode = new TreeMap<>();
    	TauxMode.put(Mode.VEILLE, 10.);
    	TauxMode.put(Mode.NORMAL, 30.0);
    	TauxMode.put(Mode.HAUT, 60.0);
	}
}
