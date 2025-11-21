package org.ldv.sahazawear.controller.admincontrollers

import org.ldv.sahazawear.model.dao.CouleurDAO
import org.ldv.sahazawear.model.dao.ProduitDAO
import org.ldv.sahazawear.model.entity.Produit
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDate

@Controller
class AdminProduitController(
    val produitDAO: ProduitDAO,
    val couleurDAO: CouleurDAO
) {

    @GetMapping("/sahazawear/admin/produits")
    fun index(model: Model): String {
        var produitsList = produitDAO.findAll()
        model.addAttribute("produits", produitsList)

        return "pageAdmin/produit/indexProduit"
    }
    @GetMapping("/sahazawear/admin/produits/{id}")
    fun show (@PathVariable id:Long, model: Model):String{
        val unProduit = produitDAO.findById(id).orElseThrow()
        model.addAttribute("produit",unProduit)
        return "pageAdmin/produit/showProduit"
    }
    @GetMapping("/sahazawear/admin/produits/create")
    fun create(model: Model): String{
        val nouveauProduit = Produit(id = null, nom = "", description = "", prix = 1.0, categorie = "", dateCreation = LocalDate.now(), dateModification = LocalDate.now())
        val couleur = couleurDAO.findAll()
        model.addAttribute("couleur",couleur)
        model.addAttribute("produit",nouveauProduit)
        return "pageAdmin/produit/createProduit"
    }
}