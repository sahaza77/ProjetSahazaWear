package org.ldv.sahazawear.controller.admincontrollers

import org.ldv.sahazawear.model.dao.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/SahazaWear/admin")
class AdminController(
    private val produitDAO: ProduitDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val commandeDAO: CommandeDAO,
    private val avisDAO: AvisDAO
) {

    @GetMapping("/dashboard")
    fun adminHome(model: Model): String {
        // Récupérer les statistiques
        model.addAttribute("produits", produitDAO.findAll())
        model.addAttribute("utilisateurs", utilisateurDAO.findAll())
        model.addAttribute("commandes", commandeDAO.findAll())
        model.addAttribute("avis", avisDAO.findAll())

        return "pageAdmin/dashboard"
    }
}