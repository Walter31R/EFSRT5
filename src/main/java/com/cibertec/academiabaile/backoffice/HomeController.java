package com.cibertec.academiabaile.backoffice;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "backoffice/index.html"; // Thymeleaf template name for the main page
    }

    @GetMapping("home")
    public String returnHomePage() {
        return "backoffice/index.html"; // Thymeleaf template name for the main page
    }
}
