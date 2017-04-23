package cn.howieli.lol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.howieli.lol.dao.SummonerSpellDao;
import cn.howieli.lol.model.SummonerSpell;
import cn.howieli.lol.service.ISummonerSpellService;
import cn.howieli.lol.spider.SummonerSpellSpider;

@Service
public class SummonerSpellService implements ISummonerSpellService {

	@Autowired
	private SummonerSpellDao summonerSpellDao;
	
	@Transactional
	@Override
	public boolean setSummonerSpellData() {
		List<SummonerSpell> summonerSpells;
		try {
			summonerSpells = SummonerSpellSpider.getSummonerSpellData();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		summonerSpellDao.deleteAll();
		summonerSpellDao.insert(summonerSpells);
		return true;
	}

	@Override
	public int getTotal() {
		return summonerSpellDao.getTotal();
	}

	@Override
	public List<SummonerSpell> getSummonerSpells() {
		return summonerSpellDao.getSummonerSpells();
	}

	@Override
	public SummonerSpell getSummonerSpellById(String id) {
		return summonerSpellDao.getSummonerSpellById(id);
	}

}
