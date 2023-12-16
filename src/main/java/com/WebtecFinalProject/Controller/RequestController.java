package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Request;
import com.WebtecFinalProject.Service.GunService;
import com.WebtecFinalProject.Service.RequestService;
import com.WebtecFinalProject.Service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class RequestController {
    @Autowired
    RequestService requestService;
    @Autowired
    GunService gunService;

    @Autowired
    SoldierService soldierService;


    @GetMapping("/request")
    public String request(Model model){
        model.addAttribute("requestModel", new Request());
        model.addAttribute("allGuns", gunService.getAllGuns());
        model.addAttribute("allSoldiers", soldierService.getAllSoldiers());
        return "Assignedweapon";
    }

    @PostMapping("createRequest")
    public String createRequest(@ModelAttribute("requestModel") Request request){
        requestService.createRequest(request);
        return "redirect:/dash";
    }
}
