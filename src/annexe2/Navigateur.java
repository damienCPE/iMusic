package annexe2;
/**
 * @author Kathy Sierra, Bert Bates : "Java Tete la Premiere"  * 
 * Mise en forme des commentaires Franeoise PERRIN
 */

import java.awt.*;
import javax.swing.*;
import java.rmi.*;

import java.awt.event.*;


public class Navigateur {

    JPanel panneau;
    JComboBox listeServices;
    ServeurServices serveur;


    public void construireIHM() {
        JFrame cadre = new JFrame("Navigateur RMI");
        panneau = new JPanel();
        cadre.getContentPane().add(BorderLayout.CENTER, panneau);

        Object[] services = getListeServices();

        listeServices = new JComboBox(services);
        cadre.getContentPane().add(BorderLayout.NORTH, listeServices);

        listeServices.addActionListener(new EcouteMaListe());

        cadre.setSize(500,500);
        cadre.setVisible(true);

    }

    void chargerService(Object serviceChoisi) {
        try {
            Service svc = serveur.getService(serviceChoisi);

            panneau.removeAll();
            panneau.add(svc.getIHM());
            panneau.validate();
            panneau.repaint();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    /*
     * Le client doit acceder e l'objet souche, 
     * puisque c'est sur cette entite qu'il va appeler les methodes.
     * 
     * le client consulte le registre RMI : Naming.lookup("rmi://127.0.0.1/ServeurServices");
     * "ServeurServices" est le nom sous lequel le service a ete enregistre
     * 
     * le registre RMI retourne l'objet souche comme valeur de retour de la methode lookup()
     * et RMI le deserialise automatiquement. la classe de la souche (generee) doit etre sur le client.
     * 
     * le client invoque une methode sur la souche comme si elle etait le service reel :
     * "serveur.getListeServices()"
     */
    Object[] getListeServices() {

        Object obj = null;
        Object[] services = null;
        
        try {
            
            //obj = Naming.lookup("rmi://127.0.0.1/ServeurServices");
            obj = Naming.lookup("ServeurServices");
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        
        serveur = (ServeurServices) obj;


        try {

            services = serveur.getListeServices();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return services;

    }

    class EcouteMaListe implements ActionListener {
        public void actionPerformed(ActionEvent ev) {

            // acceder au service selectionne

            Object selection =  listeServices.getSelectedItem();
            chargerService(selection);
        }
    }

    public static void main(String[] args) {
        new Navigateur().construireIHM();
    }
}