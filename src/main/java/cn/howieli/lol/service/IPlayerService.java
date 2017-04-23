package cn.howieli.lol.service;

import java.util.List;

import cn.howieli.lol.model.Player;

public interface IPlayerService {
	public List<Player> searchPlayerList(String playerName);
	public List<Player> playerTierRanking(int areaId, int pageNum);
}
