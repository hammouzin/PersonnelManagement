package net.javaguides.personnalmanagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/login")
    public String redirectToReqLogin() {
        return "redirect:/req/login"; // Redirection vers l'URL réelle de la vue
    }

    @GetMapping("/req/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}

