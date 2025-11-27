package org.ldv.sahazawear.controller

import org.ldv.sahazawear.model.dao.ProduitDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.security.core.Authentication


@Controller
class MainController (val produitDAO: ProduitDAO){

    /**
     * Page d'accueil
     */
    @GetMapping("/SahazaWear")
    fun home(model: Model): String {

        return "index"
    }

    /**
     * Page À propos
     */
    @GetMapping("/a-propos")
    fun aPropos(): String {
        return "pagesVisiteur/a-propos"
    }

    /**
     * Page Contact
     */
    @GetMapping("/contact")
    fun contact(): String {
        return "pagesVisiteur/contact"
    }

    /**
     * Page Inscription
     */
    @GetMapping("/inscription")
    fun inscription(): String {
        return "pagesVisiteur/inscription"
    }

    /**
     * Page Produits
     */
    @GetMapping("/produits")
    fun produits(model: Model): String {
        var produits = produitDAO.findAll()
        model.addAttribute("produits",produits)
        return "pagesVisiteur/produits"
    }

    /**
     * Page RGPD
     */
    @GetMapping("/rgpd")
    fun rgpd(): String {
        return "pagesVisiteur/rgpd"
    }

    /**
     * Page Login personnalisée
     */
    @GetMapping("/SahazaWear/login")
    fun login(@RequestParam(required = false) error: Boolean?, model: Model): String {
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }
    @GetMapping("/SahazaWear/profil")
    fun profile(authentication: Authentication): String {

        val roles = authentication.authorities.map { it.authority }

        // Si admin → redirection vers dashboard admin
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/SahazaWear/admin/dashboard"
        }

        // Sinon afficher la page profil client
        return "pagesClient/profile"
    }
}