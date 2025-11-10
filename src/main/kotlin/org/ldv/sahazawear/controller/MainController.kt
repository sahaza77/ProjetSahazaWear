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

}
