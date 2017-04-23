package cn.howieli.lol.service;

import java.util.List;

import cn.howieli.lol.model.SummonerSpell;

public interface ISummonerSpellService {
	public boolean setSummonerSpellData();
	
	public int getTotal();
	
	public List<SummonerSpell> getSummonerSpells();
	
	public SummonerSpell getSummonerSpellById(String id);
	
}
