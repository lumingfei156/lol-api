package cn.howieli.lol.dao;

import cn.howieli.lol.model.Item;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao {
    public void insert(List<Item> items);

    public void deleteAll();
    
    public int getTotal();
    
    public List<Item> getItems();
    
    public Item getItemById(int id);
}