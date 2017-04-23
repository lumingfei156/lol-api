package cn.howieli.lol.service;

import java.util.List;

import cn.howieli.lol.model.Area;

public interface IAreaService {
    public List<Area> selectAll();
    public Area selectById(int areaId);
}
