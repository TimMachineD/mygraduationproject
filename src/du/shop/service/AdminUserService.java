package du.shop.service;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.AdminUserDao;
import du.shop.entity.AdminUser;

@Transactional
public class AdminUserService {
	// 注入Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
