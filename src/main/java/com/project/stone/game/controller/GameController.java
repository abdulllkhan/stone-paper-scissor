package com.project.stone.game.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.project.stone.game.dto.CreateNewGameDTO;
import com.project.stone.game.dto.JoinGameDTO;
import com.project.stone.game.services.RoomService;

@RestController
@Validated
public class GameController {

    private final RoomService roomService;
    private Gson gson = new Gson();

    @Autowired
    public GameController(RoomService roomService,
                          Gson gson) {
        this.roomService = roomService;
        this.gson = gson;
    }

    @GetMapping("api/game/{sessionCode}")
    public String gameDetails(@PathVariable String sessionCode) throws Throwable{
        
        return roomService.getGameSessionDetails(sessionCode);

    }

    @PostMapping("api/game")
    public String createNewGame(@Valid @RequestBody CreateNewGameDTO createNewGameDTO) throws Throwable{
        return roomService.createNewGame(createNewGameDTO);
    }

    @PostMapping("api/game/join")
    public String joinGame(@Valid @RequestBody JoinGameDTO joinGameDTO) throws Throwable{
        return roomService.joinGame(joinGameDTO);
    }

    @PostMapping("api/game/end")
    public String endGame(@Valid @RequestBody JoinGameDTO joinGameDTO) throws Throwable{
        return roomService.joinGame(joinGameDTO);
    }
    
    
}
