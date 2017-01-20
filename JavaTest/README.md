# Acquisio test en ligne
(See below for the english version - Acquisio online test

Bonjour et bienvenue au test en ligne d'Acquisio. Nous vous remercions de prendre le
temps de remplir ce test. Ceci nous permettra d'évaluer vos connaissances générales
au niveau du développement Web. Il n'y a pas de limite de temps, et n'hésitez pas 
à envoyer vos questions si vous avez besoin de clarification à [onlinetest@acquisio.com](mailto:onlinetest@acquisio.com)


Pour débuter le test, veuillez faire un "Fork" du projet.

Le test en séparé en 3 sections principales. Soit:
 1. Questions génériques sur Java
 1. Questions génériques sur SQL
 1. Questions d'implémentation d'une fonctionalité dans une Application Web

Afin de voir votre méthode de penser et votre cheminement, veuillez commit aussitôt que possible.
Lorsque vous aurez terminer, veuillez soumettre un "Pull Request". Svp, ne pas faire
de "Squash" sur vos commits.

### Générique Java
Pour les questions reliés à votre connaissance de Java, vous les trouverez dans le 
package "com.acquisio.basic.java". Il y a 9 questions à répondre. Chaque sous package
contient 1 classe avec un main. Suivez les instructions dans la documentation de cette
classe. Veuillez ajouter les tests et la javadoc que vous jugez nécessaire.

Les points d'entrées sont:
 * [FizzBuzz.java](src/main/java/com/acquisio/basic/java/question01/FizzBuzz.java)
 * [TreeNavigation.java](src/main/java/com/acquisio/basic/java/question02/TreeNavigation.java)
 * [ConvertToBinary.java](src/main/java/com/acquisio/basic/java/question03/ConvertToBinary.java)
 * [IssueResolving.java](src/main/java/com/acquisio/basic/java/question04/IssueResolving.java)
 * [Generics.java](src/main/java/com/acquisio/basic/java/question05/Generics.java)
 * [Refactoring.java](src/main/java/com/acquisio/basic/java/question06/Refactoring.java)
 * [Debugging.java](src/main/java/com/acquisio/basic/java/question07/Debugging.java)
 * [JUnit.java](src/main/java/com/acquisio/basic/java/question08/JUnit.java)
 * [Streams.java](src/main/java/com/acquisio/basic/java/question09/Streams.java)

### Générique SQL
Pour les questions reliés à votre connaissance SQL, vous les trouverez dans le package
"com.acquisio.basic.sql". Il y a 2 questions à répondre. Chaque sous package contient
1 classe avec un main. Suivez les instructions dans la documentation de cette classe.
Nous regarderons seulement la requête SQL que vous aurez ajouté. Le code utilise
une base de données H2, en mémoire, ré-initialiser à chaque exécution.

Les points d'entrées sont:
 * [Aggregation.java](src/main/java/com/acquisio/basic/sql/question01/Aggregation.java)
 * [Extraction.java](src/main/java/com/acquisio/basic/sql/question02/Extraction.java)

### Application Web

##### Contexte
Sous la package "com.acquisio.app", vous trouverez une application Spring-Boot [FullStackApp.java](src/main/java/com/acquisio/app/FullStackApp.java). 
Cette application permet de consulter une liste de départments et une liste d'employés. La partie UI
est en Angular. La page principale est [index.html](src/main/resources/static/index.html) et
les controlleurs sont gérés dans [FullStackApp.js](src/main/resources/static/js/FullStackApp.js).

Pour démarrer l'application, vous devez exécuter la commande suivante: 
```
mvn clean spring-boot:run
```

Une fois le serveur démarré, vous pouvez accéder à l'application [http://localhost:8080](http://localhost:8080/)

##### Projet
Ajouter la fonctionnalité d'éditer un employé pour changer son salaire (entre 10000$ et 500000$, valeur entière seulement)
et de changer son département. Offrir la possibilité d'ajouter un nouveau département à la liste actuelle. 

Ajouter toute documentation et tous les tests que vous jugez pertinent.

# Acquisio online test
Welcome to the Acquisio online test. Thank you for taking the time to do this test.
It will allow us to evaluate your basic knowledge as a Web developer. There is no
time limit to complete the test and feel free to send us all your questions if you
need clarification to [onlinetest@acquisio.com](mailto:onlinetest@acquisio.com)

To start, please "fork" this project.

This test is split into 3 main sections.
 1. Generic questions about Java
 1. Generic questions about SQL
 1. Implementation of a new Web Application

In order to see your methodology and your way of thinking, please commit as soon and 
often as possible. When the test is complete, submit a Pull Request. Do not squash
your commits at the end.

### About Java
For the questions related to your knowledge of Java, you will find them in the
"com.acquisio.basic.java" package. You will find 9 questions. Each subpackage contains
1 class with a main method. Follow the instruction in the class documentation. Please,
add any tests and javadoc that you see fit.

The entry points are:
 * [FizzBuzz.java](src/main/java/com/acquisio/basic/java/question01/FizzBuzz.java)
 * [TreeNavigation.java](src/main/java/com/acquisio/basic/java/question02/TreeNavigation.java)
 * [ConvertToBinary.java](src/main/java/com/acquisio/basic/java/question03/ConvertToBinary.java)
 * [IssueResolving.java](src/main/java/com/acquisio/basic/java/question04/IssueResolving.java)
 * [Generics.java](src/main/java/com/acquisio/basic/java/question05/Generics.java)
 * [Refactoring.java](src/main/java/com/acquisio/basic/java/question06/Refactoring.java)
 * [Debugging.java](src/main/java/com/acquisio/basic/java/question07/Debugging.java)
 * [Calculator.java](src/main/java/com/acquisio/basic/java/question08/JUnit.java)
 * [Streams.java](src/main/java/com/acquisio/basic/java/question09/Streams.java)

### About SQL
For the questions related to your knowledge of SQL, you will find them in the
"com.acquisio.basic.sql" package. You will find 2 questions. Each subpackage contains
1 class with a main method. Follow the instruction in the class documentation. We will
only look at the SQL statement that you will add. The code is using an H2 database,
in memory. That database is reset at each execution.

The entry points are:
 * [Aggregation.java](src/main/java/com/acquisio/basic/sql/question01/Aggregation.java)
 * [Extraction.java](src/main/java/com/acquisio/basic/sql/question02/Extraction.java)

### Web Application

##### Contexte
Under the "com.acquisio.app" package, you will find a Spring-Boot application named [FullStackApp.java](src/main/java/com/acquisio/app/FullStackApp.java).
That application allow to consult a list of departments and a list of employees. The UI part is in Angular.
The main page is [index.html](src/main/resources/static/index.html) and
controllers are managed into [FullStackApp.js](src/main/resources/static/js/FullStackApp.js).

To start the application, run this command : 
```
mvn clean spring-boot:run
```

Once the application is started, you can access the application at [http://localhost:8080](http://localhost:8080/)

##### Projet
Add the functionality to edit an employee to be able to change his/her salary (between 10000$ and 500000$,
integer only) and to change his/her department. Also add the possibility to add a new department to the current list. 

Add all the documentation and tests that you see fit.
