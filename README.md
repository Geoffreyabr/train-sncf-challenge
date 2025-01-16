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
