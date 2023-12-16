package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Gun;
import com.WebtecFinalProject.Model.Guntype;
import com.WebtecFinalProject.Model.Manufacturer;
import com.WebtecFinalProject.Service.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GunController {
    @Autowired
    GunService gunService;

    @GetMapping("/gun")
    public String gun(Model model){
        model.addAttribute("gunModel",new Gun());
        model.addAttribute("guntype", Guntype.values());
        model.addAttribute("manufacturer", Manufacturer.values());
        return "Gun";
    }

    @PostMapping("createGun")
    public String createGun(@ModelAttribute("gunModel") Gun gun){
        gunService.createGun(gun);
        return "redirect:/dash";
    }
}
