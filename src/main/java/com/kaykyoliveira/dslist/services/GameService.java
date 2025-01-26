package com.kaykyoliveira.dslist.services;

import com.kaykyoliveira.dslist.dto.GameDTO;
import com.kaykyoliveira.dslist.dto.GameMinDTO;
import com.kaykyoliveira.dslist.entities.Game;
import com.kaykyoliveira.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game entity = repository.findById(id).get();
        return new GameDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<GameMinDTO> findAll(Pageable pageable){
        Page<Game> result = repository.findAll(pageable);
        return result.map(x -> new GameMinDTO(x));
    }

}
