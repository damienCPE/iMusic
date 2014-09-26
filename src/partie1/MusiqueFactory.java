package partie1;

public class MusiqueFactory {
	
    public MusiqueFactory(){
        
    }
    
    public Musique creationMusique(TypeMusique type, String s){
        Musique musique = null;
        switch (type) {
        
        case FICHIER:
            if(s.compareTo("") == 0){
                return null;
            }
            musique = new MusiqueFichier(s);
            break;
        case GENEREE:
            musique = new MusiqueGeneree();
            break;
        }
        return musique;
    }
	
}
