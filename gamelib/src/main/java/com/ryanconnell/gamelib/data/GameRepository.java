package com.ryanconnell.gamelib.data;


import com.ryanconnell.gamelib.model.Game;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GameRepository {
    private static final List<Game> ALL_GAMES = Arrays.asList(
            new Game("ffxv", 1, LocalDate.of(2016,2,13), "Ryan Connell", true),
            new Game("witcher3",1, LocalDate.of(2016,3,14), "Ryan Connell", true),
            new Game("battleborn",4, LocalDate.of(2016,4,16), "Ryan Connell", true),
            new Game("overwatch", 3, LocalDate.of(2016,5,23), "Ryan Connell", false)
    );

    public Game findByName(String name){
        for(Game game : ALL_GAMES){
            if(game.getName().equals(name)){
                return game;
            }
        }
        return null;
    }

    public List<Game> getAllGames(){
        return ALL_GAMES;
    }

    public List<Game> findByCategoryId(int id){
        List<Game> games = new ArrayList<>();
        for(Game game : ALL_GAMES ){
            if (game.getCategoryId() == id){
                games.add(game);
            }
        }
        return games;

    }
}
