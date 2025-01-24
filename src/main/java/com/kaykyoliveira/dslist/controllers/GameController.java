package com.kaykyoliveira.dslist.controllers;

import com.kaykyoliveira.dslist.dto.GameMinDTO;
import com.kaykyoliveira.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public ResponseEntity<Page<GameMinDTO>> findAll(Pageable pageable){
        Page<GameMinDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
}
