package du.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.UserDao;
import du.shop.entity.User;
import du.shop.util.MailThread;
import du.shop.util.MailUtils;
import du.shop.util.PageBean;
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
		// 业务层用户查询所有
		public PageBean<User> findByPage(Integer page) {
			PageBean<User> pageBean = new PageBean<User>();
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			// 显示5个
			int limit = 5;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = userDao.findCount();
			pageBean.setTotalCount(totalCount);
			// 设置总页数
			int totalPage = 0;
			if(totalCount % limit == 0){
				totalPage = totalCount / limit;
			}else{
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 设置每页显示数据集合:
			int begin = (page - 1)*limit;
			List<User> list = userDao.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
		}


		public User findByUid(Integer uid) {
			return userDao.findByUid(uid);
		}


		public void delete(User existUser) {
			userDao.delete(existUser);
		}
}
