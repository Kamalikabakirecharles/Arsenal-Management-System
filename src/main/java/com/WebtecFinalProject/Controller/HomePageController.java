package com.WebtecFinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homepage(Model model) {
        return "index";
    }
    @GetMapping("/Login")
    public String loginpage(Model model) {
        return "Login"; // This assumes your index page is named "index.html" or similar.
    }
    @GetMapping("/dash")
    public String dashpage(Model model) {
        return "Dash"; // This assumes your index page is named "index.html" or similar.
    }
    @GetMapping("/error")
    public String errorpage(Model model) {
        return "error";
    }

    @GetMapping("/example")
    public String example() {
        // Simulate an error
        throw new RuntimeException("This is a runtime exception");
    }
}

