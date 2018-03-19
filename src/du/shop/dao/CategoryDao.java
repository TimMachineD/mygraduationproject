package du.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.shop.entity.Category;


/**
 * һ������ĳ־ò����
 * @author duyunfei
 *
 */
public class CategoryDao extends HibernateDaoSupport{

	//DAO��Ĳ�ѯ����һ������ķ���
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	
}
