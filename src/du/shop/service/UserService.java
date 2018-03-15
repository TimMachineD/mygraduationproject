package du.shop.service;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.UserDao;
import du.shop.entity.User;
import du.shop.util.MailThread;
import du.shop.util.MailUtils;
import du.shop.util.UUIDUtils;


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
			user.setState(0); // 0:代表用户未激活.  1:代表用户已经激活.
			String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
			user.setCode(code);
			userDao.save(user);
			// 发送激活邮件;
			//MailUtils.sendMail(user.getEmail(), code);
			MailThread mailThread = new MailThread(user.getEmail(), code);
			mailThread.start();
		}

		// 业务层根据激活码查询用户
		public User findByCode(String code) {
			return userDao.findByCode(code);
		}

		// 修改用户的状态的方法
		public void update(User existUser) {
			userDao.update(existUser);
		}

		// 用户登录的方法
		public User login(User user) {
			return userDao.login(user);
		}
}
