package partie1;

public class ConsoleListener {

    Console cons;
    Controlleur ctrlr;

    public ConsoleListener() {
        this.cons = new Console();
        this.ctrlr = new Controlleur();
    }

    public void lancerIMusic() {
        int act;
        
        // récupère les évènements des actions de l'utilisateur et transmet des ordres au controleur
        do {
            this.cons.afficherMenu();
            act = this.cons.getActionMenu();
            switch (act) {
            case 1:
                String f = this.cons.chargerFichier();
                System.out.println("Chargement du fichier...");
                this.ctrlr.chargerFichier(f);
                break;
            case 2:
                System.out.println("Génération en cours...");
                this.ctrlr.generer();
                break;
            case 3:
                System.out.println("Lecture...");
                this.ctrlr.DemarrerLecture();
                break;
            case 4:
                System.out.println("Arrêt de la lecture");
                this.ctrlr.ArreterLecture();
                break;
            case 5:
            	this.ctrlr.quitterPlayer();
                this.cons.quitterConsole();
                break;
            default:
                System.out.println("404 Not Found - Ce choix n'existe pas.");
                break;
            }
        } while (act != 5);
    }
}
