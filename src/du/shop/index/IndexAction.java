package du.shop.index;

import java.util.HashSet;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import du.shop.entity.Category;
import du.shop.entity.CategorySecond;
import du.shop.service.CategoryService;

/**
 * @version 1.0 2017-03-11
 * @author 杜云飞
 *
 */
public class IndexAction extends ActionSupport {

	/**
	 * 返回首页
	 */
	// 接收分类cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}
	// 注入一级分类的Service:
	private CategoryService categoryService;
	// 注入商品的Service
	//private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/*public void setProductService(ProductService productService) {
		this.productService = productService;
	}*/

	/**
	 * 执行的访问首页的方法:
	 */
	public String index() {
		// 查询所有一级分类集合
		List<Category> cList = categoryService.findAll();
		// 将一级分类存入到Session的范围:
		ActionContext.getContext().getSession().put("cList", cList);
		// 查询热门商品:
		//List<Product> hList = productService.findHot();
		// 保存到值栈中:
		//ActionContext.getContext().getValueStack().set("hList", hList);
		// 查询最新商品:
		//List<Product> nList = productService.findNew();
		// 保存到值栈中:
		//ActionContext.getContext().getValueStack().set("nList", nList);
		return "toIndex";
	}
	//查询二级分类
	public String showSecCategory() {
		List<CategorySecond> csList = categoryService.findSecByCid(cid);
		ActionContext.getContext().getSession().put("csList", csList);
		return "toSecCategory";
	}
	public String test() {
		return "test";
	}
}
