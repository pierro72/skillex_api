





Prerequis
------------

* Java - 1.8.x

* Mysql - 5.x.x

* Maven 3.x.x

Installation
------------
- Cloner le projet

- completer les parametres suivant du fichier de propriete : [src/main/resources/application.properties](src/main/resources/application.properties)
    - spring.datasource.url=jdbc:mysql://localhost/ xxx
    - spring.datasource.username= xxx
    - spring.datasource.password= xxx

- Lancer l'application avec Maven ( Profil dev par défault)

`mvn spring-boot:run`

- Pour choisir un autre profil :

`mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev"`


Alternativement vous pouvez lancer l'application en debug

`mvn spring-boot:run -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005`

Le server va demarer sur  [http://localhost:8080](http://localhost:8080)

Pour acceder a la documentation de l'api : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)




Générer le WAR
------------
Avant de génerer un WAR vérifier les parametres du fichier de propriété **application.xx.properties**

* Générer le fichier WAR avec profil production  : 
```
mvn -Pprod package -Dmaven.test.skip=true
``` 
* Générer le fichier WAR avec profil test :
```
mvn -Ptest package -Dmaven.test.skip=true
``` 
* Générer le fichier WAR avec profil local :
```
mvn -Pdev package
``` 

Pour éviter les tests qui peuvent bloquer la compilation ajouter cet argument : 
```
-Dmaven.test.skip=true
```

Vous pouvez aussi spécifier les profiles directement :
```
mvnw -Pprod,swagger,no-liquibase package
```
```
mvnw -Ptest,swagger package
```
```
mvnw -Pdev,no-liquibase package
```

Dans le dossier '/target' il y a deux fichiers générés
* skillex.war 
* skillex.war.original (embarque un tomcat donc il vaut mieu utiliser le skillex.war.original )

    

Deployer sur serveur CentOs
------------

http://glpi.sodifrance.fr/front/ticket.form.php?id=24351

#### info serveur
* Login : administrateur
* Password : Adm#CdsLeMans01
* Le client putty est utilisé pour se connecter en SSH
* Le client SFTP/SCP WinSCP permet de se connecter aux serveurs SSH pour transférer des fichiers.

#### Procedure de deploiement
* Transferer le 'fichier'.war vers le home administrateur avec WinSCP.
* Désactiver le serveur tomcat : 
```
sudo service tomcat stop
```
* Suprimer l'ancien dossier de l'API : 
```
sudo rm -r /opt/tomcat/webapps/skillexapi
```
* Suprimer l'ancien dossier de l'API : 
```
sudo rm /opt/tomcat/webapps/skillexapi.war
```
* Copier le fichier WAR présent dans le home administrateur vers /opt/tomcat/webapps : 
```
sudo mv skillexapi.war /opt/tomcat/webapps/skillexapi.war
```
* Relancer Tomcat : 
```
sudo service tomcat start
```

* Log
``
cat /opt/tomcat/logs/catalina.out
tail -f -n 150 /opt/tomcat/logs/catalina.out
``


#### Gerer la base de donnée
* Se connecter a MySQL en ROOT : ```mysql -u root -p```
* Creation d'une bdd pour l'application ```CREATE DATABASE skillex;```
* Creation d'un utilisateur (ici skillex-user) ```CREATE USER 'skillex-dev' IDENTIFIED BY 'skillex-dev';```
* Donner à cette utilisateur tout les droits sur la bdd : ```GRANT ALL PRIVILEGES ON skillex.* TO 'skillex-dev';```
* Confirmer : ```FLUSH PRIVILEGES;```
