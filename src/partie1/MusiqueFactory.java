package partie1;

public class MusiqueFactory {
	
	public Musique createMusique(TypeMusique type){
		Musique musique = null;
		switch (type) {
		
		case FICHIER:
			musique = new MusiqueFichier();
			break;
		case GENEREE:
			musique = new MusiqueGeneree();
			break;
		}
		return musique;
	}
	
}
