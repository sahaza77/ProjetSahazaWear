package org.ldv.sahazawear.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    /**
     * Méthode permettant d'afficher la page d'accueil du site SahazaWear.
     * @return le nom du template à afficher (sans .html)
     */
    @GetMapping("/Sahazawear")
    fun home(): String {
        return "index"  // <-- charge index.html depuis src/main/resources/templates
    }
    /**
     * Méthode permettant d'afficher la page "À propos".
     * @return le chemin vers le template (dans le dossier pagesVisiteur)
     */
    @GetMapping("/a-propos")
    fun aPropos(): String {
        return "pagesVisiteur/a-propos"  // <-- charge pagesVisiteur/a-propos.html
    }
    /**
     * Méthode permettant d'afficher la page de contact.
     * @return le chemin vers le template
     */
    @GetMapping("/contact")
    fun contact(): String {
        return "pagesVisiteur/contact"
    }

    /**
     * Méthode permettant d'afficher la page d'inscription.
     * @return le chemin vers le template
     */
    @GetMapping("/inscription")
    fun inscription(): String {
        return "pagesVisiteur/inscription"
    }

    /**
     * Méthode permettant d'afficher la page produits.
     * @return le chemin vers le template
     */
    @GetMapping("/produits")
    fun produits(): String {
        return "pagesVisiteur/produits"
    }

    /**
     * Méthode permettant d'afficher la politique de confidentialité (RGPD).
     * @return le chemin vers le template
     */
    @GetMapping("/rgpd")
    fun rgpd(): String {
        return "pagesVisiteur/rgpd"
    }
}