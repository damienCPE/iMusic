package partie1;

public class ConsoleListener {

    Console cons;
    Controlleur ctrlr;

    public static void main(String[] args) {
        ConsoleListener consList = new ConsoleListener();
        consList.lancerIMusic();
    }

    public ConsoleListener() {
        this.cons = new Console();
        this.ctrlr = new Controlleur();
    }

    public void lancerIMusic() {
        int act;
        this.cons.afficherMenu();
        do {
            act = this.cons.getActionMenu();
            switch (act) {
            case 1:
                // System.out.println("Choix 1 - Load");
                String f = this.cons.chargerFichier();
                System.out.println("Chargement du fichier...");
                this.ctrlr.chargerFichier(f);
                break;
            case 2:
                //System.out.println("Choix 2 - Generer");
                //this.ctrlr.genererFichier();
                break;
            case 3:
                System.out.println("Choix 3 - Play");
                this.ctrlr.DemarrerLecture();
                break;
            case 4:
                System.out.println("Choix 4 - Stop");
                this.ctrlr.ArreterLecture();
                break;
            case 5:
                this.cons.quitterConsole();
                break;
            default:
                System.out.println("404 Not Found - Ce choix n'existe pas.");
                this.cons.afficherMenu();
                break;
            }
        } while (act != 5);
    }
}
