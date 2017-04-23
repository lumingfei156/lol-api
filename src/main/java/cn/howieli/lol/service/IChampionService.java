package cn.howieli.lol.service;

import java.util.List;

import cn.howieli.lol.model.Champion;

public interface IChampionService {
	public boolean setChampionData();
	
	public boolean updateFreeChampion();
	
	public int getTotal();
	
	public List<Champion> getBriefChampions();
	
	public Champion getBriefChampionsById(int id);
	
	public List<Champion> getChampions();
	
	public Champion getChampionById(int id);
	
	public List<Champion> getFreeChampions();
	
}
