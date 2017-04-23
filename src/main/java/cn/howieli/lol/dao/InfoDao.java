package cn.howieli.lol.dao;

import cn.howieli.lol.model.Info;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface InfoDao {
    public int deleteByPrimaryKey(Integer id);

    public int insert(List<Info> infos);

    public void truncateInfo();
    
    public Info getInfoByChampionId(int championId);

    public List<Info> selectAll();

    public int updateByPrimaryKey(Info record);
}