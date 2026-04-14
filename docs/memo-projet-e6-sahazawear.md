**Mémo projet E6 — SahazaWear**  
**1. Présentation rapide du projet**  
- **Nom du projet :** SahazaWear  
- **Objectif métier :** application web e-commerce de vente de vêtements homme avec un espace visiteur, un espace client, et un back-office administrateur.  
- **Technos utilisées :** Kotlin, Spring Boot, Spring Security, JPA / Hibernate, Thymeleaf, HTML, CSS, Bootstrap, MariaDB.  
- **Architecture générale :** application MVC monolithique Spring Boot.  
- **Lancement :** application Spring Boot sur localhost:8080.  
- **Lien GitHub :**https://github.com/sahaza77/ProjetSahazaWear  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSNBCkLfE07YGfHAiAU2QtIq6DIzW7UHAMBfnGt1V8fXEwAAXrse4eQF6VhvmPsAAAAASUVORK5CYII=)  
**2. Arborescence utile**  
**Racine**  
- build.gradle.kts : dépendances et configuration Gradle.  
- readme.md : présentation du projet.  
- src/main/resources/application.properties : configuration BDD, driver, JPA.  
**Contrôleurs**  
- src/main/kotlin/org/ldv/sahazawear/controller/MainController.kt  
- src/main/kotlin/org/ldv/sahazawear/controller/admincontrollers/AdminController.kt  
- src/main/kotlin/org/ldv/sahazawear/controller/admincontrollers/AdminProduitController.kt  
- src/main/kotlin/org/ldv/sahazawear/controller/admincontrollers/AdminCouleurController.kt  
- src/main/kotlin/org/ldv/sahazawear/controller/admincontrollers/AdminCommandeController.kt  
- src/main/kotlin/org/ldv/sahazawear/controller/clientcontrollers/ClientController.kt  
- src/main/kotlin/org/ldv/sahazawear/controller/clientcontrollers/ClientPanierController.kt  
**Modèle**  
- src/main/kotlin/org/ldv/sahazawear/model/entity/ : entités JPA  
- src/main/kotlin/org/ldv/sahazawear/model/dao/ : DAO / repositories Spring Data  
**Services / sécurité**  
- src/main/kotlin/org/ldv/sahazawear/service/SecurityConfig.kt  
- src/main/kotlin/org/ldv/sahazawear/service/UserDetailsService.kt  
- src/main/kotlin/org/ldv/sahazawear/service/DataInitializer.kt  
**Vues Thymeleaf**  
- src/main/resources/templates/index.html  
- src/main/resources/templates/base.html  
- src/main/resources/templates/fragments.html  
- src/main/resources/templates/pagesVisiteur/  
- src/main/resources/templates/pagesClient/  
- src/main/resources/templates/pageAdmin/  
**Fichiers statiques**  
- src/main/resources/static/css/style.css  
- src/main/resources/static/img/  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OMQ2AABAAsSNBCkJfFSqwwIgHRiywEZJWQZeZ2ao9AAD+4lyruzq+ngAA8Nr1AOH8BeZxN/IIAAAAAElFTkSuQmCC)  
**3. Fonctionnement global de l’application**  
**Côté visiteur**  
- page d’accueil  
- page produits  
- page à propos  
- page contact  
- page inscription  
- page login  
- page RGPD  
**Côté client**  
- profil  
- futur panier / commandes  
- navigation après authentification  
**Côté admin**  
- dashboard  
- gestion des produits  
- gestion des couleurs  
- gestion des commandes  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OQQmAABRAsSd4NIGBzPXBmAawhhW8ibAl2DIze3UGAMBf3Gu1VcfXEwAAXrsehaQEN+8fLHEAAAAASUVORK5CYII=)  
**4. Fichiers clés à connaître absolument**  
build.gradle.kts  
- **Rôle :** définit les dépendances Spring Boot, Thymeleaf, JPA, Security, MariaDB.  
- **À modifier si :** problème de dépendance, driver MariaDB manquant, ajout d’une librairie.  
- **Point important :** le driver MariaDB est bien présent :  
- implementation("org.mariadb.jdbc:mariadb-java-client:3.5.8")  
   
src/main/resources/application.properties  
- **Rôle :** configuration de la base de données.  
- **À modifier si :** la base ne démarre pas, changement de serveur, changement d’utilisateur.  
- **Point important :**  
- URL MariaDB distante  
- spring.jpa.hibernate.ddl-auto=create-drop  
- **Risque :**create-drop recrée la base au démarrage et peut supprimer les données à l’arrêt.  
MainController.kt  
- **Rôle :** gère les routes principales du visiteur.  
- **Routes déjà présentes :**  
- /SahazaWear  
- /a-propos  
- /contact  
- /inscription  
- /produits  
- /rgpd  
- /SahazaWear/login  
- /SahazaWear/profil  
- **À modifier si :** on ajoute une page publique, une page client simple, ou la logique de redirection après login.  
SecurityConfig.kt  
- **Rôle :** protège les routes avec Spring Security.  
- **À modifier si :** on veut rendre une page publique ou réserver une page à l’admin.  
- **Point important actuel :**  
- seules quelques routes sont publiques  
- anyRequest().authenticated()  
- login personnalisé sur /SahazaWear/login  
MyUserDetailsService.kt  
- **Rôle :** charge un utilisateur depuis la base par email pour l’authentification.  
- **À modifier si :** problème de login, changement du champ de connexion, gestion du rôle.  
DataInitializer.kt  
- **Rôle :** génère des données de test au démarrage.  
- **À modifier si :** on veut changer les comptes de démonstration, ajouter des produits, couleurs, tailles ou variantes.  
- **Identifiants utiles :**  
- admin : admin@sahazawear.com / admin123  
- clients tests : client.essai@email.com / client123, etc.  
AdminProduitController.kt  
- **Rôle :** CRUD admin des produits.  
- **Actions présentes :**  
- liste  
- détail  
- formulaire de création  
- enregistrement  
- formulaire de modification  
- mise à jour  
- suppression  
- **À modifier si :** le jury demande une évolution sur la gestion des produits.  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANElEQVR4nO3OQQmAABRAsad4FCtY9ecwnkms4E2ELcGWmTmrKwAA/uLeqrU6vp4AAPDa/gDzUgM9+S8z3AAAAABJRU5ErkJggg==)  
**5. Entités importantes à connaître**  
Produit  
- **Rôle :** article vendu.  
- **Champs clés :**id, nom, description, prix, categorie  
- **Utilisé dans :** page produits, admin produits, variantes, images.  
Utilisateur  
- **Rôle :** compte connecté.  
- **Champs clés :**id, nom, email, mdp, dateCreation, dateModification, role  
- **Utilisé dans :** sécurité, profil, commandes, panier.  
Role  
- **Rôle :** autorisation de l’utilisateur.  
- **Valeurs vues dans le projet :**ADMIN, CLIENT  
Variante  
- **Rôle :** déclinaison d’un produit selon taille / couleur / stock.  
- **Utilité E6 :** si le sujet touche le stock, les tailles ou couleurs, il faut souvent passer par cette entité.  
Image  
- **Rôle :** images associées à un produit.  
- **Champs clés :** chemin, image principale ou non.  
Commande  
- **Rôle :** achat du client.  
- **Utilité E6 :** si le sujet touche le suivi des commandes ou les statistiques admin.  
Panier** et **LignePanier  
- **Rôle :** futur panier client.  
- **Point important :**ClientPanierController.kt est encore vide, donc si un sujet parle panier, il y a de fortes chances que ce soit une fonctionnalité à compléter.  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANElEQVR4nO3OQQmAABRAsSdYxKa/jL0MIR7FCt5E2BJsmZmt2gMA4C+Otbqr8+sJAACvXQ85SAYUQNBTfQAAAABJRU5ErkJggg==)  
**6. DAO / repositories utiles**  
- ProduitDAO  
- UtilisateurDAO  
- CommandeDAO  
- CouleurDAO  
- TailleDAO  
- VarianteDAO  
- ImageDAO  
- PanierDAO  
- LignePanierDAO  
- LigneCommandeDAO  
- AvisDAO  
- RoleDAO  
**Quand modifier un DAO ?**  
- pour ajouter une recherche personnalisée  
- pour filtrer des produits  
- pour compter des éléments  
- pour faire une sélection métier spécifique  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSNhZscaUpheJwqQgQU2QtIq6DIze3UGAMBf3Gu1VcfXEwAAXrseopcEQ2uoYnwAAAAASUVORK5CYII=)  
**7. Templates utiles**  
**Visiteur**  
- templates/index.html  
- templates/pagesVisiteur/produits.html  
- templates/pagesVisiteur/login.html  
- templates/pagesVisiteur/inscription.html  
- templates/pagesVisiteur/a-propos.html  
- templates/pagesVisiteur/contact.html  
- templates/pagesVisiteur/rgpd.html  
**Client**  
- templates/pagesClient/profile.html  
**Admin**  
- templates/pageAdmin/dashboard.html  
- templates/pageAdmin/produit/indexProduit.html  
- templates/pageAdmin/produit/showProduit.html  
- templates/pageAdmin/produit/createProduit.html  
- templates/pageAdmin/produit/editProduit.html  
- templates/pageAdmin/couleurs/indexCouleur.html  
- templates/pageAdmin/couleurs/createCouleur.html  
- templates/pageAdmin/couleurs/editCouleur.html  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANElEQVR4nO3OQQmAABRAsad4FCtY9ecwnkms4E2ELcGWmTmrKwAA/uLeqrU6vp4AAPDa/gDzUgM9+S8z3AAAAABJRU5ErkJggg==)  
**8. Où modifier selon le besoin**  
**Si on me demande d’ajouter une page**  
- contrôleur concerné  
- template Thymeleaf correspondant  
- éventuellement lien dans fragments.html  
**Si on me demande d’ajouter un champ dans un formulaire**  
- template HTML Thymeleaf  
- entité JPA  
- parfois contrôleur  
- parfois base de données / initialisation  
**Si on me demande d’ajouter un bouton**  
- template Thymeleaf  
- méthode du contrôleur reliée  
- éventuellement nouvelle route @PostMapping ou @GetMapping  
**Si on me demande une suppression**  
- bouton ou formulaire HTML  
- route @PostMapping ou @DeleteMapping  
- DAO avec deleteById() ou logique personnalisée  
**Si on me demande un tri / filtre / recherche**  
- contrôleur pour recevoir paramètre  
- DAO pour requête  
- template pour le formulaire et l’affichage  
**Si on me demande une statistique**  
- souvent contrôleur admin  
- éventuellement DAO avec count()  
- affichage dans dashboard ou template dédié  
**Si on me demande une restriction d’accès**  
- SecurityConfig.kt  
- éventuellement test du rôle dans le contrôleur  
- éventuellement adaptation du menu affiché  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANElEQVR4nO3OQQmAUBBAwSf8GGLWDWFDY3ixgjcRZhLMNjNHdQYAwF9cq1rV/vUEAIDX7gcRXAQ2s/16gwAAAABJRU5ErkJggg==)  
**9. Routes déjà présentes**  
**Visiteur**  
- GET /SahazaWear  
- GET /a-propos  
- GET /contact  
- GET /inscription  
- GET /produits  
- GET /rgpd  
- GET /SahazaWear/login  
**Après login**  
- GET /SahazaWear/profil  
**Admin**  
- GET /SahazaWear/admin/dashboard  
- GET /SahazaWear/admin/produits  
- GET /SahazaWear/admin/produits/{id}  
- GET /SahazaWear/admin/produits/create  
- POST /SahazaWear/admin/produits  
- GET /SahazaWear/admin/produits/edit/{id}  
- POST /SahazaWear/admin/produits/update  
- POST /SahazaWear/admin/produits/delete  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OMQ2AABAAsSPBCj7fFRYQwYwEZiywEZJWQZeZ2ao9AAD+4lyruzq+ngAA8Nr1AMTJBeJDClAyAAAAAElFTkSuQmCC)  
**10. Logique de sécurité à connaître**  
**Ce qui est public**  
Dans SecurityConfig.kt, seules certaines routes sont autorisées sans connexion :  
- /SahazaWear/login  
- /css/**  
- /js/**  
- /img/**  
**Ce qui est protégé**  
Tout le reste :  
it.anyRequest().authenticated()  
   
**Conséquence importante**  
Actuellement, des pages comme /produits, /contact, /a-propos, /inscription passent aussi dans les routes authentifiées si elles ne sont pas ajoutées dans permitAll().  
   
 C’est un point très intéressant à expliquer si le jury te demande pourquoi certaines pages ne s’affichent pas en visiteur.  
**Redirection après login**  
- admin → /SahazaWear/admin/dashboard  
- client → page profil  
La logique est dans MainController.kt dans la méthode profile(authentication).  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OMQ2AABAAsSNBACPq8MH2NpGACyywEZJWQZeZ2aszAAD+4l6rrTq+ngAA8Nr1AL/KBEe6dElaAAAAAElFTkSuQmCC)  
**11. Bugs / pièges connus**  
- la BDD est configurée sur un serveur distant dans application.properties  
- create-drop peut réinitialiser les données  
- si MariaDB n’est pas accessible, l’application ne démarre pas  
- beaucoup de pages publiques métier ne sont pas encore explicitement mises en permitAll()  
- ClientPanierController.kt est vide  
- ClientController.kt est vide  
- si le jury te demande une fonctionnalité panier ou client avancée, il faudra probablement créer la logique  
- le projet utilise Thymeleaf, donc une évolution simple se fait souvent dans le contrôleur + template, pas dans un front séparé  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSNBCUpfD6ZYGZDAgAU2QtIq6DIzW7UHAMBfHGt1V+fXEwAAXrseHCoGAe/SKtAAAAAASUVORK5CYII=)  
**12. Tests utiles pour l’épreuve**  
**Test 1 — accès page d’accueil**  
- **Précondition :** application lancée  
- **Action :** ouvrir /SahazaWear  
- **Résultat attendu :** affichage de la page d’accueil ou redirection selon la sécurité actuelle  
**Test 2 — connexion admin**  
- **Précondition :** données initialisées  
- **Action :** se connecter avec admin  
- **Résultat attendu :** redirection vers /SahazaWear/admin/dashboard  
**Test 3 — affichage des produits admin**  
- **Précondition :** admin connecté  
- **Action :** aller sur /SahazaWear/admin/produits  
- **Résultat attendu :** liste des produits  
**Test 4 — création produit**  
- **Précondition :** admin connecté  
- **Action :** créer un produit via le formulaire  
- **Résultat attendu :** produit ajouté en base et visible dans la liste  
**Test 5 — modification produit**  
- **Précondition :** un produit existe  
- **Action :** modifier le nom ou le prix  
- **Résultat attendu :** changement visible dans la liste ou la fiche produit  
**Test 6 — suppression produit**  
- **Précondition :** un produit existe  
- **Action :** supprimer le produit  
- **Résultat attendu :** il disparaît de la liste  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSPBCj5fFyM6mJHAjAU2QtIq6DIzW7UHAMBfnGt1V8fXEwAAXrsexOEF35f1aEgAAAAASUVORK5CYII=)  
**13. Questions probables du jury + réponses prêtes**  
**1. Pourquoi avoir utilisé Spring Security ?**  
*Pour sécuriser l’accès aux pages sensibles, gérer le login, le logout et les rôles sans devoir coder toute la sécurité manuellement.*  
**2. Quel est le rôle de **MyUserDetailsService ** ?**  
*Il permet à Spring Security de charger un utilisateur depuis la base à partir de son email, puis de lui associer son mot de passe et son rôle.*  
**3. Pourquoi utiliser BCrypt ?**  
*Parce que les mots de passe ne doivent jamais être stockés en clair. BCrypt permet de les hasher de manière sécurisée.*  
**4. Pourquoi utiliser Thymeleaf ?**  
*Parce que c’est bien adapté à une application Spring MVC côté serveur. Il permet de générer des vues dynamiques directement à partir des données du contrôleur.*  
**5. Pourquoi utiliser des entités + DAO ?**  
*Les entités modélisent la base de données et les DAO simplifient l’accès aux données avec Spring Data JPA.*  
**6. Quelle différence entre visiteur, client et admin ?**  
*Le visiteur consulte sans être connecté, le client a un compte utilisateur, et l’admin a des droits supplémentaires pour gérer les données du site.*  
**7. Pourquoi certaines routes doivent être dans **permitAll() ** ?**  
*Parce qu’une boutique e-commerce doit laisser accessibles certaines pages publiques comme l’accueil, les produits, l’inscription ou le contact.*  
**8. Pourquoi **create-drop ** peut être dangereux ?**  
*Parce qu’il recrée le schéma à chaque démarrage et peut donc effacer les données si on n’est pas dans un contexte de test.*  
**9. Si le jury te demande d’ajouter une recherche produit, tu modifies quoi ?**  
*Le contrôleur pour récupérer le mot-clé, le DAO pour faire la requête, puis le template pour afficher le champ de recherche et les résultats.*  
**10. Si le jury te demande d’ajouter une page panier, tu commences par quoi ?**  
*Je repère d’abord l’existant côté entités et DAO, puis je complète * *ClientPanierController.kt* *, j’ajoute les routes, et je crée le template associé.*  
**11. Pourquoi passer par un contrôleur au lieu de mettre toute la logique dans le HTML ?**  
*Parce que le contrôleur sépare la logique métier de l’affichage et prépare les données proprement pour la vue.*  
**12. Pourquoi utiliser un **RedirectAttributes ** après création ou suppression ?**  
*Pour renvoyer un message de confirmation après la redirection sans recharger la même requête de formulaire.*  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OMQ2AABAAsSNBACMC0cD8NpGACyywEZJWQZeZ2aszAAD+4l6rrTq+ngAA8Nr1AL+yBEpU09MiAAAAAElFTkSuQmCC)  
**14. Modifications possibles à préparer à l’avance**  
- rendre les pages visiteur vraiment publiques dans SecurityConfig.kt  
- ajouter une recherche de produits par nom  
- ajouter un filtre par catégorie  
- ajouter un compteur du nombre total de produits dans le dashboard  
- afficher le nombre d’utilisateurs dans le dashboard  
- ajouter une confirmation avant suppression d’un produit  
- ajouter une page détail produit côté visiteur  
- ajouter un panier client  
- ajouter un formulaire d’inscription complet avec enregistrement en base  
- ajouter une page liste des commandes admin  
- ajouter un message si la liste des produits est vide  
- ajouter un tri par prix croissant / décroissant  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OQQmAABRAsSfYxKK/kYXEkyk8WcGbCFuCLTOzVXsAAPzFuVZ3dXw9AQDgtesB/v8F8JQadPwAAAAASUVORK5CYII=)  
**15. Sujet d’entraînement type E6 — comment raisonner sur SahazaWear**  
Même si ton sujet d’entraînement précédent était sur SavApp, la logique E6 est la même :  
1. comprendre la nouvelle fonctionnalité  
2. repérer si elle touche l’affichage, le contrôleur, la sécurité, le DAO ou la base  
3. faire une petite maquette si besoin  
4. modifier les bons fichiers  
5. tester  
6. préparer 2 ou 3 scénarios de recette  
**Exemple 1 : “ajouter une recherche produit”**  
**Fichiers exacts à toucher :**  
- MainController.kt  
- ProduitDAO.kt  
- templates/pagesVisiteur/produits.html  
**Méthode :**  
- ajouter un @RequestParam  
- filtrer les produits  
- renvoyer la liste filtrée au template  
- ajouter le champ de recherche au HTML  
**Exemple 2 : “ajouter une confirmation avant suppression d’un produit”**  
**Fichiers exacts à toucher :**  
- templates/pageAdmin/produit/indexProduit.html  
- éventuellement showProduit.html  
**Méthode :**  
- ajouter onclick="return confirm('...')" sur le formulaire de suppression  
**Exemple 3 : “rendre les pages produits accessibles sans login”**  
**Fichier exact :**  
- SecurityConfig.kt  
**Méthode :**  
- ajouter /SahazaWear, /produits, /a-propos, /contact, /inscription, /rgpd dans permitAll()  
Exemple :  
it.requestMatchers(  
     "/SahazaWear",  
     "/SahazaWear/login",  
     "/a-propos",  
     "/contact",  
     "/inscription",  
     "/produits",  
     "/rgpd",  
     "/css/**",  
     "/js/**",  
     "/img/**"  
 ).permitAll()  
   
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OMQ2AABAAsSNhYMEBIpD4ArCJDyywEZJWQZeZOaorAAD+4l6rrTq/ngAA8Nr+AEqmA1hl45m5AAAAAElFTkSuQmCC)  
**16. Raccourci “où toucher ?”**  
| | | |  
|-|-|-|  
| **Demande** | **Fichier(s) probables** | **Action** |   
| Ajouter une page | contrôleur + template | route + vue |   
| Ajouter un bouton | template | relier au contrôleur |   
| Ajouter un champ de formulaire | template + entité + contrôleur | stocker / traiter |   
| Ajouter un CRUD produit | AdminProduitController + templates + DAO | créer la route et la persistance |   
| Ajouter une recherche | contrôleur + DAO + template | paramètre + requête + affichage |   
| Ajouter un filtre | contrôleur + DAO + template | filtrer la liste |   
| Modifier l’accès à une page | SecurityConfig.kt | permitAll() ou restriction |   
| Corriger le login | SecurityConfig.kt + MyUserDetailsService.kt | auth / user loading |   
| Ajouter une donnée de test | DataInitializer.kt | seed au démarrage |   
| Ajouter panier | ClientPanierController.kt + templates + DAO | logique client |   
   
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OUQmAABBAsSeYxZyXSzCJASxgACv4J8KWYMvMbNURAAB/ca7VXe1fTwAAeO16AKe+BdmJqrPdAAAAAElFTkSuQmCC)  
**17. Réponses prêtes pour l’oral**  
**Présentation rapide du projet**  
SahazaWear est une application web e-commerce développée en Kotlin avec Spring Boot. Elle suit une architecture MVC avec des vues Thymeleaf, une base MariaDB, et une sécurité gérée par Spring Security. L’application permet la consultation de produits, l’authentification des utilisateurs et une administration des produits.  
**Où intervenir si le jury demande une évolution**  
Je commence par repérer si la demande concerne une page, une action métier, une restriction de sécurité ou un accès base de données. Ensuite, je regarde le contrôleur concerné, le template associé, puis le DAO si une requête spécifique est nécessaire.  
**Comment je vérifie que ça fonctionne**  
Je teste d’abord le cas nominal, puis les cas limites. Par exemple : utilisateur connecté ou non, liste vide, suppression, redirection après action, et cohérence entre affichage et base de données.  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AUBBAsUfyNTCi9VwgEA3sWGAjJK2CbjNzVGcAAPzFtapV7V9PAAB47X4AEW4ELQDBN+AAAAAASUVORK5CYII=)  
**18. Méthode E6 le jour J**  
1. lire la consigne  
2. repérer si c’est MVC vue / contrôleur / sécurité / base  
3. ouvrir les bons fichiers  
4. coder petit à petit  
5. tester directement  
6. noter 2 scénarios de recette  
7. préparer l’explication orale  
