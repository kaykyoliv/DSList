package com.kaykyoliveira.dslist.services;

import com.kaykyoliveira.dslist.dto.GameListDTO;
import com.kaykyoliveira.dslist.entities.GameList;
import com.kaykyoliveira.dslist.projections.GameMinProjection;
import com.kaykyoliveira.dslist.repositories.GameListRepository;
import com.kaykyoliveira.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Page<GameListDTO> findAll(Pageable pageable){
        Page<GameList> result = gameListRepository.findAll(pageable);
        return result.map(GameListDTO::new);
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        if (sourceIndex != destinationIndex){
            int min = Math.min(sourceIndex, destinationIndex);
            int max = Math.max(sourceIndex, destinationIndex);

            for(int i = min; i <= max; i++){
                gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
            }
        }
    }

}
