package com.rollin.rollinweb.controller;


import com.rollin.rollinweb.entity.Gamer;
import com.rollin.rollinweb.entity.Party;
import com.rollin.rollinweb.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Optional;

@Controller
public class PartyController {
    @Autowired
    PartyRepository partyRepository;

    @GetMapping("/parties")
    public String getAll(Model model) {


        model.addAttribute("parties", partyRepository.findAll());

        return "parties";
    }

    @GetMapping("/party")
    public String getParty(Model model,
                           @RequestParam(required = false) Long id) {


        Party party = new Party();
        if (id != null) {
            Optional<Party> optionalParty = partyRepository.findById(id);
            if (optionalParty.isPresent()) {
                party = optionalParty.get();
            }
        }
        model.addAttribute("party", party);
        return "party";
    }

    @PostMapping("/party")
    public String postParty(@ModelAttribute Party party) {


        partyRepository.save(party);
        return "redirect:/parties";
    }

    @GetMapping("/party/delete")
    public String deleteParty(@RequestParam Long id) {

        partyRepository.deleteById(id);

        return "redirect:/parties";
    }


}