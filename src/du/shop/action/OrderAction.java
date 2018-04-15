package du.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import du.shop.entity.Cart;
import du.shop.entity.CartItem;
import du.shop.entity.Order;
import du.shop.entity.OrderItem;
import du.shop.entity.User;
import du.shop.service.OrderService;
import du.shop.util.PageBean;

/**
 * 
 * @author duyunfei
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	// ģ������ʹ�õĶ���
		private Order order = new Order();

		public Order getModel() {
			return order;
		}


		// ����page
		private Integer page;

		public void setPage(Integer page) {
			this.page = page;
		}

		// ע��OrderService
		private OrderService orderService;

		public void setOrderService(OrderService orderService) {
			this.orderService = orderService;
		}

		// ���ɶ�����ִ�еķ���:
		public String saveOrder() {

			// ����Service������ݿ����Ĳ���:
			// Order order = new Order();
			// ���ö������ܽ��:�������ܽ��Ӧ���ǹ��ﳵ���ܽ��:
			// ���ﳵ��session��,��session�ܻ�ù��ﳵ��Ϣ.
			Cart cart = (Cart) ServletActionContext.getRequest().getSession()
					.getAttribute("cart");
			if (cart == null) {
				this.addActionMessage("��!����û�й���!");
				return "msg";
			}
			order.setTotal(cart.getTotal());
			// ���ö�����״̬
			order.setState(1); // 1:δ����.
			// ���ö���ʱ��
			
			order.setOrdertime(new Date());
			// ���ö��������Ŀͻ�:
			User existUser = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("existUser");
			if (existUser == null) {
				this.addActionMessage("��!����û�е�¼!");
				return "msg";
			}
			order.setUser(existUser);
			// ���ö������:
			for (CartItem cartItem : cart.getCartItems()) {
				// ���������Ϣ�ӹ������õ�.
				OrderItem orderItem = new OrderItem();
				orderItem.setCount(cartItem.getCount());
				orderItem.setSubtotal(cartItem.getSubtotal());
				orderItem.setProduct(cartItem.getProduct());
				orderItem.setOrder(order);

				order.getOrderItems().add(orderItem);
			}
			orderService.save(order);
			// ��չ��ﳵ:
			cart.clearCart();

			// ҳ����Ҫ���Զ�����Ϣ:
			// ʹ��ģ�������� ���п��Բ�ʹ��ֵջ������
			// ActionContext.getContext().getValueStack().set("order", order);

			return "saveOrder";
		}

		// ��ѯ�ҵĶ���:
		public String findByUid() {
			// ����û���id.
			User existUser = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("existUser");
			// ����û���id
			Integer uid = existUser.getUid();
			// �����û���id��ѯ����:
			PageBean<Order> pageBean = orderService.findByUid(uid, page);
			// ��PageBean���ݴ���ҳ����.
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findByUid";
		}

		// ���ݶ���id��ѯ����:
		public String findByOid() {
			order = orderService.findByOid(order.getOid());
			return "findByOid";
		}

		//����
		public String payOrder(){
			//�޸Ķ���
			Order currOrder = orderService.findByOid(order.getOid());
			currOrder.setAddr(order.getAddr());
			currOrder.setName(order.getName());
			currOrder.setPhone(order.getPhone());
			orderService.update(currOrder);
			//Ϊ��������
			/*
			 * �̳̲����ױ�
			 * ż������֧����
			 *
			 * 
			 */
			currOrder.setState(2);
			orderService.update(currOrder);
			this.addActionError("��������ɹ���������ţ�"+currOrder.getOid()+" �����"+currOrder.getTotal());
			//�����ѵ�ʵ����
			
			//������д��̫����
			return "msg";
		/*public String callBack(){
			//�޸Ķ���״̬Ϊ�Ѹ���
			Orders currOrder = orderService.findByOid(orders.getOid());
			currOrder.setState(2);
			orderService.update(currOrder);
			this.addActionError("��������ɹ���������ţ�"++" �����"+);
			return "msg";
		}*/
		}
		
		// �޸Ķ�����״̬:
		public String updateState(){
			Order currOrder = orderService.findByOid(order.getOid());
			currOrder.setState(4);
			orderService.update(currOrder);
			return "updateStateSuccess";
		}
}
