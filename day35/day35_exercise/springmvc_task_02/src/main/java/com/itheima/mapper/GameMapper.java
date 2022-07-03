package com.itheima.mapper;

import com.itheima.domain.Game;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GameMapper {

    @Select("select * from tb_game")
    public List<Game> findAll();

    @Insert("insert into tb_game values(null,#{name},#{type},#{url},#{ordered},#{company})")
    public boolean saveGame(Game game);

    @Update("update tb_game set name = #{name},type=#{type},url=#{url},ordered=#{ordered},company=#{company} where id = #{id}")
    public boolean updateGame(Game game);

    @Delete("delete from tb_game where id = #{id}")
    public boolean deleteById(Long id);
}
