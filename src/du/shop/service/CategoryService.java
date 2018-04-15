package du.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import du.shop.dao.CategoryDao;
import du.shop.entity.Category;
import du.shop.entity.CategorySecond;

/**
 * 
 * @author 杜云飞
 *
 */

@Transactional
public class CategoryService {
	// 注入CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// 业务层查询所有一级分类的方法
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public List<CategorySecond> findSecByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findSecByCid(cid);
	}

}
