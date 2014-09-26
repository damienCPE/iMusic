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
        do {
            this.cons.afficherMenu();
            act = this.cons.getActionMenu();
            System.out.println("Ici1");
            switch (act) {
            case 1:
                // System.out.println("Choix 1 - Load");
                System.out.println("Ici2");
                String f = this.cons.chargerFichier();
                System.out.println("Chargement du fichier...");
                this.ctrlr.chargerFichier(f);
                System.out.println("Ici3");
                break;
            case 2:
                System.out.println("Choix 2 - Generer");
                this.ctrlr.generer();
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
