package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Gun;
import com.WebtecFinalProject.Model.Request;
import com.WebtecFinalProject.Model.Returns;
import com.WebtecFinalProject.Model.Soldier;
import com.WebtecFinalProject.Service.GunService;
import com.WebtecFinalProject.Service.RequestService;
import com.WebtecFinalProject.Service.ReturnsService;
import com.WebtecFinalProject.Service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class ReturnsController {

    @Autowired
    ReturnsService returnsService;
    @Autowired
    RequestService requestService;


    @GetMapping("/returns")
    public String returns(Model model){
        model.addAttribute("returnsModel", new Returns());
        model.addAttribute("allrequest", requestService.getAllRequests());
        return "Returnweapon";
    }


    @PostMapping("createReturns")
    public String createReturn(@ModelAttribute("returnsModel") Returns returns){
        returnsService.createReturns(returns);
        return "redirect:/dash";
    }

}
