package cn.howieli.lol.service;

import java.util.List;

import cn.howieli.lol.model.Count;

public interface ICountService {
    public void insertToday();

    public Count selectToday();
    
    public List<Count> select7Day();

    public int getCountTotal();

    public void updateToday();
}
