package org.ldv.sahazawear.service

import org.ldv.sahazawear.model.dao.*
import org.ldv.sahazawear.model.entity.*
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(
    private val roleDAO: RoleDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val tailleDAO: TailleDAO,
    private val couleurDAO: CouleurDAO,
    private val produitDAO: ProduitDAO,
    private val varianteDAO: VarianteDAO,
    private val imageDAO: ImageDAO,
    private val avisDAO: AvisDAO,
    private val panierDAO: PanierDAO,
    private val commandeDAO: CommandeDAO,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Empêche de réinitialiser à chaque lancement
        if (roleDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données SahazaWear...")

        // ========== 1. RÔLES ==========
        val roleAdmin = roleDAO.save(Role(id = null, nom = "ADMIN"))
        val roleClient = roleDAO.save(Role(id = null, nom = "CLIENT"))

        // ========== 2. UTILISATEURS ==========
        val admin = Utilisateur(
            id = null,
            nom = "Admin SahazaWear",
            email = "admin@sahazawear.com",
            mdp = passwordEncoder.encode("admin123"),
            dateCreation = LocalDate.now(),
            dateModification = LocalDate.now(),
            role = roleAdmin
        )

        val client1 = Utilisateur(
            id = null,
            nom = "Client  Essai",
            email = "client.essai@email.com",
            mdp = passwordEncoder.encode("client123"),
            dateCreation = LocalDate.now().minusDays(30),
            dateModification = LocalDate.now().minusDays(30),
            role = roleClient
        )

        val client2 = Utilisateur(
            id = null,
            nom = "Client Test",
            email = "client.test@email.com",
            mdp = passwordEncoder.encode("client123"),
            dateCreation = LocalDate.now().minusDays(15),
            dateModification = LocalDate.now().minusDays(15),
            role = roleClient
        )

        utilisateurDAO.saveAll(listOf(admin, client1, client2))
        // ========================================
        // 2. CRÉATION DES TAILLES
        // ========================================
        println("📏 Création des tailles...")
        val tailleS = Taille(id = null, nom = "S")
        val tailleM = Taille(id = null, nom = "M")
        val tailleL = Taille(id = null, nom = "L")
        val tailleXL = Taille(id = null, nom = "XL")
        val tailleXXL = Taille(id = null, nom = "XXL")
        tailleDAO.saveAll(listOf(tailleS, tailleM, tailleL, tailleXL, tailleXXL))

        // ========================================
        // 3. CRÉATION DES COULEURS
        // ========================================
        println("🎨 Création des couleurs...")
        val couleurNoir = Couleur(id = null, nom = "Noir", codeHexadecimal = "#000000")
        val couleurBlanc = Couleur(id = null, nom = "Blanc", codeHexadecimal = "#FFFFFF")
        val couleurGris = Couleur(id = null, nom = "Gris", codeHexadecimal = "#808080")
        val couleurBleu = Couleur(id = null, nom = "Bleu Marine", codeHexadecimal = "#1E3A8A")
        val couleurRouge = Couleur(id = null, nom = "Rouge", codeHexadecimal = "#DC2626")
        couleurDAO.saveAll(listOf(couleurNoir, couleurBlanc, couleurGris, couleurBleu, couleurRouge))

        // ========================================
        // 5. CRÉATION DES PANIERS POUR LES UTILISATEURS
        // ========================================
        println("🛒 Création des paniers...")
        val panierClient1 = Panier(
            id = null,
            dateCreation = LocalDate.now().minusDays(30),
            dateModification = LocalDate.now(),
            utilisateur = client1
        )

        val panierClient2 = Panier(
            id = null,
            dateCreation = LocalDate.now().minusDays(15),
            dateModification = LocalDate.now(),
            utilisateur = client2
        )

        panierDAO.saveAll(listOf(panierClient1, panierClient2))

        // ========================================
        // 6. CRÉATION DES PRODUITS
        // ========================================
        println("👕 Création des produits...")

        val produit1 = Produit(
            id = null,
            nom = "T-shirt Essential",
            description = "T-shirt basique en coton premium, parfait pour le quotidien. Coupe ajustée et confortable.",
            prix = 29.99,
            categorie = "T-shirts",

        )

        val produit2 = Produit(
            id = null,
            nom = "Hoodie Urban",
            description = "Sweat à capuche streetwear avec logo brodé. Matière douce et chaude.",
            prix = 59.99,
            categorie = "Sweats",

        )

        val produit3 = Produit(
            id = null,
            nom = "Jean Slim Fit",
            description = "Jean slim moderne avec stretch pour plus de confort. Disponible en plusieurs couleurs.",
            prix = 79.99,
            categorie = "Pantalons",

        )

        val produit4 = Produit(
            id = null,
            nom = "Casquette Logo",
            description = "Casquette snapback avec logo SahazaWear brodé. Style urbain intemporel.",
            prix = 24.99,
            categorie = "Accessoires",

        )

        val produit5 = Produit(
            id = null,
            nom = "Veste Bomber",
            description = "Veste bomber élégante avec doublure satinée. Coupe moderne et confortable.",
            prix = 99.99,
            categorie = "Vestes",

        )

        produitDAO.saveAll(listOf(produit1, produit2, produit3, produit4, produit5))

        // ========================================
        // 7. CRÉATION DES IMAGES
        // ========================================
        println("📷 Création des images...")

        val imagesProduit1 = listOf(
            Image(id = null, chemin = "/img/produits/t-shirt_noir.jpg", estPrincipale = true, produit = produit1),
            Image(id = null, chemin = "/img/produits/t-shirt_blanc.jpg", estPrincipale = false, produit = produit1)
        )

        val imagesProduit2 = listOf(
            Image(id = null, chemin = "/img/produits/hoodie-blanc.jpg", estPrincipale = true, produit = produit2),
            Image(id = null, chemin = "/img/produits/hoodie-noir.jpg", estPrincipale = false, produit = produit2)
        )

        val imagesProduit3 = listOf(
            Image(id = null, chemin = "/img/produits/jean-noir.png", estPrincipale = true, produit = produit3)
        )

        val imagesProduit4 = listOf(
            Image(id = null, chemin = "/img/produits/casquette.jpg", estPrincipale = true, produit = produit4)
        )

        val imagesProduit5 = listOf(
            Image(id = null, chemin = "/img/produits/veste.png", estPrincipale = true, produit = produit5)
        )

        imageDAO.saveAll(imagesProduit1 + imagesProduit2 + imagesProduit3 + imagesProduit4 + imagesProduit5)

        // ========================================
        // 8. CRÉATION DES VARIANTES
        // ========================================
        println("🔀 Création des variantes...")

        // Variantes T-shirt Essential (Noir & Blanc, S-XL)
        val variantesTshirt = mutableListOf<Variante>()
        listOf(couleurNoir, couleurBlanc).forEach { couleur ->
            listOf(tailleS, tailleM, tailleL, tailleXL).forEach { taille ->
                variantesTshirt.add(
                    Variante(
                        id = null,
                        stock = (10..50).random(),
                        produit = produit1,
                        taille = taille,
                        couleur = couleur
                    )
                )
            }
        }

        // Variantes Hoodie Urban (Noir & Gris, M-XXL)
        val variantesHoodie = mutableListOf<Variante>()
        listOf(couleurNoir, couleurGris).forEach { couleur ->
            listOf(tailleM, tailleL, tailleXL, tailleXXL).forEach { taille ->
                variantesHoodie.add(
                    Variante(
                        id = null,
                        stock = (5..30).random(),
                        produit = produit2,
                        taille = taille,
                        couleur = couleur
                    )
                )
            }
        }

        // Variantes Jean (Bleu, S-XL)
        val variantesJean = listOf(tailleS, tailleM, tailleL, tailleXL).map { taille ->
            Variante(
                id = null,
                stock = (15..40).random(),
                produit = produit3,
                taille = taille,
                couleur = couleurBleu
            )
        }

        // Variantes Casquette (Noir, Taille unique = M)
        val varianteCasquette = Variante(
            id = null,
            stock = 50,
            produit = produit4,
            taille = tailleM,
            couleur = couleurNoir
        )

        // Variantes Veste (Noir, M-XL)
        val variantesVeste = listOf(tailleM, tailleL, tailleXL).map { taille ->
            Variante(
                id = null,
                stock = (8..20).random(),
                produit = produit5,
                taille = taille,
                couleur = couleurNoir
            )
        }

        varianteDAO.saveAll(
            variantesTshirt + variantesHoodie + variantesJean + listOf(varianteCasquette) + variantesVeste
        )

        // ========================================
        // 9. CRÉATION DES AVIS
        // ========================================
        println("⭐ Création des avis...")

        val avis1 = Avis(
            id = null,
            commentaire = "Super t-shirt ! La qualité est au rendez-vous, je recommande.",
            note = 5,
            dateCreation = LocalDate.now().minusDays(10),
            dateModification = LocalDate.now().minusDays(10),
            produit = produit1,
            utilisateur = client1
        )

        val avis2 = Avis(
            id = null,
            commentaire = "Très confortable et stylé. Le hoodie est parfait pour l'hiver.",
            note = 5,
            dateCreation = LocalDate.now().minusDays(8),
            dateModification = LocalDate.now().minusDays(8),
            produit = produit2,
            utilisateur = client2
        )

        val avis3 = Avis(
            id = null,
            commentaire = "Bon jean mais la coupe est un peu serrée. Prenez une taille au-dessus.",
            note = 4,
            dateCreation = LocalDate.now().minusDays(5),
            dateModification = LocalDate.now().minusDays(5),
            produit = produit3,
            utilisateur = client1
        )

        val avis4 = Avis(
            id = null,
            commentaire = "Belle casquette, logo bien brodé. Rapport qualité-prix excellent.",
            note = 5,
            dateCreation = LocalDate.now().minusDays(3),
            dateModification = LocalDate.now().minusDays(3),
            produit = produit4,
            utilisateur = client2
        )

        avisDAO.saveAll(listOf(avis1, avis2, avis3, avis4))

        // ========================================
        // 10. CRÉATION D'UNE COMMANDE EXEMPLE
        // ========================================
        println("📦 Création d'une commande exemple...")

        val commande1 = Commande(
            id = null,
            dateCommande = LocalDate.now().minusDays(7),
            dateCreation = LocalDate.now().minusDays(7),
            dateModification = LocalDate.now().minusDays(5),
            montantTotal = 89.98,
            statut = "Livrée",
            utilisateur = client1
        )

        commandeDAO.save(commande1)

        // ========================================
        // RÉSUMÉ
        // ========================================
        println("✅ Données initiales insérées :")
        println("   - ${roleDAO.count()} rôles")
        println("   - ${utilisateurDAO.count()} utilisateurs")
        println("   - ${tailleDAO.count()} tailles")
        println("   - ${couleurDAO.count()} couleurs")
        println("   - ${produitDAO.count()} produits")
        println("   - ${varianteDAO.count()} variantes")
        println("   - ${imageDAO.count()} images")
        println("   - ${avisDAO.count()} avis")
        println("   - ${panierDAO.count()} paniers")
        println("   - ${commandeDAO.count()} commande(s)")
        println("🎉 Initialisation terminée avec succès !")
    }
}