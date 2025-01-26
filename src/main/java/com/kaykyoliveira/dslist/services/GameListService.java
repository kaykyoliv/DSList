package com.kaykyoliveira.dslist.services;

import com.kaykyoliveira.dslist.dto.GameListDTO;
import com.kaykyoliveira.dslist.entities.GameList;
import com.kaykyoliveira.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public Page<GameListDTO> findAll(Pageable pageable){
        Page<GameList> result = repository.findAll(pageable);
        return result.map(x -> new GameListDTO(x));
    }

}
