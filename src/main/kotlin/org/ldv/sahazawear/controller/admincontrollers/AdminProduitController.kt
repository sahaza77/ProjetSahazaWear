package org.ldv.sahazawear.controller.admincontrollers

import org.ldv.sahazawear.model.dao.CouleurDAO
import org.ldv.sahazawear.model.dao.ProduitDAO
import org.ldv.sahazawear.model.entity.Produit
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.time.LocalDate

@Controller
class AdminProduitController(
    val produitDAO: ProduitDAO,
    val couleurDAO: CouleurDAO
) {

    @GetMapping("/SahazaWear/admin/produits")
    fun index(model: Model): String {
        var produitsList = produitDAO.findAll()
        model.addAttribute("produits", produitsList)

        return "pageAdmin/produit/indexProduit"
    }
    @GetMapping("/SahazaWear/admin/produits/{id}")
    fun show (@PathVariable id:Long, model: Model):String{
        val unProduit = produitDAO.findById(id).orElseThrow()
        model.addAttribute("produit",unProduit)
        return "pageAdmin/produit/showProduit"
    }
    @GetMapping("/SahazaWear/admin/produits/create")
    fun create(model: Model): String {
        val nouveauProduit = Produit(
            id = null,
            nom = "",
            description = "",
            prix = 1.0,
            categorie = "",

        )
        model.addAttribute("produit", nouveauProduit)
        return "pageAdmin/produit/createProduit"
    }

@PostMapping("/SahazaWear/admin/produits")
fun store (@ModelAttribute produit: Produit, redirectAttributes: RedirectAttributes): String{
    produitDAO.save(produit)
    redirectAttributes.addFlashAttribute("msg", "L'article a bien été crée")
    return "redirect:/SahazaWear/admin/produits"
}

@GetMapping("/SahazaWear/admin/produits/edit/{id}")
fun edit (@PathVariable id:Long, model: Model): String {
    val produit = produitDAO.findById(id).orElseThrow()
    model.addAttribute("produit", produit)
    return "pageAdmin/produit/editProduit"
}
    @PostMapping("/SahazaWear/admin/produits/update")
    fun update (@ModelAttribute produit: Produit, redirectAttributes: RedirectAttributes):String{
        produitDAO.save(produit)
        redirectAttributes.addFlashAttribute("msg","L'article ${produit.nom} est modifier.")
        return "redirect:/SahazaWear/admin/produits"
    }

    @PostMapping("/SahazaWear/admin/produits/delete")
    fun delete (@RequestParam id: Long, redirectAttributes: RedirectAttributes):String{
        produitDAO.deleteById(id)
        redirectAttributes.addFlashAttribute("msg", "L'article est supprimer")
        return "redirect:/SahazaWear/admin/produits"
    }
}