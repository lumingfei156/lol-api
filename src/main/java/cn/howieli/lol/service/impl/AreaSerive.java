package cn.howieli.lol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.howieli.lol.dao.AreaDao;
import cn.howieli.lol.model.Area;
import cn.howieli.lol.service.IAreaService;

@Service
public class AreaSerive implements IAreaService {
	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> selectAll() {
		return areaDao.selectAll();
	}

	@Override
	public Area selectById(int areaId) {
		return areaDao.selectById(areaId);
	}

}
