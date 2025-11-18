package org.ldv.sahazawear.controller.admincontrollers

import org.ldv.sahazawear.model.dao.ProduitDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminArticleControllerController (val produitDAO: ProduitDAO) {

    @GetMapping("/sahazawear/admin/produits")
    fun index(model: Model): String {
        var produitsList = produitDAO.findAll()
        model.addAttribute("produits", produitsList)

        return "pageAdmin/produit/indexProduit"
    }
}