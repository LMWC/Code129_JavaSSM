package com.itheima.service;

import com.itheima.domain.Game;

import java.util.List;

public interface GameService {

    /**
     * 列表查询
     * @return
     */
    public List<Game> findAll();

    /**
     * 新增
     * @param game
     * @return
     */
    public boolean addGame(Game game);

    /**
     * 修改
     * @param game
     * @return
     */
    public boolean updateGame(Game game);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public boolean deleteById(Long id);
}
