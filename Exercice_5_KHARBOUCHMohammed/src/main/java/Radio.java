
public class Radio implements IConnectable {

	private int dureeConnexion;
	private int puissance;
	private Mode mode;

	public void demarrer() {
		System.out.println("Une radio " + this + " demarre");
	}

	public void setDureeConnexion(int dureeConnexion) {
		this.dureeConnexion = dureeConnexion;
	}

	public int getDureeConnexion() {
		return dureeConnexion;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

}
