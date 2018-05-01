package du.shop.index;

import java.util.HashSet;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import du.shop.entity.Category;
import du.shop.entity.CategorySecond;
import du.shop.entity.Product;
import du.shop.service.CategoryService;
import du.shop.service.ProductService;

/**
 * @version 1.0 2017-03-11
 * @author ���Ʒ�
 *
 */
public class IndexAction extends ActionSupport {

	/**
	 * ������ҳ
	 */
	// ���շ���cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}
	// ע��һ�������Service:
	private CategoryService categoryService;
	// ע����Ʒ��Service
	private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * ִ�еķ�����ҳ�ķ���:
	 */
	public String index() {
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.findAll();
		// ��һ��������뵽Session�ķ�Χ:
		ActionContext.getContext().getSession().put("cList", cList);
		// ��ѯ������Ʒ:
		//List<Product> hList = productService.findHot();
		// ���浽ֵջ��:
		//ActionContext.getContext().getValueStack().set("hList", hList);
		// ��ѯ������Ʒ:
		List<Product> nList = productService.findNew();
		// ���浽ֵջ��:
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "toIndex";
	}
	//��ѯ��������
	public String showSecCategory() {
		List<CategorySecond> csList = categoryService.findSecByCid(cid);
		ActionContext.getContext().getSession().put("csList", csList);
		return "toSecCategory";
	}
	
	public String test() {
		return "test";
	}
}
