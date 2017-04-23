package cn.howieli.lol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.howieli.lol.dao.ItemDao;
import cn.howieli.lol.model.Item;
import cn.howieli.lol.service.IItemService;
import cn.howieli.lol.spider.ItemSpider;

@Service
public class ItemService implements IItemService {
	@Autowired
	private ItemDao itemDao;
	
	@Transactional
	@Override
	public boolean setItemData() {
		List<Item> items;
		try {
			items = ItemSpider.getItemData();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		itemDao.deleteAll();
		itemDao.insert(items);
		return true;
	}

	@Override
	public int getTotal() {
		return itemDao.getTotal();
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}

}
