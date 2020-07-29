package com.rollin.rollinweb.controller;

import com.rollin.rollinweb.entity.Gamer;
import com.rollin.rollinweb.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GamerController {
    @Autowired
    private GamerRepository repository;

    @GetMapping("/gamers")
    public String getAll(Model model) {

        model.addAttribute("gamers", repository.findAll());

        return "gamers";
    }

    @GetMapping("/gamer")
    public String getGamer(Model model, @RequestParam(required = false) Long id) {
        Gamer gamer = new Gamer();
        if (id != null) {
            Optional<Gamer> optionalGamer = repository.findById(id);
            if (optionalGamer.isPresent()) {
                gamer = optionalGamer.get();
            }
        }
        model.addAttribute("gamer", gamer);

        return "gamer";
    }

    @PostMapping("/gamer")
    public String postGamer(@ModelAttribute Gamer gamer){

        repository.save(gamer);
        return "redirect:/gamers";
    }
    @GetMapping("/gamer/delete")
    public String deleteGamer(@RequestParam Long id) {

        repository.deleteById(id);

        return "redicrect:/gamers";
    }
}


