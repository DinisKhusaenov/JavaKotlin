package controllers;

import entities.Pers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import services.PersService;
import java.util.List;

@Controller
public class PersController {
    private final PersService persService;

    public PersController(PersService persService){
        this.persService = persService;
    }

    @GetMapping("/pers")
    public String getPers(Model model) {
        List<Pers> users = (List<Pers>) persService.findAll();
        model.addAttribute("pers");
        return "pers";
    }
}
