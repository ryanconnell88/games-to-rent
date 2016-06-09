package com.ryanconnell.gamelib.controller;

import com.ryanconnell.gamelib.data.GameRepository;
import com.ryanconnell.gamelib.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GameController {


    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/")
    public String ListGame(ModelMap modelMap){
        List<Game> allGames = gameRepository.getAllGames();
        // map the games list to the model
        modelMap.put("games", allGames);
        return "home";
    }

    @RequestMapping("/game/{name}")
    public String gameDetails(@PathVariable String name, ModelMap modelMap){
        Game game = gameRepository.findByName(name);
        // map the game object to the model
        modelMap.put("game", game);
        return "game-details";

    }
}
