package controller;

import data.GameDao;
import data.RoundDao;
import entity.Game;
import entity.Round;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import service.ServiceLayer;

@RestController
@RequestMapping("/api/game")

public class ToDoController {
    @Autowired
    ServiceLayer service;
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int createGame(){
        return service.newGame();
    }
    @PostMapping("/guess")
    public Round makeGuess(@RequestBody Round round) {
        return service.makeGuess(round);   
    }
    @GetMapping("/game")
    public List<Game> getAllgames(){
       return service.getAllGames();
    }
     @GetMapping("/game/{game_id}")
    public Game getGameById(@PathVariable("game_id") int gameId) {
        return service.getGameById(gameId);
    }
    
    @GetMapping("/rounds/{game_id}")
    public List<Round> getRoundsForGame(@PathVariable("game_id") int gameId) {
        return service.getAllRoundsByGameId(gameId);
    }
}
