package cn.howieli.lol.service;

import java.util.List;

import cn.howieli.lol.model.Item;

public interface IItemService {
	public boolean setItemData();
	
	public int getTotal();
	
	public List<Item> getItems();
	
	public Item getItemById(int id);
}
