package annexe2;


/**
 * @author Kathy Sierra, Bert Bates : "Java Tete la Premiere"  * 
 * Mise en forme des commentaires Franeoise PERRIN
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/* Votre interface doit indiquer qu'elle sert aux appels distants
 * avec "extends Remote"
 * 
 * Chaque appel de methode distante est considere comme risque :
 * declarer "RemoteException" dans chaque methode oblige le client
 * e faire attention et e reconnaitre qu'un incident peut se produire
 * 
 * Comme le serveur va utiliser le reseau pour renvoyer les valeurs de retour 
 * et recuperer les valeurs des arguments des methodes
 * il faut verifier que argument et types de retour sont serialisables
 */
public interface ServeurServices extends Remote {

    Object[] getListeServices() throws RemoteException;

    Service getService(Object cleService) throws RemoteException;
}
