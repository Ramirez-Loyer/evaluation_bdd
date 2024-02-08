package fr.fms.entities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestJdbc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			
	}	
		private static void testArticle() {
			Article article = new Article();
			
			//Afficher tous les articles
			for(Article article : article.readAll()) {
				System.out.println(article);
			}	
			System.out.println();
			//Afficher un article à partir de son id
			Article article = article.read(5);
			System.out.println(article);
			
			//Mise à jour de l'article
			article.setDescription("bla");
			article.update(article);
			
			//Supprimer un article
			if(article != null)		
				article.delete(article);
			
			//Insertion de l'article en base
			if(article != null)		
				article.create(article);
			
			System.out.println();
			//Afficher tous les articles
			for(Article art : article.readAll()) {
				System.out.println(art);
			}			
		}
	

} 

	