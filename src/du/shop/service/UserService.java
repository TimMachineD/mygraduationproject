package du.shop.service;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.UserDao;
import du.shop.entity.User;
import du.shop.util.MailThread;
import du.shop.util.MailUtils;
import du.shop.util.UUIDUtils;


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
			user.setState(0); // 0:�����û�δ����.  1:�����û��Ѿ�����.
			String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
			user.setCode(code);
			userDao.save(user);
			// ���ͼ����ʼ�;
			//MailUtils.sendMail(user.getEmail(), code);
			MailThread mailThread = new MailThread(user.getEmail(), code);
			mailThread.start();
		}

		// ҵ�����ݼ������ѯ�û�
		public User findByCode(String code) {
			return userDao.findByCode(code);
		}

		// �޸��û���״̬�ķ���
		public void update(User existUser) {
			userDao.update(existUser);
		}

		// �û���¼�ķ���
		public User login(User user) {
			return userDao.login(user);
		}
}
