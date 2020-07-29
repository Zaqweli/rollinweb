package com.rollin.rollinweb.controller;

import com.rollin.rollinweb.model.Game;
import com.rollin.rollinweb.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Controller
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping("/games")
    @ResponseBody
    public List<Game> list(){
        return service.list();
    }

    @GetMapping("/games/{uuid}")
    @ResponseBody
    public Game get(@PathVariable UUID uuid){

        return service.find(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "couldn't fint the right game with uuid"));
    }

    @PostMapping("/games")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody Game game) {
        if (game.getAddress() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing address");
        if (game.getAddress().getCity() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing address.city");
        if (game.getAddress().getLine1() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing address.line1");
        if (game.getAddress().getLine2() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing address.line2");

        return service.create(game);
    }

    @PutMapping("/players")
    @ResponseBody
    public Game update(@RequestBody Game game) {
        if (player.getUuid() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing uuid");
        else return service.update(player);
    }

    @DeleteMapping("/players/{uuid}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        boolean isDeleted = service.delete(uuid);
        if (isDeleted) return null;
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "could not delete player with uuid> " + uuid);

    }
}
