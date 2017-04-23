package cn.howieli.lol.dao;

import cn.howieli.lol.model.Champion;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ChampionDao {
    public void insert(List<Champion> champions);
    
    public void deleteAll();
    
    public void updateFreeChampion(Champion champion);
    
    public int getTotal();

    public Champion getChampionById(int id);
    
    public List<Champion> getChampions();
    
    public List<Champion> getFreeChampions();
    
}