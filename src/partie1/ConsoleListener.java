package partie1;

public class ConsoleListener {

    Console cons;

    public static void main(String[] args) {
        ConsoleListener consList = new ConsoleListener();
        consList.lancerIMusic();
    }

    public ConsoleListener() {
        this.cons = new Console();
    }

    public void lancerIMusic() {
        int act;
        this.cons.afficherMenu();
        do {
            act = this.cons.getActionMenu();
            switch (act) {
            case 1:
                System.out.println("Choix 1 - Load");
                break;
            case 2:
                System.out.println("Choix 2 - Play");
                break;
            case 3:
                System.out.println("Choix 3 - Stop");
                break;
            case 4:
                this.cons.quitterConsole();
                break;
            default:
                System.out.println("404 Not Found - Ce choix n'existe pas.");
                this.cons.afficherMenu();
                break;
            }
        } while (act != 4);
    }
}
