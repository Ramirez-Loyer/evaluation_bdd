package fr.fms.entities;
import java.sql.Connection;

public class Article {
	private int id;
	private String nameArticle;
	private String description;
	private int durationDays;
	private String modality;
	private double price;
	private int category;
	private int quantity=1;
	
	public static final int MAX_STRING_LENGTH = 20;
	
	public Article(int id, String nameArticle, String description, int durationDays, String modality, double price, int category) {
		this.id = id;
		this.nameArticle = nameArticle;
		this.description = description;
		this.durationDays = durationDays;
		this.modality = modality;
		this.price = price;
		//this.category = category;
	}
	
	public Article(int id, String nameArticle, String description, int durationDays, String modality, String brand, double price) {
		this.id = id;
		this.description = description;
		this.durationDays = durationDays;
		this.modality = modality;
		this.price = price;
	}
	
	public Article(String nameArticle, String description, int durationDays, String modality, String brand, double price) {
		this.id = 0;
		this.description = description;
		this.durationDays = durationDays;
		this.modality = modality;
		this.price = price;
	}	

	@Override
	public String toString() {
		return centerString(String.valueOf(id)) + centerString(nameArticle) + centerString(description) + centerString(String.valueOf((durationDays)) + centerString(modality) + centerString(String.valueOf(price)));
	}
	
	public static String centerString(String str) {
		if(str.length() >= MAX_STRING_LENGTH) return str;
		String dest = "                    ";
		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameArticle() {
		return nameArticle;
	}

	public void setNameArticle(String nameArticle) {
		this.nameArticle = nameArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}