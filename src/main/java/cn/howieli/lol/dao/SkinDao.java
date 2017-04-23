package cn.howieli.lol.dao;

import cn.howieli.lol.model.Skin;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SkinDao {
    int deleteByPrimaryKey(Integer id);

    public void insert(List<Skin> skins);

    public void truncateSkin();
    
    public List<Skin> getSkinsByChampionId(int championId);
    
    List<Skin> selectAll();

    int updateByPrimaryKey(Skin record);
}