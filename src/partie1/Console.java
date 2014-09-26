package partie1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public Console() {
        System.out.println("Bienvenue dans IMusic !");
    }

    public void lancerConsole() {
        this.afficherMenu();
    }

    public void afficherMenu() {
        System.out.println("");
        System.out.println("    - 1 -   Charger un fichier");
        System.out.println("    - 2 -   Lecture");
        System.out.println("    - 3 -   Stop");
        System.out.println("    - 4 -   Quitter");
        System.out.println("");
        System.out.print("Faites votre choix : ");
    }

    public int getActionMenu() {
        String s = "0";
        int i = Integer.parseInt(s);
        try {
            BufferedReader bufferRead = new BufferedReader(
                    new InputStreamReader(System.in));
            s = bufferRead.readLine();
            i = Integer.parseInt(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public void quitterConsole() {
        System.out.println("Merci d'utiliser IMusic !");
    }
}
