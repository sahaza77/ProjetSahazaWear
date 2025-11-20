package org.ldv.sahazawear.controller.admincontrollers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("SahazaWear/admin/")
class AdminController {

    @GetMapping("/dashboard")
    fun adminHome(): String {
        return "pageAdmin/dashboard"
    }
}
