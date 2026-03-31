# SahazaWear

## Présentation

SahazaWear est une application web e-commerce full-stack développée dans le cadre de mon BTS SIO option SLAM.

Le projet a pour objectif de proposer une plateforme de vente de vêtements pour hommes, avec une gestion complète des produits, des utilisateurs et des commandes.

L’application comprend :
- un front-office (interface utilisateur)
- un back-office administrateur
- un système d’authentification sécurisé
- une gestion dynamique des données (produits, variantes, images, commandes)

---

## Objectifs du projet

Ce projet m’a permis de :

- Concevoir une application web complète (front + back)
- Mettre en place une architecture MVC
- Gérer une base de données relationnelle
- Implémenter un système d’authentification sécurisé
- Travailler sur un projet structuré en plusieurs fonctionnalités (sprints)

---

## Fonctionnalités principales

### Utilisateur
- Inscription et connexion sécurisée
- Consultation des produits
- Affichage des détails d’un produit
- Ajout au panier
- Passage de commande

### Administrateur
- Gestion des produits (CRUD)
- Gestion des images
- Gestion des variantes (taille, couleur, stock)
- Gestion des utilisateurs
- Gestion des commandes

---

## Technologies utilisées

### Back-end
- Kotlin
- Spring Boot
- Spring Security
- JPA / Hibernate

### Front-end
- Thymeleaf
- HTML / CSS
- Bootstrap

### Base de données
- MariaDB

### Outils
- Git / GitHub
- IntelliJ IDEA

---

## Architecture

Le projet suit une architecture **MVC** :

- **Model** : entités (Produit, Utilisateur, Commande, Variante…)
- **View** : templates Thymeleaf
- **Controller** : gestion des routes et logique métier

---

## Base de données

La base de données comprend plusieurs entités :

- Produit
- Image
- Variante (taille, couleur, stock)
- Utilisateur
- Panier
- Commande
- Avis

Relations :
- Un produit → plusieurs images
- Un produit → plusieurs variantes
- Un utilisateur → plusieurs commandes

---

## Sécurité

- Authentification avec **Spring Security**
- Gestion des rôles (ADMIN / CLIENT)
- Protection des routes sensibles

---

## Installation du projet

### 1. Cloner le projet

```bash
git clone https://github.com/sahaza77/ProjetSahazaWear
```

2. Configurer la base de données
Créer une base MariaDB
Modifier le fichier application.properties :

spring.datasource.url=jdbc:mariadb://localhost:3306/sahazawear
spring.datasource.username=root
spring.datasource.password=*****


3. Lancer le projet
Ouvrir avec IntelliJ
Lancer la classe principale
Données de test

Le projet contient un DataInitializer qui crée automatiquement :

des utilisateurs (admin + clients)
des produits
des variantes
des images

src/
 ├── controller
 ├── service
 ├── model
 │    ├── entity
 │    └── dao
 ├── config
 └── resources
      ├── templates
      └── static


Réalisation

Ce projet a été réalisé majoritairement en autonomie dans le cadre de ma formation.

Une base initiale (Kotlin Monster) a été commencée en binôme, puis j’ai poursuivi et développé le projet seul.

Améliorations possibles
Système de paiement en ligne
Gestion avancée du panier
Filtrage dynamique des produits
Interface utilisateur améliorée
API REST
Auteur

Sahazaniaina Randrianasolo
BTS SIO option SLAM

Contact
Email : sahaza.pro@gmail.com
GitHub : https://github.com/sahaza77/ProjetSahazaWear

Conclusion

SahazaWear est un projet complet qui m’a permis de développer des compétences en développement full-stack, en gestion de base de données et en conception d’applications web professionnelles.
