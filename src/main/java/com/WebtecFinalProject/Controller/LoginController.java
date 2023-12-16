package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Rank;
import com.WebtecFinalProject.Model.Soldier;
import com.WebtecFinalProject.Service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    SoldierService soldierService;

    @GetMapping("/soldiers")
    public String soldier(Model model){
        model.addAttribute("soldierModel",new Soldier());
        model.addAttribute("rank", Rank.values());
        return "Login";
    }

    @PostMapping("loginSoldier")
    public String loginSoldier(@ModelAttribute("soldierModel")Soldier soldier, Model model){
        Soldier loggedInSoldier = soldierService.loginSoldier(soldier);

        if (loggedInSoldier != null) {
            // Soldier found, proceed with login
            return "redirect:/dash";
        } else {
            // Soldier not found, add an error message to the model and redirect to login page
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/soldiers";
        }
    }
}
