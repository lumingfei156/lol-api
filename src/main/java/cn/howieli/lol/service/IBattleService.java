package cn.howieli.lol.service;

import java.util.Map;

import cn.howieli.lol.model.Battle;

public interface IBattleService {
	public Map<String, Object> getBattleList(int areaId, String qquin, int btNum, Integer[] btList, int championId,
												int offset, int limit, int mvpFlag);
	public Battle getBattleInfo(int areaId, long gameId);
}
