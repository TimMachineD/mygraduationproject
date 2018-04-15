package du.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.CategoryDao;
import du.shop.entity.Category;
import du.shop.entity.CategorySecond;

/**
 * 
 * @author ���Ʒ�
 *
 */

@Transactional
public class CategoryService {
	// ע��CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// ҵ����ѯ����һ������ķ���
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public List<CategorySecond> findSecByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findSecByCid(cid);
	}

}
