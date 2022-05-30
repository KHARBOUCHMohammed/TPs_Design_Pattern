public class ThreadClignotement extends Thread {
    private GuirlandeClignotante g;
    private long delai;

    public ThreadClignotement(long delai, GuirlandeClignotante g) {
        this.delai = delai;
        this.g = g;
    }

/*    public void run() {
        while(true) {
            try {
                g.demarrer();
                Thread.sleep(delai);
                g.arret();
                Thread.sleep(delai);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
