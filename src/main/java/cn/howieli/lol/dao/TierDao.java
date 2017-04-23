package cn.howieli.lol.dao;

import cn.howieli.lol.model.Tier;
import java.util.List;

public interface TierDao {
    int insert(Tier record);

    List<Tier> selectAll();
}