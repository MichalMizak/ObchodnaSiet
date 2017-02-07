CREATE TABLE naklad (
    id NUMBER PRIMARY KEY,
    prevadzka_id NUMBER,
    popis VARCHAR(50),
    datum TIMESTAMP,
    suma NUMBER
);
CREATE SEQUENCE naklad_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE nastavenia (
    id NUMBER PRIMARY KEY,
    nazov_obchodnej_siete VARCHAR(100),
    mena VARCHAR(20)
);
CREATE SEQUENCE nastavenia_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE prevadzka (
    id NUMBER PRIMARY KEY,
    nazov VARCHAR(50),
    adresa VARCHAR(50),
    otvaracie_hodiny VARCHAR(100)
);
CREATE SEQUENCE prevadzka_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE prijem (
    id NUMBER PRIMARY KEY,
    prevadzka_id NUMBER,
    popis VARCHAR(50),
    datum TIMESTAMP,
    suma NUMBER
);
CREATE SEQUENCE prijem_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE produkt (
    id NUMBER PRIMARY KEY,
    nazov VARCHAR(50),
    nakupna_cena NUMBER,
    predajna_cena NUMBER
);
CREATE SEQUENCE produkt_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE produkt_na_predajni (
    produkt_id NUMBER,
    prevadzka_id NUMBER,
    zlava NUMBER,
    kusy NUMBER,
    PRIMARY KEY(produkt_id, prevadzka_id)
);

CREATE TABLE zamestnanec (
    id NUMBER PRIMARY KEY,
    meno VARCHAR(50),
    priezvisko VARCHAR(50),
    prevadzka_id NUMBER,
    datum_nastupu TIMESTAMP,
    plat_brutto NUMBER
);
CREATE SEQUENCE zamestnanec_sequence START WITH 1 INCREMENT BY 1;

ALTER TABLE naklad ADD CONSTRAINT f_naklad_prevadzka FOREIGN KEY(prevadzka_id) REFERENCES prevadzka(id) ON DELETE CASCADE;
ALTER TABLE prijem ADD CONSTRAINT f_prijem_prevadzka FOREIGN KEY(prevadzka_id) REFERENCES prevadzka(id) ON DELETE CASCADE;
ALTER TABLE produkt_na_predajni ADD CONSTRAINT f_produkt_na_predajni_produkt FOREIGN KEY(produkt_id) REFERENCES produkt(id) ON DELETE CASCADE;
ALTER TABLE produkt_na_predajni ADD CONSTRAINT f_prod_na_pred_prevadzka FOREIGN KEY(prevadzka_id) REFERENCES prevadzka(id) ON DELETE CASCADE;
ALTER TABLE zamestnanec ADD CONSTRAINT f_zamestnanec_prevadzka FOREIGN KEY(prevadzka_id) REFERENCES prevadzka(id) ON DELETE CASCADE;

INSERT INTO nastavenia (id, nazov_obchodnej_siete, mena) VALUES (1, 'Názov obchodnej siete', 'Eur/€');
