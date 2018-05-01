package du.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.shop.entity.Order;
import du.shop.entity.User;

/**
 * �û�ģ��־ò����:
 * 
 * @author ���Ʒ�
 *
 */
public class UserDao extends HibernateDaoSupport {

	// �����β�ѯ�Ƿ��и��û�:
	public User findByUsername(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ע���û��������ݿ����ʵ��
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	// ���ݼ������ѯ�û�
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql, code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// �޸��û�״̬�ķ���
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}

	// �û���¼�ķ���
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword(), 1);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		Session session = getSession();
		Query query = session.createQuery(hql);

		query.setFirstResult(begin);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	public void delete(User existUser) {
		this.getHibernateTemplate().delete(existUser);
	}
}
