package cn.howieli.lol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.howieli.lol.dao.AdminDao;
import cn.howieli.lol.model.Admin;
import cn.howieli.lol.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin login(String username) {
		return adminDao.login(username);
	}

	@Override
	public int updateAdmin(Admin admin) {
		return adminDao.updateByPrimaryKey(admin);
	}

}
