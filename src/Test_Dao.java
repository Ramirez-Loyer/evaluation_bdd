

import java.util.Scanner;
import java.util.function.Predicate;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class Test_Dao {	
	
	//----------------test les méthodes Crud du composant d'accès aux données : ArticleDao
	
	public static void main(String[] args) {
		
	}
	private static void testArticleDao() {
		ArticleDao articleDao = new ArticleDao();
		
		//Afficher tous les articles
		for(Article article : articleDao.readAll()) {
			System.out.println(article);
		}	
		System.out.println();
		//Afficher un article à partir de son id
		Article article = articleDao.read(5);
		System.out.println(article);
		
		//Mise à jour de l'article
		article.setDescription("Batterie TopTop");
		articleDao.update(article);
		
		//Supprimer un article
		if(article != null)		
			articleDao.delete(article);
		
		//Insertion de l'article en base
		if(article != null)		
			articleDao.create(article);
		
		System.out.println();
		//Afficher tous les articles
		for(Article art : articleDao.readAll()) {
			System.out.println(art);
		}			
	}
}