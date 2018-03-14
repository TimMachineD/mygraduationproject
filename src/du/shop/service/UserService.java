package du.shop.service;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.UserDao;
import du.shop.entity.User;


/**
 * �û���ģ��ҵ������
 * @author ���Ʒ�
 *
 */
@Transactional
public class UserService {
	// ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	// ���û�����ѯ�û��ķ���:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	// ҵ�������û�ע�����:
	public void save(User user) {
		// �����ݴ��뵽���ݿ�
		userDao.save(user);
	}
	// �û���¼�ķ���
	public User login(User user) {
		return userDao.login(user);
	}
}
