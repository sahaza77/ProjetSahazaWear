import org.ldv.sahazawear.model.dao.CouleurDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/SahazaWear/admin/couleurs")
class AdminCouleurController(
    private val couleurDAO: CouleurDAO
) {

    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("couleurs", couleurDAO.findAll())
        return "pageAdmin/couleurs/indexCouleur"
    }
}
