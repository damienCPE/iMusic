package partie1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Console {

    public Console() {
        System.out.println("Bienvenue dans IMusic !");
    }

    public void lancerConsole() {
        this.afficherMenu();
    }

    // Affiche le menu console
    public void afficherMenu() {
        System.out.println("");
        System.out.println("    - 1 -   Charger un fichier");
        System.out.println("    - 2 -   Generer une piste");
        System.out.println("    - 3 -   Lecture");
        System.out.println("    - 4 -   Stop");
        System.out.println("    - 5 -   Quitter");
        System.out.println("");
        System.out.print("Faites votre choix : ");
    }

    // Lit l'entrée de la console et renvoi le numéro d'action
    public int getActionMenu() {
        String s = "0";
        int i = Integer.parseInt(s);
        try {
            BufferedReader bufferRead = new BufferedReader(
                    new InputStreamReader(System.in));
            s = bufferRead.readLine();
            if (s.equals("")) {
                i = 0;
            } else {
                if (Character.isDigit(s.charAt(0))) {
                    i = Integer.parseInt(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void quitterConsole() {
        System.out.println("Merci d'avoir utiliser IMusic !");
    }

    public String chargerFichier() {
        // Ne fonctionne pas sur Mac (Remplacer par return "./src/audio/pallet-town.mid";)
        JFileChooser chooser = new JFileChooser("./src/audio");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Fichier audio MIDI", "mid");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}
