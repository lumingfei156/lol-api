package cn.howieli.lol.dao;

import cn.howieli.lol.model.Area;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AreaDao {
    public List<Area> selectAll();
    public Area selectById(int areaId);
}