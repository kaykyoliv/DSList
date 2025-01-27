package com.kaykyoliveira.dslist.controllers;

import com.kaykyoliveira.dslist.dto.GameListDTO;
import com.kaykyoliveira.dslist.dto.GameMinDTO;
import com.kaykyoliveira.dslist.dto.ReplacementDTO;
import com.kaykyoliveira.dslist.services.GameListService;
import com.kaykyoliveira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<Page<GameListDTO>> findAll(Pageable pageable){
        Page<GameListDTO> dto = gameListService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
        List<GameMinDTO> dto = gameService.findByList(listId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/{listId}/replacement")
    public ResponseEntity<Void> move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getIndexSource(), body.getIndexDestination());
        return ResponseEntity.noContent().build();
    }
}
