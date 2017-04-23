package cn.howieli.lol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.howieli.lol.dao.CountDao;
import cn.howieli.lol.model.Count;
import cn.howieli.lol.service.ICountService;

@Service
public class CountService implements ICountService {
	@Autowired
	private CountDao countDao;

	@Transactional
	@Override
	public void insertToday() {
		countDao.insertToday();
	}

	@Override
	public Count selectToday() {
		return countDao.selectToday();
	}

	@Override
	public List<Count> select7Day() {
		return countDao.select7Day();
	}

	@Override
	public int getCountTotal() {
		return countDao.getCountTotal();
	}

	@Transactional
	@Override
	public void updateToday() {
		countDao.updateToday();
	}

}
