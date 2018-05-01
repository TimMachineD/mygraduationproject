package du.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.OrderDao;
import du.shop.entity.Order;
import du.shop.entity.OrderItem;
import du.shop.util.PageBean;

/**
 * 
 * @author duyunfei
 *
 */
@Transactional
public class OrderService {
	// ע��OrderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	// ҵ��㱣�涩���ķ���
	public void save(Order order) {
		orderDao.save(order);
	}

	// ҵ�������û�id��ѯ����,����ҳ��ѯ.
	public PageBean<Order> findByUid(Integer uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// ���õ�ǰҳ��:
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		// ��ʾ5��
		int limit = 5;
		pageBean.setLimit(limit);
		// �����ܼ�¼��:
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���:
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findPageByUid(uid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ���ݶ���id��ѯ����
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	// ҵ����޸Ķ����ķ���:
	public void update(Order currOrder) {
		orderDao.update(currOrder);
	}

	// ҵ����ѯ���ж�������
	public PageBean<Order> findAll(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// ���ò���
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��:
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ����ѯ������ķ���
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}
	public PageBean<Order> findByStatePage(Integer state, Integer page){
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页
		pageBean.setPage(page);
		//设置每页显示记录数
		Integer limit = 10;
		pageBean.setLimit(limit);
		//设置总记录数
		Integer totalCount = null;
		totalCount = orderDao.findByCount();
		pageBean.setTotalCount(totalCount);
		//总页数
		Integer totalPage = 0;
		if(totalCount%limit==0){
			totalPage = totalCount/limit;
		}else{
			totalPage = totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示数据的集合
		//开始的地方
		Integer begin = (page-1)*limit;
		List<Order> list = orderDao.findByStatePage(state,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
}
