<<<<<<< HEAD
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
=======
Example plain HTML site using GitLab Pages.

Learn more about GitLab Pages at https://pages.gitlab.io and the official
documentation https://docs.gitlab.com/ce/user/project/pages/.

---

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [GitLab CI](#gitlab-ci)
- [GitLab User or Group Pages](#gitlab-user-or-group-pages)
- [Did you fork this project?](#did-you-fork-this-project)
- [Troubleshooting](#troubleshooting)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## GitLab CI

This project's static Pages are built by [GitLab CI][ci], following the steps
defined in [`.gitlab-ci.yml`](.gitlab-ci.yml):

```
image: busybox

pages:
  stage: deploy
  script:
  - echo 'Nothing to do...'
  artifacts:
    paths:
    - public
    expire_in: 1 day
  rules:
    - if: $CI_COMMIT_REF_NAME == $CI_DEFAULT_BRANCH
```

The above example expects to put all your HTML files in the `public/` directory.

## GitLab User or Group Pages

To use this project as your user/group website, you will need one additional
step: just rename your project to `namespace.gitlab.io`, where `namespace` is
your `username` or `groupname`. This can be done by navigating to your
project's **Settings**.

Read more about [user/group Pages][userpages] and [project Pages][projpages].

## Did you fork this project?

If you forked this project for your own use, please go to your project's
**Settings** and remove the forking relationship, which won't be necessary
unless you want to contribute back to the upstream project.

## Troubleshooting

1. CSS is missing! That means that you have wrongly set up the CSS URL in your
   HTML files. Have a look at the [index.html] for an example.

[ci]: https://about.gitlab.com/gitlab-ci/
[index.html]: https://gitlab.com/pages/plain-html/blob/master/public/index.html
[userpages]: https://docs.gitlab.com/ce/user/project/pages/introduction.html#user-or-group-pages
[projpages]: https://docs.gitlab.com/ce/user/project/pages/introduction.html#project-pages
>>>>>>> 7e14d75 (Initialized from 'Pages/Plain HTML' project template)
