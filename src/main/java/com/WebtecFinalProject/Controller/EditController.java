package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Request;
import com.WebtecFinalProject.Model.Soldier;
import com.WebtecFinalProject.Service.GunService;
import com.WebtecFinalProject.Service.RequestService;
import com.WebtecFinalProject.Service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import java.util.UUID;

@Controller
public class EditController {

    @Autowired
    SoldierService soldierService;
    @Autowired
    RequestService requestService;
    @Autowired
    GunService gunService;

    @GetMapping("/editSoldier/{id}")
    public String editSoldierForm(@PathVariable("id") UUID id, Model model) {
        Optional<Soldier> optionalSoldier = soldierService.findById(id);
        if (optionalSoldier.isPresent()) {
            model.addAttribute("soldierModel", optionalSoldier.get());
            return "edit_soldier"; // Replace with your actual edit form template name
        } else {
            // Handle soldier not found
            return "redirect:/report";
        }
    }

}

