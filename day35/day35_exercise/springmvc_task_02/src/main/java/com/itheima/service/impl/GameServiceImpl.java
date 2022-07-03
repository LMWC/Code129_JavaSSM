package com.itheima.service.impl;

import com.itheima.domain.Game;
import com.itheima.mapper.GameMapper;
import com.itheima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;


    @Override
    public List<Game> findAll() {
        return gameMapper.findAll();
    }

    @Override
    public boolean addGame(Game game) {
        return gameMapper.saveGame(game);
    }

    @Override
    public boolean updateGame(Game game) {
        return gameMapper.updateGame(game);
    }

    @Override
    public boolean deleteById(Long id) {
        return gameMapper.deleteById(id);
    }
}
