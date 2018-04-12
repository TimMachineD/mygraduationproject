package du.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.shop.entity.Category;
import du.shop.entity.CategorySecond;


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

	public List<CategorySecond> findSecByCid(Integer cid) {
		String hql = "select cs from CategorySecond cs join cs.category c where c.cid = ?";
		List<CategorySecond> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}
	
}
