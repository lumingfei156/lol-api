package cn.howieli.lol.dao;

import cn.howieli.lol.model.SummonerSpell;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SummonerSpellDao {
    public void insert(List<SummonerSpell> summonerSpells);
    
    public void deleteAll();
    
    public int getTotal();
    
    public List<SummonerSpell> getSummonerSpells();
    
    public SummonerSpell getSummonerSpellById(String id);
    
}