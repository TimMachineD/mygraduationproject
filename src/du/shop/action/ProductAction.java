package du.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import du.shop.entity.Product;
import du.shop.service.ProductService;
import du.shop.util.PageBean;
/**
 * 
 * @author ���Ʒ�
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	// ���ڽ������ݵ�ģ������.
		private Product product = new Product();
		// ע����Ʒ��Service
		private ProductService productService;
		// ���ն�������id
		private Integer csid;

		public Integer getCsid() {
			return csid;
		}

		public void setCsid(Integer csid) {
			this.csid = csid;
		}

		// ���յ�ǰҳ��:
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

		// ������Ʒ��ID���в�ѯ��Ʒ:ִ�з���:
		public String findByPid() {
			// ����Service�ķ�����ɲ�ѯ.
			product = productService.findByPid(product.getPid());
			return "findByPid";
		}


		// ���ݶ�������id��ѯ��Ʒ:
		public String findByCsid() {
			// ���ݶ��������ѯ��Ʒ
			PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
			// ��PageBean���뵽ֵջ��:
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByCsid";
		}
}
