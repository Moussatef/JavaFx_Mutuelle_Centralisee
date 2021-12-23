# JavaFx_Mutuelle_Centralisee
photos de l'application


<img width="40%" align="right" alt="Github" src="https://raw.githubusercontent.com/onimur/.github/master/.resources/git-header.svg" />







## Contexte du projet

### I )
La population de la ville de SAFI a dépassé les 320 mille hab/m², le recouvrement médical est partout ainsi que
les dossiers envoyés par les personnes cumulent jour après jour, du coup la DSI de la préfecture en collaboration
avec la gouvernance des organismes de protection sociale sous tutelle (ressource 1) vont lancer un projet numérique
qui vise la gestion des dossiers et des clients pour faciliter leur remboursement en respectant les conditions mutuelles de chacun d’eux.

Bref, votre mission tant que consultant externe chez la préfecture de SAFI est collaborer dans la phase de développement
du projet, et mettre en place l’application afin que les opérateurs puissent commencer de l’utiliser. La technologie
demandée par le client est du Java 100%, et bien évidement ils ont proposé aussi que l’outil sera un exécutable
sur le bureau (application Desktop).

### II )

Suite à la partie 1 du brief (App desktop / Mutuelle), vous avez passé la démonstration avec le client et c’était bien passé sauf qu’il y avait des améliorations à faire.

Une table types des mutuelles à créer.

### III )

Suite à la deuxième version du Mutuelle centralisée, le client est satisfait de votre travail et il a testé l’application et tous les tests sont bien passé,

### La comité des nouvelles fonctionnalités a pensé à ajouter d’autre choses à l’application :

•	Tracer les actions qui passent dans un fichier ou bien dans la base de données, les infos à tracer (La date de l’action + le type (erreur / warning …) + l’utilisateur authentifié + l’action + les exceptions s’il y une)

•	L’envoie d’un mail à le client à chaque nouvelle inscription.

•	**L’extract du fichier (.jar) **en fin de compte pour le rendre exécutable dans touts les PC des fonctionnaires. (Un Setup installer sera du plus).



## Workflow Phase 1 :
Un fonctionnaire d’une entité de mutuelle (par exemple : OMFAM) peut se connecter sur la plateforme. (Les fonctionnaires sont déjà sauvegardés dans un fichier JSON) ressource 2.

## Page 1 : (Authentification) 
 <img width="55%" align="left" alt="Github" src="https://github.com/Moussatef/JavaFx_Mutuelle_Centralisee/blob/main/src/main/resources/com/example/demo1/assets/Screenshot_41.png" />
  Ça sera la même chose sauf qu’il doit être à travers une base de données (MySQL), et il faut hacher les mots de passe des fonctionnaires.
  
 ## Page 2 / onglet 2 (Home ):
  - informations de fonctionnaire authentifie et l'entité info 
   <img width="100%" align="center" alt="Github" src="https://github.com/Moussatef/JavaFx_Mutuelle_Centralisee/blob/main/src/main/resources/com/example/demo1/assets/Screenshot_42.png" />


  
## Page 2 / onglet 2 : (Création d’un compte pour un client) :

Un fonctionnaire peut créer un nouveau client suite à la demande d’organisme mère du client (Par exemple : Ahmed a commencé son nouveau boulot chez la Gendarmerie royale marocaine, cette dernière vont envoyer une demande de création d’un compte à l’OMFAM, et le fonctionnaire va s’occuper du reste.
<img width="100%" align="center" alt="Github" src="https://github.com/Moussatef/JavaFx_Mutuelle_Centralisee/blob/main/src/main/resources/com/example/demo1/assets/Screenshot_60.png" />

- L’envoie d’un mail à le client à chaque nouvelle inscription.

<img width="60%" align="center" alt="Github" src="https://github.com/Moussatef/JavaFx_Mutuelle_Centralisee/blob/main/src/main/resources/com/example/demo1/assets/Screenshot_61.png" />


## 
## 


## Page 2 / onglet 3 : (Afficher les client enregistrés):

<img width="100%" align="right" alt="Github" src="https://github.com/Moussatef/JavaFx_Mutuelle_Centralisee/blob/main/src/main/resources/com/example/demo1/assets/Screenshot_58.png" />

## 
## 


- Il faut alimenter  la base des clients au début pour avoir au moins 200 clients 
  avec des données différents (vous pouvez utiliser un import csv ou Excel ou autre)
- Ça sera un select à partir de la base et il faut ajouter un filtre d’affichage par nom d’entreprise et une recherche 
   par CIN / prénom / nom / email ou bien une jointure des filtres. Il faut créer un plan du test pour toutes les fonctionnalités de l’application utilisant jUnit
    
## Page 2 / onglet 4  : Statistiques (help ressource 2)

<img width="100%" align="right" alt="Github" src="https://github.com/Moussatef/JavaFx_Mutuelle_Centralisee/blob/main/src/main/resources/com/example/demo1/assets/Screenshot_59.png" />

- Ajouter l’attribut (date de l’inscription) dans la table client pour tracer les clients par date, et ajouter un graphe (chart) de votre choix qui va démontrer le nombre d’inscription par date.

### Les informations du client sont :
   - N° badge de travail : champ texte (10 charactères)
   - Nom d’entreprise : champ texte (Max 50 charactères)
   - Date de début de travail : Date picker.
   - Prénom : champ texte (Max 50 charactères)
   - Nom : champ texte (Max 50 charactères)
   - CIN ou bien N° Passeport : radios Button pour choisir et après un champ texte (8 charactères) sous format de (deux lettres et 6 chiffres) si CIN et (deux lettres et 7 chiffres) si passeport.
   - Téléphone : liste déroulante pour choisir le code pays (+212…) et un champ texte pour le numéro commence directement par (6 ou bien 7 …) (9 chiffres). [La liste des codes pays sous format JSON dans ressource 3].
   - Email : champ texte qui respecte le format d’email.
   - Adresse : champ texte (textarea).
   
   Page 2 / onglet 2 : (Afficher les client enregistrés)
    - Une grille pour afficher les informations des clients.
  ## Critères de performance  
  - Les classes sont bien structuré.
  - Les interfaces graphiques sont bien crées.
  - Le code source est complété selon les consignes et respecte les bonne pratique du développement Java.
  - Le code de doit être bien organisé.
  - l'implémentation des interfaces / classes / couche DAO est bien faite.
  
  
  
  
  
