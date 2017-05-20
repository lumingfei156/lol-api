package cn.howieli.lol.scheduled;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.howieli.lol.service.IChampionService;
import cn.howieli.lol.service.ICountService;

@Component
public class ScheduledTasks {
	@Autowired
	private IChampionService championService;
	@Autowired
	private ICountService countService;
	
	/**
	 * 每周五十一点更新周免
	 */
	@Scheduled(cron = "0 0 11 ? * 6")
	public void updateFreeChampion() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (championService.updateFreeChampion()) {
			System.out.println("更新周免英雄成功-------->" + format.format(new Date()));
		} else {
			System.out.println("更新周免英雄失败-------->" + format.format(new Date()));
		}
	}
	
	@Scheduled(cron = "0 1 0 * * ?")
	public void addTodayCount() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (countService.selectToday() == null) {
			countService.insertToday();
			System.out.println("插入当天计数成功-------->" + format.format(new Date()));
		} else {
			System.out.println("已存在，无需插入-------->" + format.format(new Date()));
		}
	}
	
}
