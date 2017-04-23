package cn.howieli.lol.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.howieli.lol.model.Count;

@Repository
public interface CountDao {
    public void insertToday();

    public Count selectToday();
    
    public List<Count> select7Day();

    public int getCountTotal();

    public void updateToday();
}