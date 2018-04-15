package du.shop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import du.shop.entity.Order;
import du.shop.entity.OrderItem;

/**
 * 
 * @author duyunfei
 *
 */
public class OrderDao extends HibernateDaoSupport {

	// Dao��ı��涩�������
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:ͳ�Ƹ���
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:��ѯ����
	public List<Order> findPageByUid(Integer uid, Integer begin, Integer limit) {
		String hql = "from Order o where o.user.uid = ? order by ordertime desc";
		// ��ҳ����һ��д��
		Session session = getSession();
		Query query = session.createQuery(hql);

		query.setParameter(0, uid);
		query.setFirstResult(begin);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		} 
		return null;
	}

	// DAO����ݶ���id��ѯ����
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	// DAO���޸Ķ����ķ���:
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}

	// DAO��ͳ�ƶ��������ķ���
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO�з�ҳ��ѯ�����ķ���
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";

		// ��ҳ����һ��д��
		Session session = getSession();
		Query query = session.createQuery(hql);

		query.setFirstResult(begin);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		} 
		return null;
	}

	// DAo�и��ݶ���id��ѯ������
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
