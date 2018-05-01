package du.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.shop.entity.Product;

/**
 * 
 * @author ���Ʒ�
 *
 */
public class ProductDao extends HibernateDaoSupport {
	/*public List<Product> findHot() {
		// ʹ������������ѯ.
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// ��ѯ���ŵ���Ʒ,��������is_host = 1
		criteria.add(Restrictions.eq("is_hot", 1));
		// �����������:
		criteria.addOrder(Order.desc("pdate"));
		// ִ�в�ѯ:
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}*/

	// ��ҳ��������Ʒ�Ĳ�ѯ
	public List<Product> findNew() {
		// ʹ������������ѯ:
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// �����ڽ��е�������:
		criteria.addOrder(Order.desc("pdate"));
		// ִ�в�ѯ:
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	// ������ƷID��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	// ���ݷ���id��ѯ��Ʒ�ĸ���
	/*
	 * public int findCountCid(Integer cid) { String hql =
	 * "select count(*) from Product p where p.categorySecond.category.cid = ?";
	 * List<Long> list = this.getHibernateTemplate().find(hql,cid); if(list != null
	 * && list.size() > 0){ return list.get(0).intValue(); } return 0; }
	 */

	// ���ݷ���id��ѯ��Ʒ�ļ���
	/*
	 * public List<Product> findByPageCid(Integer cid, int begin, int limit) { //
	 * select p.* from category c,categorysecond cs,product p where c.cid = cs.cid
	 * and cs.csid = p.csid and c.cid = 2 // select p from Category c,CategorySecond
	 * cs,Product p where c.cid = cs.category.cid and cs.csid =
	 * p.categorySecond.csid and c.cid = ? String hql =
	 * "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?"
	 * ; // ��ҳ��һ��д��: List<Product> list = this.getHibernateTemplate().execute(new
	 * PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
	 * if(list != null && list.size() > 0){ return list; } return null;
	 * 
	 * }
	 */

	// ���ݶ��������ѯ��Ʒ����
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// ���ݶ��������ѯ��Ʒ��Ϣ
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		// ��ҳ����һ��д��
		Session session = getSession();
		Query query = session.createQuery(hql);

		query.setParameter(0, csid);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		} 
		return null;
	}

	// ��̨ͳ����Ʒ�����ķ���
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// ��̨��ѯ������Ʒ�ķ���
	
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		Session session = getSession();
		Query query = session.createQuery(hql);

		query.setFirstResult(begin);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		} 
		return null;
	}
	 

	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	// DAO�е�ɾ����Ʒ�ķ���
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
