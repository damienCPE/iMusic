package annexe2;


/**
 * @author Kathy Sierra, Bert Bates : "Java T�te la Premi�re"  * 
 * Mise en forme des commentaires Fran�oise PERRIN
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/* Votre interface doit indiquer qu'elle sert aux appels distants
 * avec "extends Remote"
 * 
 * Chaque appel de m�thode distante est consid�r� comme risqu� :
 * d�clarer "RemoteException" dans chaque m�thode oblige le client
 * � faire attention et � reconnaitre qu'un incident peut se produire
 * 
 * Comme le serveur va utiliser le r�seau pour renvoyer les valeurs de retour 
 * et r�cup�rer les valeurs des arguments des m�thodes
 * il faut v�rifier que argument et types de retour sont s�rialisables
 */
public interface ServeurServices extends Remote {

    Object[] getListeServices() throws RemoteException;

    Service getService(Object cleService) throws RemoteException;
}
