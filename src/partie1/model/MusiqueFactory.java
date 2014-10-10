package partie1.model;

import partie3.model.MusiqueFichierServer;

public class MusiqueFactory {
	
    public MusiqueFactory(){}
    
    // Creer l'objet musique en fonction du type et du chemin du fichier passe en parametre
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
	    case SERVER:
	        musique = new MusiqueFichierServer(s);
	        break;
	    }
        return musique;
    }
	
}
