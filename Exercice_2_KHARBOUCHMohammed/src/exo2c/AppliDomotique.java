import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppliDomotique {

	static ArrayList<IConnectable> lesConnectes=new ArrayList<IConnectable>();
	
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
	
	public static void main(String[] args) {
		System.out.println("Exo2c");
		String classeEffective = new String();
		while (!(classeEffective = saisieNomClasse()).isEmpty()){
			connecter(classeEffective);
		}
		System.out.println(lesConnectes);
	}

}
