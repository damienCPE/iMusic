package partie1.controleur;

import partie1.vue.Console;

public class ConsoleListener {

    Console cons;
    Controlleur ctrlr;

    // Constructeur
    public ConsoleListener() {
        this.cons = new Console();
        this.ctrlr = new Controlleur();
    }

    // Lance le programme IMusic Console
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
                if(f != "")
                	this.ctrlr.chargerFichier(f);
                else
                	System.out.println("Pas de fichier selectionné");
                break;
            case 2:
                System.out.println("G��n��ration en cours...");
                this.ctrlr.generer();
                break;
            case 3:
                System.out.println("Lecture...");
                this.ctrlr.DemarrerLecture();
                break;
            case 4:
                System.out.println("Arr��t de la lecture");
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
        // Sortie du menu �� r��ception d'un 5
        } while (act != 5);
    }
}
