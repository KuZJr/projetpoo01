SET AUTOCOMMIT = 0;
START TRANSACTION;

-- CREATION DE LA BASE
CREATE DATABASE IF NOT EXISTS gestiongarage;


-- TABLES
CREATE TABLE client (
	idClient INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	adresse VARCHAR(100) NOT NULL,
	codepostal VARCHAR(50) NOT NULL,
	telephone VARCHAR(20) NOT NULL,
	mobile VARCHAR(20) NOT NULL,
	idDevis INTEGER NOT NULL,
	idFiche INTEGER NOT NULL
);


CREATE TABLE devis (
	idDevis INTEGER PRIMARY KEY AUTO_INCREMENT,
	devisvalide BOOLEAN NOT NULL,
	idFactureDevis INTEGER NOT NULL
);


CREATE TABLE factureDevis (
	idFactureDevis INTEGER PRIMARY KEY AUTO_INCREMENT,
	tauxTVA DECIMAL(10,2) NOT NULL,
	dateFacture DATE NOT NULL,
	detail VARCHAR(200) NOT NULL,
	sommeGlobale DECIMAL(10,2) NOT NULL
);


CREATE TABLE voitures (
	idVoiture INTEGER PRIMARY KEY AUTO_INCREMENT,
	marque VARCHAR(50) NOT NULL,
	modele VARCHAR(50) NOT NULL,
	quantite INTEGER NOT NULL,
	prixHT DECIMAL(10,2) NOT NULL,
	idDevis INTEGER NOT NULL
);


CREATE TABLE commandeVoitures (
	idCommandeV INTEGER PRIMARY KEY AUTO_INCREMENT,
	quantite INTEGER NOT NULL,
	prixHT DECIMAL(10,2) NOT NULL,
	idVoiture INTEGER NOT NULL
);


CREATE TABLE stockVoitures (
	idStockVoitures INTEGER PRIMARY KEY AUTO_INCREMENT,
	quantite INTEGER NOT NULL
);


CREATE TABLE r_voitures_stock (
	idStockVoitures INTEGER NOT NULL,
	idVoiture INTEGER NOT NULL,
	CONSTRAINT PK_r_voitures_stock PRIMARY KEY (idStockVoitures, idVoiture)
);


CREATE TABLE fiche (
	idFiche INTEGER PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(150) NOT NULL,
	ficheValidee BOOLEAN NOT NULL,
	fichecloturee BOOLEAN NOT NULL,
	niveauPriorite VARCHAR(50) NOT NULL,
	idFactureFiche INTEGER NOT NULL
);


CREATE TABLE factureFiche (
	idFactureFiche INTEGER PRIMARY KEY AUTO_INCREMENT,
	sommeGlobale DECIMAL(10,2) NOT NULL,
	detail VARCHAR(200) NOT NULL,
	dateFacture DATE NOT NULL,
	tauxTVA DECIMAL(10,2) NOT NULL
);


CREATE TABLE pieces (
	idPiece INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	quantite INTEGER NOT NULL,
	prixHT DECIMAL(10,2) NOT NULL,
	idFiche INTEGER NOT NULL
);


CREATE TABLE commandePieces (
	idCommandeP INTEGER PRIMARY KEY AUTO_INCREMENT,
	quantite INTEGER NOT NULL,
	prixHT DECIMAL(10,2) NOT NULL,
	valide BOOLEAN NOT NULL,
	idPiece INTEGER NOT NULL
);


CREATE TABLE stockPieces (
	idStockPieces INTEGER PRIMARY KEY AUTO_INCREMENT,
	quantite INTEGER NOT NULL
);


CREATE TABLE r_pieces_stock (
	idStockPieces INTEGER NOT NULL,
	idPiece INTEGER NOT NULL,
	CONSTRAINT PK_r_pieces_stock PRIMARY KEY (idStockPieces, idPiece)
);


CREATE TABLE tache (
	idTache INTEGER PRIMARY KEY AUTO_INCREMENT,
	tacheTerminee BOOLEAN NOT NULL,
	idFiche INTEGER NOT NULL
);


CREATE TABLE users (
	idUser INTEGER PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	bloque BOOLEAN NOT NULL,
	idTache INTEGER NOT NULL,
	idDevis INTEGER NOT NULL
);


CREATE TABLE profil (
	idProfil INTEGER PRIMARY KEY AUTO_INCREMENT,
	typeProfil VARCHAR(100) NOT NULL
);


CREATE TABLE r_users_profil (
	idUser INTEGER NOT NULL,
	idProfil INTEGER NOT NULL,
	CONSTRAINT PK_r_users_profil PRIMARY KEY (idUser, idProfil)
);


-- FK
-- FK TABLE client
ALTER TABLE client
ADD FOREIGN KEY (idDevis) REFERENCES devis(idDevis);

ALTER TABLE client
ADD FOREIGN KEY (idFiche) REFERENCES fiche(idFiche);

-- FK TABLE pieces
ALTER TABLE pieces
ADD FOREIGN KEY (idFiche) REFERENCES fiche(idFiche);

-- FK TABLE tache
ALTER TABLE tache
ADD FOREIGN KEY (idFiche) REFERENCES fiche(idFiche);

-- FK TABLE fiche
ALTER TABLE fiche
ADD FOREIGN KEY (idFactureFiche) REFERENCES factureFiche(idFactureFiche);

-- FK TABLE users
ALTER TABLE users
ADD FOREIGN KEY (idDevis) REFERENCES devis(idDevis);

-- FK TABLE commandePieces
ALTER TABLE commandePieces
ADD FOREIGN KEY (idPiece) REFERENCES pieces(idPiece);

-- FK TABLE devis
ALTER TABLE devis
ADD FOREIGN KEY (idFactureDevis) REFERENCES factureDevis(idFactureDevis);

-- FK TABLE voitures
ALTER TABLE voitures
ADD FOREIGN KEY (idDevis) REFERENCES devis(idDevis);

-- FK TABLE commandeVoitures
ALTER TABLE commandeVoitures
ADD FOREIGN KEY (idVoiture) REFERENCES voitures(idVoiture);

-- FK r_pieces_stock
ALTER TABLE r_pieces_stock
ADD FOREIGN KEY (idPiece) REFERENCES pieces(idPiece);

ALTER TABLE r_pieces_stock
ADD FOREIGN KEY (idStockPieces) REFERENCES stockPieces(idStockPieces);

-- FK r_users_p
ALTER TABLE r_users_profil
ADD FOREIGN KEY (idUser) REFERENCES users(idUser);

ALTER TABLE r_users_profil
ADD FOREIGN KEY (idProfil) REFERENCES profil(idProfil);

-- FK r_voitures_stock
ALTER TABLE r_voitures_stock
ADD FOREIGN KEY (idStockVoitures) REFERENCES stockVoitures(idStockVoitures);

ALTER TABLE r_voitures_stock
ADD FOREIGN KEY (idVoiture) REFERENCES voitures(idVoiture);

COMMIT;