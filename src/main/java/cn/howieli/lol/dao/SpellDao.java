package cn.howieli.lol.dao;

import cn.howieli.lol.model.Spell;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SpellDao {
    int deleteByPrimaryKey(Integer id);

    public void insert(List<Spell> spells);
    
    public void truncateSpell();

    public List<Spell> getSpellsByChampionId(int championId);
    
    List<Spell> selectAll();

    int updateByPrimaryKey(Spell record);
}