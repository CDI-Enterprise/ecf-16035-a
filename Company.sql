create table departments(
  departmentNumber number,
  departmentName varchar(75)
);

create table regions(
    regionName varchar(150),
   regionId number

);

create table languages(
  languageId number,
  languageName varchar(70)
  );

create table company(
    companyId number,
    companyName varchar(100),
    companyAdress VARCHAR (200),
    companyCODEPOSTAL VARCHAR2(100), 
    companyCity VARCHAR2(100), 
    companySize varchar2(200),
    companySector VARCHAR2(200),
    companyProjects varchar(1000),
    companyWeb varchar(200)
   );

drop table contactComp;
create table contact (
  idContact number,
  contactName varchar(100),
  contactPhone varchar(20),
  contactMail varchar(50)
  );

create table companyregion(
  companyId number,
  regionId number
  );
  
  
create table companydepartment(
  companyId number,
  departmentNumber number
  );
  
create table companyLanguage(
  companyId number,
  languageId number
  );

create table companyContact(
  companyId number,
  contactId number);

drop table regions;
drop table departments; 
drop table languages;

select departmentnumber, departmentName  from departments;
select regionID, REGIONNAME from regions;
select LANGUAGEID, LANGUAGENAME from LANGUAGES;


select departmentNumber, departmentName from departments where departmentName = 'Ain';


delete from departments;

insert into departments values(1,'Ain');
insert into departments values(2,'Aisne');
insert into departments values(3,'Allier');
insert into departments values(4,'Alpes de Hautes-Provence');
insert into departments values(5,'Hautes-Alpes');
insert into departments values(6,'Alpes-Maritimes');
insert into departments values(7,'Ardèche');
insert into departments values(8,'Ardennes');
insert into departments values(9,'Ariège');
insert into departments values(10,'Aube');
insert into departments values(11,'Aude');
insert into departments values(12,'Aveyron');
insert into departments values(13,' Bouches-du-Rhône');
insert into departments values(14,'Calvados');
insert into departments values(15,'Cantal');
insert into departments values(16,'Charente');
insert into departments values(17,'Charente-Maritime');
insert into departments values(18,'Cher');
insert into departments values(19,'Corrèze');
insert into departments values(20,'Corse-du-Sud-Haute-Corse');
insert into departments values(21,'Côte-d''Or');
insert into departments values(22,'Côtes d''Armor');
insert into departments values(23,'Creuse');
insert into departments values(24,'Dordogne');
insert into departments values(25,'Doubs');
insert into departments values(26,'Drôme');
insert into departments values(27,'Eure');
insert into departments values(28,'Eure-et-Loir');
insert into departments values(29,'Finistère');
insert into departments values(30,'Gard');
insert into departments values(31,' Haute-Garonne');
insert into departments values(32,'Gers');
insert into departments values(33,'Gironde');
insert into departments values(34,'Hérault');
insert into departments values(35,'Ille-et-Vilaine');
insert into departments values(36,'Indre');
insert into departments values(37,'Indre-et-Loire');
insert into departments values(38,'Isère');
insert into departments values(39,'Jura');
insert into departments values(40,'Landes');
insert into departments values(41,'Loir-et-Cher');
insert into departments values(42,'Loire');
insert into departments values(43,'Haute-Loire');
insert into departments values(44,'Loire-Atlantique');
insert into departments values(45,'Loiret');
insert into departments values(46,'Lot');
insert into departments values(47,'Lot-et-Garonne');
insert into departments values(48,'Lozère');
insert into departments values(49,'Maine-et-Loire');
insert into departments values(50,'Manche');
insert into departments values(51,'Marne');
insert into departments values(52,'Haute-Marne');
insert into departments values(53,'Mayenne');
insert into departments values(54,'Meurthe-et-Moselle');
insert into departments values(55,'Meuse');
insert into departments values(56,'Morbihan');
insert into departments values(57,'Moselle');
insert into departments values(58,'Nièvre');
insert into departments values(59,'Nord');
insert into departments values(60,'Oise');
insert into departments values(61,'Orne');
insert into departments values(62,'Pas-de-Calais');
insert into departments values(63,'Puy-de-Dôme');
insert into departments values(64,'Pyrénées-Atlantiques');
insert into departments values(65,'Hautes-Pyrénées');
insert into departments values(66,'Pyrénées-Orientales');
insert into departments values(67,'Bas-Rhin');
insert into departments values(68,'Haut-Rhin');
insert into departments values(69,'Rhône');
insert into departments values(70,'Haute-Saône');
insert into departments values(71,'Saône-et-Loire');
insert into departments values(72,'Sarthe');
insert into departments values(73,'Savoie');
insert into departments values(74,'Haute-Savoie');
insert into departments values(75,'Paris');
insert into departments values(76,'Seine-Maritim');
insert into departments values(77,'Seine-et-Marne');
insert into departments values(78,'Yvelines');
insert into departments values(79,'Deux-Sèvres');
insert into departments values(80,'Somme');
insert into departments values(81,'Tarn');
insert into departments values(82,'Tarn-et-Garonne');
insert into departments values(83,'Var');
insert into departments values(84,'Vaucluse');
insert into departments values(85,'Vendée');
insert into departments values(86,'Vienne');
insert into departments values(87,'Haute-Vienne');
insert into departments values(88,'Vosges');
insert into departments values(89,'Yonne');
insert into departments values(90,'Territoire-de-Belfort');
insert into departments values(91,'Essonne');
insert into departments values(92,'Hauts-de-Seine');
insert into departments values(93,'Seine-Saint-Denis');
insert into departments values(94,'Val-de-Marne');
insert into departments values(95,'Val-d''Oise');

insert into regions values('Auvergne-Rhône-Alpes',1);
insert into regions values('Bourgogne Franche Comté',2);
insert into regions values('Bretagne',3);
insert into regions values('Centre-Val de Loire',4);
insert into regions values('Corse',5);
insert into regions values('Grand Est',6);
insert into regions values('Hauts-de-France',7);
insert into regions values('Île-de-France',8);
insert into regions values('Normandie',9);
insert into regions values('Nouvelle-Aquitaine',10);
insert into regions values('Occitanie',11);
insert into regions values('Pays de la Loire',12);
insert into regions values('Provence-Alpes-Côte d''Azur',13);
insert into regions values('Guadeloupe',14);
insert into regions values('Martinique',15);
insert into regions values('Guyane',16);
insert into regions values('La Réunion',17);
insert into regions values('Mayotte',18);

insert into languages values (1 , 'JAVA' );
insert into languages values (2 , 'PhP' );
insert into languages values (3 , 'CSS' );
insert into languages values (4 , 'C#' );
insert into languages values (5 , 'C++' );
insert into languages values (6 , 'Ruby' );


insert into company values (1,'AFPA', '53 Boulevard Laveran','13013', 'MARSEILLE', 'Grande Entreprise', 'Formation adultes', 'Formation dans plusieurs domaines','afpa@afpa.fr');
insert into companyRegion values (1,13);
insert into companyDepartment values(1,13);
insert into companylanguage values (1,1);


select regionName from regions order by regionId;
select *  from company;
select  * from companydepartment; 
select * from companyregion;
select * from companylanguage;

select company.companyId, companyName,companyAdress, companyCODEPOSTAL, companyCity, companySize , companySector , companyProjects , companyWeb, departmentname, regionName, languagename
from company, languages, departments, regions, companydepartment, companyregion, companylanguage
where company.companyId = companyregion.companyId
and company.companyId = companydepartment.companyId
and company.companyId = companyLanguage.companyId
and departments.departmentNumber = companydepartment.departmentNumber
and regions.regionId = companyregion.regionId
and languages.languageId = companylanguage.LANGUAGEID;


select company.companyId, companyName,companyAdress, companyCODEPOSTAL, companyCity, companySize , companySector , companyProjects , companyWeb, departmentname, regionName, languagename 
from company, languages, departments, regions, companydepartment, companyregion, companylanguage 
where company.companyId = companyregion.companyId 
and company.companyId = companydepartment.companyId 
and company.companyId = companyLanguage.companyId 
and departments.departmentNumber = companydepartment.departmentNumber 
and regions.regionId = companyregion.regionId 
and languages.languageId = companylanguage.LANGUAGEID;

delete from company where companyId = 2;
delete from companyregion where companyId = 6;
delete from companydepartment where companyId = 6;
delete from companylanguage where companyId = 6;

commit;