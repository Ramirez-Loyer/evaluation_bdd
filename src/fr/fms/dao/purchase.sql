--Reconstruction de la base de données  

DROP DATABASE IF EXISTS Purchase;
---Créatiuon d'un utilisateur des droits restreint---
--CREATE USER 'aleracrespo@gmail.com' IDENTIFIED BY 'Alejandra';
CREATE DATABASE Purchase;
--GRANT ALL PRIVILEGES ON Purchase.* TO 'aleracrespo@gmail.com'
--show GRANTS FOR 'aleracrespo@gmail.com';	
USE Purchase;




--- table des formations en vente----

CREATE TABLE T_Articles (
	IdArticle				int(4)		PRIMARY KEY AUTO_INCREMENT,
	NameArticle	varchar(30) NOT NULL,
	Description		varchar(100)	NOT NULL,
	DurationDays	int (4) NOT NULL, 
	Modality		varchar(30) NOT NULL,
	Price			float(8) 		NOT NULL
) ENGINE = InnoDB;

	
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Java", "Java SE 8 : Syntaxe & Poo", 60, "Présentiel", "499.90");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Java Avancé", "Exceptions, Fichiers, Jdbc, Threads", 45, "Présentiel", "399.90");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Spring", "Spring Core/MVC/Security", 15, "Présentiel", "299.99");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Php frameworks", "Symphony", 10, "Distantiel", "195.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("C#", "DotNet Core", 10, "Distantiel", "250.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Git & GitHub", "Installer et configurer Git, Dêpot local/distant", 5, "Distantiel", "100.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Algorithmique", "Variables, Types, Conditionnels, Boucles, Arrays", 32, "Présentiel", "265.50");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("BDD avec SQL", "SGBD, Script SQL, exécuter des requêtes", 5, "Distantiel", "150.99");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("UML", "Diagramme UseCase, Driagramme de Class, Diagramme de séquence", 20, "Présentiel", "280.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("POO", "Methodes, Encapsulation, Héritage, Polymorphisme", 45, "Présentiel", "400.90");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("WEB", "HTML5, CSS3, JavaScript", 30, "Présentiel", "500.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Anglais", "Anglais pro technique", 30, "Distantiel", "600.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("Maeven", "Installation, Les artefacts, Les archétypes ", 15, "Présentiel", "299.00");
INSERT INTO T_Articles (NameArticle, Description, DurationDays, Modality, Price) VALUES ("NgRx", "Bases RxJS, Actions/Reducers, NgRxEntity", 3, "Distantiel", "99.99");

SELECT * FROM T_Articles;




-- - la table des catégories d'articles

CREATE TABLE T_Categories (
	IdCategory 				INT(4) 		 PRIMARY KEY AUTO_INCREMENT,
	CatName 				VARCHAR(30)  NOT NULL,
	Description 			VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

insert into T_Categories (IdCategory, CatName, Description) values (1,' debutant', 'apprennats avec des notions');
insert into T_Categories (IdCategory, CatName, Description) values (2,'intermediaire', 'apprennats un peu experimentes');
insert into T_Categories (IdCategory, CatName, Description) values (3,'avance', 'apprennats experimentes');
insert into T_Categories (IdCategory, CatName, Description) values (4,'bla', 'bla');

alter table t_articles add foreign key (idCategory) References t_categories(IdCategory);


SELECT * FROM T_articles;



-- - table des utilisateurs ----
CREATE TABLE T_Users (
	IdUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login				varchar(20)	NOT NULL UNIQUE,
	Password			varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 1, 'Simpson' ,	'Homero' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 2, 'Smith',	'Marge' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 3, 'Dobson' ,	'Lisa' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 4, 'Lopez'   ,	'Bart' );
INSERT INTO T_Users (IdUser, Login, Password) VALUES ( 5, 'Don'     ,	'Maggie' );

SELECT * FROM T_Users;


-- - table des clients	

CREATE TABLE T_Customers (
	IdCustomer				int(4)		PRIMARY KEY AUTO_INCREMENT,
	name					varchar(30)	NOT NULL,
	firstName				varchar(30)	NOT NULL,
	email 					varchar(30)	NOT NULL unique,
	phone 					varchar(20)	,
	address					varchar(50)	,
	idUser					int(4)		NOT NULL,
	FOREIGN KEY (idUser)	REFERENCES T_Users(idUser)
) ENGINE = InnoDB;



---Table T_orders
CREATE TABLE T_Orders (
	IdOrder				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Amount				float(4)	NOT NULL DEFAULT 0,
	DateOrder 			DATE		NOT NULL DEFAULT NOW(),
	IdCustomer          INT(4)   	NOT NULL,
	FOREIGN KEY(IdCustomer) REFERENCES T_Customers(IdCustomer)
) ENGINE = InnoDB;


------Table T_OrderItems 
CREATE TABLE T_Order_Items (
	IdOrderItem			int(4)	PRIMARY KEY AUTO_INCREMENT,
	
	IdArticle           INT(4)   NOT NULL,
	FOREIGN KEY(IdArticle) REFERENCES T_Articles(IdArticle),
	
	Quantity			FLOAT(4) NOT NULL DEFAULT 1,
	UnitaryPrice		FLOAT(4)	NOT NULL DEFAULT 0,
	
	IdOrder             INT(4)   NOT NULL,
	FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder)
) ENGINE = InnoDB;