package du.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import du.shop.entity.Product;
import du.shop.service.ProductService;
import du.shop.util.PageBean;
/**
 * 
 * @author 杜云飞
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	// 用于接收数据的模型驱动.
		private Product product = new Product();
		// 注入商品的Service
		private ProductService productService;
		// 接收二级分类id
		private Integer csid;

		public Integer getCsid() {
			return csid;
		}

		public void setCsid(Integer csid) {
			this.csid = csid;
		}

		// 接收当前页数:
		private int page;

		public void setPage(int page) {
			this.page = page;
		}


		

		public void setProductService(ProductService productService) {
			this.productService = productService;
		}

		public Product getModel() {
			return product;
		}

		// 根据商品的ID进行查询商品:执行方法:
		public String findByPid() {
			// 调用Service的方法完成查询.
			product = productService.findByPid(product.getPid());
			return "findByPid";
		}


		// 根据二级分类id查询商品:
		public String findByCsid() {
			// 根据二级分类查询商品
			PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
			// 将PageBean存入到值栈中:
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByCsid";
		}
}
