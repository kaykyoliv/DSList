package com.kaykyoliveira.dslist.dto;

import com.kaykyoliveira.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){
    }

    public GameListDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GameListDTO(GameList entity){
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
