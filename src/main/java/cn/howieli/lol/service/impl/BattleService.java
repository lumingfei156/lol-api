package cn.howieli.lol.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import cn.howieli.lol.model.Battle;
import cn.howieli.lol.service.IBattleService;
import cn.howieli.lol.spider.BattleSpider;

@Service
public class BattleService implements IBattleService {

	@Override
	public Map<String, Object> getBattleList(int areaId, String qquin, int btNum, Integer[] btList, int championId,
			int offset, int limit, int mvpFlag) {
		Map<String, Object> map;
		try {
			map = BattleSpider.getBattleList(areaId, qquin, btNum, btList, championId, offset, limit, mvpFlag);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@Override
	public Battle getBattleInfo(int areaId, long gameId) {
		Battle battle;
		try {
			battle = BattleSpider.getBattleInfo(areaId, gameId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return battle;
	}

}
