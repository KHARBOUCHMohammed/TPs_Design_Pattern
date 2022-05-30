public class EtudiantRep extends Etudiant {


    private  static Etudiant instanceUnique = null ;

    public static Etudiant getRep(){

        if(instanceUnique==null){
            instanceUnique = new Etudiant();
        }
        return instanceUnique;
    }

}


