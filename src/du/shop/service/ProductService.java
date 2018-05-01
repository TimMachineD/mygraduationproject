package du.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.ProductDao;
import du.shop.entity.Product;
import du.shop.util.PageBean;
/**
 * 
 * @author ���Ʒ�
 *
 */
@Transactional
public class ProductService {
	// ע��ProductDao
		private ProductDao productDao;

		public void setProductDao(ProductDao productDao) {
			this.productDao = productDao;
		}

	
		// ��ҳ��������Ʒ�Ĳ�ѯ
		public List<Product> findNew() {
			return productDao.findNew();
		}

		// ������ƷID��ѯ��Ʒ
		public Product findByPid(Integer pid) {
			return productDao.findByPid(pid);
		}

		

		// ���ݶ��������ѯ��Ʒ��Ϣ
		public PageBean<Product> findByPageCsid(Integer csid, int page) {
			PageBean<Product> pageBean = new PageBean<Product>();
			// ���õ�ǰҳ��:
			pageBean.setPage(page);
			// ����ÿҳ��ʾ��¼��:
			int limit = 8;
			pageBean.setLimit(limit);
			// �����ܼ�¼��:
			int totalCount = 0;
			totalCount = productDao.findCountCsid(csid);
			pageBean.setTotalCount(totalCount);
			// ������ҳ��:
			int totalPage = 0;
			// Math.ceil(totalCount / limit);
			if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
			} else {
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// ÿҳ��ʾ�����ݼ���:
			// ���Ŀ�ʼ:
			int begin = (page - 1) * limit;
			List<Product> list = productDao.findByPageCsid(csid, begin, limit);
			pageBean.setList(list);
			return pageBean;
		}

		// ��̨��ѯ������Ʒ����ҳ
		public PageBean<Product> findByPage(Integer page) {
			PageBean<Product> pageBean = new PageBean<Product>();
			// ���õ�ǰҳ��:
			pageBean.setPage(page);
			// ����ÿҳ��ʾ��¼��:
			int limit = 10;
			pageBean.setLimit(limit);
			// �����ܼ�¼��:
			int totalCount = 0;
			totalCount = productDao.findCount();
			pageBean.setTotalCount(totalCount);
			// ������ҳ��:
			int totalPage = 0;
			// Math.ceil(totalCount / limit);
			if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
			} else {
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// ÿҳ��ʾ�����ݼ���:
			// ���Ŀ�ʼ:
			int begin = (page - 1) * limit;
			List<Product> list = productDao.findByPage(begin, limit);
			pageBean.setList(list);
			return pageBean;
		}

		// ҵ��㱣����Ʒ����:
		public void save(Product product) {
			productDao.save(product);
		}

		// ҵ���ɾ����Ʒ
		public void delete(Product product) {
			productDao.delete(product);
		}

		// ҵ����޸���Ʒ�ķ���
		public void update(Product product) {
			productDao.update(product);
		}
}
