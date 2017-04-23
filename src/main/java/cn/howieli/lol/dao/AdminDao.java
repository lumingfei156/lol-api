package cn.howieli.lol.dao;

import org.springframework.stereotype.Repository;

import cn.howieli.lol.model.Admin;

@Repository
public interface AdminDao {
    public int insert(Admin record);

    public Admin login(String username);

    public int updateByPrimaryKey(Admin record);
}