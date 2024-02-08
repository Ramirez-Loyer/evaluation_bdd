
package fr.fms.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	public boolean createStatement(Article obj) {
		try (Statement statement = connection.createStatement()){
			String str = "INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price)"
					+ " VALUES ('" + obj.getNameArticle() + obj.getDescription()+"' + obj.DurationDays()  ,'" + obj.getModality() + "',"+ obj.getPrice() +" );";			
			int row = statement.executeUpdate(str);			if(row == 1)		return true;
		} catch (SQLException e) {
			e.printStackTrace();
			//logger.log(Level.SEVERE,"pb sql sur la création d'un article");
		} 		
		return false;
	}
	public ArticleDao() {
		//logger.info("Here we Go !");
	}

	//Méthode qui crée un article en base sans prendre en compte l'id 

	@Override
	public boolean create(Article obj) {
		String str = "INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price, IdCategory) VALUES (?,?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getNameArticle());
			ps.setString(2, obj.getDescription());
			ps.setInt (3, obj.getDurationDays());
			ps.setString(4, obj.getModality());
			ps.setDouble(5, obj.getPrice());	
			ps.setInt(6, obj.getCategory());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'un article " + e.getMessage());
		} 	
		return false;
	}

	/**
	 * Méthode qui renvoi toutes les infos d'un article à partir de son id s'il existe dans la table T_Articles
	 * @param id de l'article 
	 * @return article si trouvé, null sinon
	 */
	@Override
	public Article read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Articles where IdArticle=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Article (rs.getInt(1) , rs.getString(2) , rs.getString(3), rs.getInt(4), rs.getString(5) , rs.getDouble(6), rs.getInt(7));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture d'un article " + e.getMessage());
		} 	
		return null;
	}


	@Override
	public boolean update(Article obj) {
		String str = "UPDATE T_Articles set NameArticle=?, Description=? , DurationDays=?, Modality=? , UnitaryPrice=? , IdCategory=? where idArticle=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){				
			ps.setString(1, obj.getNameArticle());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDurationDays());
			ps.setString(4, obj.getModality());
			ps.setDouble(5, obj.getPrice());
			ps.setInt(6, obj.getCategory());
			ps.setInt(7, obj.getId());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la mise à jour d'un article " + e.getMessage());
		} 	
		return false;
	}


	//Méthode qui supprime un article à partir de son id 

	@Override
	public boolean delete(Article obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Articles where IdArticle=" + obj.getId() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la suppression d'un article " + e.getMessage());
		} 	
		return false;
	}


	//Méthode qui renvoi tous les articles de la table T_Articles

	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 	
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsNameArticle = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsDurationDays = resultSet.getInt(4);
					String rsModality = resultSet.getString(5);
					double rsPrice = resultSet.getDouble(6);		
					articles.add((new Article(rsId, rsNameArticle, rsDescription, rsDurationDays, rsModality, rsPrice)));							
				}
			}

		} catch (SQLException e) {
			logger.severe("pb sql sur revoi de tous articles " + e.getMessage());
		}	
		return articles;
	}


	//----Méthode qui renvoi tous les articles d'une catégorie

	public ArrayList<Article> readAllByCat(int id) {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsNameArticle = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsDurationDays = resultSet.getInt(4);
					String rsModality = resultSet.getString(5);
					double rsPrice = resultSet.getDouble(6);		
					articles.add((new Article(rsId, rsNameArticle, rsDescription, rsDurationDays, rsModality, rsPrice)));								
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur renvoir des articles d'une catégorie " + e.getMessage());
		}		
		return  articles;
	}
}

