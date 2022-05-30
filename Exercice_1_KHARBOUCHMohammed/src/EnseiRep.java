public class EnseiRep extends Enseignant {

    private  static Enseignant instanceUnique = null ;

    public static Enseignant getRep(){

        if(instanceUnique==null){
            instanceUnique = new Enseignant();
        }
        return instanceUnique;
    }

}
