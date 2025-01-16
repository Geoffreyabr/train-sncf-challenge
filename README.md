# [Challenge] Java + Angular + Redis + WebSockets + Excel Parser

**Objectif :**  
Créer une application démo pour la SNCF, permettant de :
1. Gérer des **trains** et des **agents** (entités/objets métier).
2. **Parser un fichier Excel** pour insérer et mettre à jour les données dans une base **NoSQL Redis**.
3. Exposer des **endpoints REST** pour la consultation et la manipulation des données (avec **DTO**, **mappers**, **services**, **controllers**, **repositories**).
4. Mettre en place des **WebSockets** pour diffuser en temps réel les modifications sur les trains ou agents.
5. Fournir un **front-end Angular** minimaliste pour lister, afficher, créer et modifier ces entités.

## Détails du Challenge

1. **Entités principales :**
   - **Train**  
     Attributs (exemples) :  
       - `id` (Long)  
       - `numeroTrain` (String)  
       - `gareDepart` (String)  
       - `gareArrivee` (String)  
       - `heureDepart` (LocalDateTime)  
       - `heureArrivee` (LocalDateTime)  

   - **Agent**  
     Attributs (exemples) :  
       - `id` (Long)  
       - `nom` (String)  
       - `prenom` (String)  
       - `numMatricule` (String)  
       - `specialite` (String) (ex : conducteur, contrôleur, technicien, etc.)

2. **Base de données Redis :**  
   - Stockage clé-valeur (ex : clé `train:{id}`, valeur = JSON du train).
   - Idem pour `agent:{id}`.
   - Opérations CRUD via Spring Data Redis (Repository ou template).

3. **Parsing Excel :**  
   - Lecture d’un fichier Excel (par ex. via Apache POI).
   - Les lignes peuvent décrire soit un train, soit un agent (ex : un onglet pour chaque type, ou un code type de ligne).
   - Insertion / Mise à jour en Redis.

4. **WebSockets :**  
   - Mise en place d’un **WebSocket** (Spring WebSocket / STOMP) pour notifier le front Angular à chaque :
     - Création ou mise à jour d’un train.
     - Création ou mise à jour d’un agent.
   - Le front affiche les notifications en temps réel (ex : pop-up, ou rechargement automatique de la liste).

5. **Front Angular minimal :**  
   - Composants :  
     - **TrainListComponent** + **TrainDetailComponent**  
     - **AgentListComponent** + **AgentDetailComponent**  
   - Services HTTP pour appeler les endpoints REST (GET, POST, PUT, DELETE).  
   - WebSocketService pour la gestion du canal temps réel (Socket).

6. **Architecture conseillée :**


- **DTO / Mapper** : Un `TrainDTO` et un `AgentDTO` pour exposer les données côté REST.
- **Controller** : `TrainController` et `AgentController`.
- **Service** : `TrainService` et `AgentService` (logique métier).
- **Repository (Redis)** : `TrainRepository`, `AgentRepository`.
- **WebSocketController** (ou config) pour gérer la communication temps réel.

7. **Tâches principales :**
1. **Configurer Spring Boot** pour Redis (dépendance `spring-boot-starter-data-redis`).
2. **Configurer l’Excel Parser** (dépendance Apache POI) et créer un service d’import (ex : `ExcelImportService`).
3. **Créer les entités** `Train` et `Agent` (mais sous forme de classes simples ou entités Spring Data Redis).
4. **Créer les DTO** (ex : `TrainDTO`, `AgentDTO`).
5. **Mettre en place des mappers** (ex : `TrainMapper`, `AgentMapper`) pour la conversion entité <-> DTO.
6. **Implémenter les contrôleurs REST** :
   - `POST /trains` pour créer un train, `GET /trains` pour lister, etc.
   - `POST /agents` pour créer un agent, `GET /agents` pour lister, etc.
7. **Mettre en place un WebSocket** (ex : `/topic/updates`) pour diffuser les modifications en temps réel.
8. **Front Angular** :
   - **Service** (ex : `train.service.ts`, `agent.service.ts`) pour consommer l’API REST.
   - **Composants** minimalistes pour lister/afficher/éditer.
   - Mise en place d’un **WebSocket** pour se connecter au back (via la librairie `@stomp/ng2-stompjs` ou `ngx-socket-io`).

8. **Critères de validation :**
- **Excel** : L’appli doit savoir importer un fichier Excel (ex : bouton sur le front, envoi du fichier via un endpoint) et créer/mettre à jour les données en Redis.
- **WebSockets** : À chaque ajout ou mise à jour d’un train/agent, un message est envoyé aux clients connectés pour qu’ils actualisent la liste.
- **Angular** : Un front simple (quelques pages) permettant :
  - Lister/afficher les trains/agents.
  - Créer ou modifier un train/agent.
  - Visualiser en temps réel l’arrivée d’un nouveau train/agent via WebSockets.
- **Bonne pratique** : Les contrôleurs ne renvoient pas les entités Redis directes, mais des **DTO**.  
- **Mappers** : il doit exister des classes de mappers qui assurent la conversion entité <-> DTO.

---

## Éléments supplémentaires

- **Sécurité** : (optionnelle) Vous pouvez ajouter un peu de Spring Security si vous le souhaitez, mais ce n’est pas obligatoire pour ce challenge.
- **Tests** : (recommandé) Écrivez des tests unitaires (JUnit) pour le parsing Excel, la logique du service, et éventuellement des tests d’intégration.
- **CI/CD** : (bonus) Vous pouvez configurer un pipeline GitLab CI pour builder le projet.
