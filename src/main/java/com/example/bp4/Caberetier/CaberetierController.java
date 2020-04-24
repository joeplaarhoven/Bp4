package com.example.bp4.Caberetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class CaberetierController {
    @Autowired
    private CaberetierService caberetierService;

    @RequestMapping("/caberetier")
    public String viewHomePage(Model model) {
        List<Caberetier> listCaberetier = caberetierService.listAll();
        model.addAttribute("listCaberetier", listCaberetier);

        return "index";
    }
}
