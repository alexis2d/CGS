
# CGS Fil Rouge - Groupe 3

Voici notre application dédiée au CEFIM, qui permet d'optimiser le système de réservation de salles de classe. 


## 1. Pour commencer


### 1.1. Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre système :

- JDK (Java Development Kit) : Télécharger ici
- Gradle : Télécharger ici
- Git : Télécharger ici

### 1.2. Récupérer les sources

    1) Ouvrez votre terminal ou votre interface de ligne de commande.

    2) Naviguez vers le répertoire où vous souhaitez cloner le projet.

    3) Exécutez la commande suivante pour cloner le projet :

```
$ git clone https://github.com/alexis2d/CGS_Back.git
```

### 1.3.1 Configuration Gradle

    1) Ouvrez le projet cloné

    2) Dans un terminal ou une invite de commande, naviguez jusqu'au répertoire racine du projet.

    3) Exécutez la commande suivante pour construire le projet et résoudre les dépendances :

```
$ gradle build
```

Cette commande téléchargera les dépendances requises et compilera le projet.



### 1.3.2 Configuration Base de données

Configurez la base de données MySQL 8 en suivant les instructions de votre système d'exploitation pour l'installation de MySQL. 

Assurez-vous de disposer des informations de connexion à la base de données (nom de l'hôte, nom de la base de données, nom d'utilisateur, mot de passe).


Modifiez les fichiers de configuration du projet (généralement application.properties ou application.yml) pour spécifier les informations de connexion à la base de données MySQL 8.
Exécutez la commande suivante pour exécuter le projet :

```
$ gradle bootrun 
```
Cette commande démarrera l'application Spring Boot et la rendra accessible sur un port spécifié dans les fichiers de configuration.
Accédez à l'URL appropriée dans votre navigateur pour vérifier si l'application est en cours d'exécution correctement.



### 1.3. API



### 1.3.1. Salles

Methode| Chemin         | Description                    |
-------|----------------|--------------------------------|
GET    | /list          | Retourne toutes les salles     |
GET    | /{id}          | Retourne une salle par son ID  |
POST   | /add           | Ajoute une nouvelle salle      |
PUT    | /{id}          | Modifie une salle              |
DELETE | /{id}          | Supprime une salle             |

### 1.3.2. Sites

Methode| Chemin         | Description                    |
-------|----------------|--------------------------------|
GET    | /list          | Retourne tous les sites        |
GET    | /{id}          | Retourne un site par son ID    |
POST   | /add           | Ajoute un nouveau site         |
PUT    | /{id}          | Modifie un site                |
DELETE | /{id}          | Supprime un site               |

### 1.3.3. Promotion

Methode| Chemin         | Description                       |
-------|----------------|-----------------------------------|
GET    | /list          | Retourne toutes les promotions    |
GET    | /{id}          | Retourne une promotion par son ID |
POST   | /add           | Ajoute une nouvelle promotion     |
PUT    | /{id}          | Modifie une promotion             |
DELETE | /{id}          | Supprime une promotion            |


### 1.3.4. Reservations

Methode| Chemin         | Description                         |
-------|----------------|-------------------------------------|
GET    | /list          | Retourne toutes les Reservations    |
GET    | /{id}          | Retourne une Reservation par son ID |
POST   | /add           | Ajoute une nouvelle reservation     |
PUT    | /{id}          | Modifie une reservation             |
DELETE | /{id}          | Supprime une reservation            |
GET | /classroom/{classroomId} | Retourne les réservations pour une salle |
GET | /user/{userId} | Retourne les réservations pour un référent |