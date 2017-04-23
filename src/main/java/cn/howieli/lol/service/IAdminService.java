package cn.howieli.lol.service;

import cn.howieli.lol.model.Admin;

public interface IAdminService {
	public Admin login(String username);
	public int updateAdmin(Admin admin);
}
