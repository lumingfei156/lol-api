package cn.howieli.lol.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.howieli.lol.dao.ChampionDao;
import cn.howieli.lol.dao.InfoDao;
import cn.howieli.lol.dao.SkinDao;
import cn.howieli.lol.dao.SpellDao;
import cn.howieli.lol.model.Champion;
import cn.howieli.lol.model.Info;
import cn.howieli.lol.model.Skin;
import cn.howieli.lol.model.Spell;
import cn.howieli.lol.service.IChampionService;
import cn.howieli.lol.spider.ChampionSpider;

@Service
public class ChampionService implements IChampionService {
	@Autowired
	private ChampionDao championDao;
	
	@Autowired
	private InfoDao infoDao;
	
	@Autowired
	private SkinDao skinDao;
	
	@Autowired
	private SpellDao spellDao;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public boolean setChampionData() {
		Map<String, Object> map;
		List<Champion> champions;
		List<Info> infos;
		List<Skin> skins;
		List<Spell> spells;
		
		try {
			champions = ChampionSpider.getChampionData();
			map = ChampionSpider.getChampionDetailsInfo(champions);
		} catch (Exception e) {
			return false;
		}
		
		championDao.deleteAll();
		championDao.insert(champions);
		
		infos = (List<Info>) map.get("info");
		infoDao.truncateInfo();
		infoDao.insert(infos);
		
		skins = (List<Skin>) map.get("skin");
		skinDao.truncateSkin();
		skinDao.insert(skins);
		
		spells = (List<Spell>) map.get("spell");
		spellDao.truncateSpell();
		spellDao.insert(spells);
		
		return true;
	}

	@Transactional
	@Override
	public boolean updateFreeChampion() {
		List<Champion> champions = championDao.getChampions();
		try {
			champions = ChampionSpider.getFreeChampion(champions);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		/**
		 * 这里本来想直接传入List批量删除
		 * 老是报这个错误:sql injection violation, multi-statement not allow
		 * 数据库连接也加了allowMultiQueries=true参数
		 * 也试了好多方法没成功，只能这样操作
		 */
		for (Champion champion : champions) {
			championDao.updateFreeChampion(champion);
		}
		return true;
	}
	
	@Override
	public int getTotal() {
		return championDao.getTotal();
	}
	
	@Override
	public List<Champion> getBriefChampions() {
		return championDao.getChampions();
	}
	
	@Override
	public Champion getBriefChampionsById(int id) {
		return championDao.getChampionById(id);
	}
	
	@Override
	public Champion getChampionById(int id) {
		Champion champion = championDao.getChampionById(id);
		Info info = infoDao.getInfoByChampionId(champion.getId());
		List<Skin> skins = skinDao.getSkinsByChampionId(champion.getId());
		List<Spell> spells = spellDao.getSpellsByChampionId(champion.getId());
		
		champion.setInfo(info);
		champion.setSkins(skins);
		champion.setSpells(spells);
		
		return champion;
	}
	
	@Override
	public List<Champion> getChampions() {
		List<Champion> champions = championDao.getChampions();
		Info info;
		List<Skin> skins;
		List<Spell> spells;
		int i = 0;
		
		for (Champion champion : champions) {
			info = infoDao.getInfoByChampionId(champion.getId());
			skins = skinDao.getSkinsByChampionId(champion.getId());
			spells = spellDao.getSpellsByChampionId(champion.getId());
			
			champion.setInfo(info);
			champion.setSkins(skins);
			champion.setSpells(spells);
			
			champions.set(i, champion);
			i++;
		}
		return champions;
	}

	@Override
	public List<Champion> getFreeChampions() {
		return championDao.getFreeChampions();
	}

}
