package du.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.shop.entity.User;


/**
 * �û�ģ��־ò����:
 * @author ���Ʒ�
 *
 */
public class UserDao extends HibernateDaoSupport{

	// �����β�ѯ�Ƿ��и��û�:
	public User findByUsername(String username){
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	// ע���û��������ݿ����ʵ��
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	
	// �û���¼�ķ���
	public User login(User user) {
		String hql = "from User where username = ? and password = ?";
		List<User> list = this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
