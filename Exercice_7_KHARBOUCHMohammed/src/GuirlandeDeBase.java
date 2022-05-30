
public class GuirlandeDeBase implements IConnectable, IGuirlande {
	
	boolean rouge = true, vert = true, bleu = true;
	
	public void setCouleur(boolean rouge, boolean vert, boolean bleu) {
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
	}
	
	public void demarrer()
	{
		System.out.println("La guirlande " + toString() + " s'allume avec les couleurs" + (rouge? " rouge" : "") + (vert ? ((rouge? " et" : "") + " vert") : "") + (bleu ? " et bleu " : ""));
	}
	
	public void arret ()
		{
			System.out.println("La guirlande " + toString() + " s'éteint");
		}
}
