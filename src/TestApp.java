
import java.util.Scanner;
import fr.fms.authentication.Authenticate;
import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;

/**
 * Application console de vente d'articles en base permettant d'exploiter une couche métier/dao pour créer un panier en ajoutant ou retirant des articles
 * puis passer commande à tout instant, cela génère une commande en base avec tous les éléments associés
 * @author El babili - 2023
 * 
 */

public class TestApp {
	
	private static Scanner scan = new Scanner(System.in); 
	private static IBusinessImpl business = new IBusinessImpl();
	private static Authenticate authenticate = new Authenticate();
	
	
	public static void main(String[] args) {
		
		System.out.println("Bonjour et bienvenu dans mon site, voici la liste de formations : \n");
		
	
	
	}
}
