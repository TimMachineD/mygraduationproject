package du.shop.service;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.UserDao;
import du.shop.entity.User;


/**
 * 用户名模块业务层代码
 * @author 杜云飞
 *
 */
@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	// 业务层完成用户注册代码:
	public void save(User user) {
		// 将数据存入到数据库
		userDao.save(user);
	}
	// 用户登录的方法
	public User login(User user) {
		return userDao.login(user);
	}
}
