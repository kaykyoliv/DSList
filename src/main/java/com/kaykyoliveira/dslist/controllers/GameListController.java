package com.kaykyoliveira.dslist.controllers;

import com.kaykyoliveira.dslist.dto.GameListDTO;
import com.kaykyoliveira.dslist.dto.GameMinDTO;
import com.kaykyoliveira.dslist.services.GameListService;
import com.kaykyoliveira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<Page<GameListDTO>> findAll(Pageable pageable){
        Page<GameListDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
        List<GameMinDTO> dto = gameService.findByList(listId);
        return ResponseEntity.ok(dto);
    }
}
