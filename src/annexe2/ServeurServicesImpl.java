package annexe2;
/**
 * @author Kathy Sierra, Bert Bates : "Java Tete la Premiere" 
 * Mise en forme des commentaires Franeoise PERRIN
 */

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;


/*
 * Pour pouvoir fonctionner comme service distant, 
 * votre objet doit etendre "UnicastRemoteObject"
 * et implementer votre interface distante
 */
public class ServeurServicesImpl extends UnicastRemoteObject implements ServeurServices  {

    HashMap <String, Service> listeServices;




    public ServeurServicesImpl() throws RemoteException {
       //installer et demarrer les services
       installerServices();
    }

    private void installerServices() {
       listeServices = new HashMap<String, Service>();
       /*  ------  Autres services possibles    --------
       listeServices.put("Jouer aux des", new ServiceDes());
       listeServices.put("Quel jour ?", new ServiceQuelJour());
       */
       listeServices.put("Video musique", new ServiceMusique());
    }



    public Object[] getListeServices() {
       System.out.println("e distance");
       return listeServices.keySet().toArray();

    }


    public Service getService(Object cleService) throws RemoteException {
       Service leService = (Service) listeServices.get(cleService);
       return leService;
    }


    public static void main (String[] args) {
        /*
         * les lignes suivantes permettent de lancer le registre rmi
         * par programme 
         */
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("Le RMI registry est pret.");
            } catch (Exception e) {
            System.out.println("Le RMI registry n'a pas demmare correctement.");
            }
        /*
         * Il faut enregistrer le service (le lier au registre RMI) : 
         * c'est en realite la souche que RMI place dans le registre
         * puisque c'est d'elle dont les clients ont vraiment besoin.
         * Donner au service un nom permettra aux clients de le chercher dans le registre
         * le registre doit deje s'executer sinon cette ligne echoue "Naming.rebind..."
         * 
         */
       try {
           
         Naming.rebind("ServeurServices", new ServeurServicesImpl());
       } catch(Exception ex) { }
       System.out.println("Le service distant s'execute");
    }
}