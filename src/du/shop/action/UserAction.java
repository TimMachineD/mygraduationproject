package du.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import du.shop.entity.User;
import du.shop.service.UserService;

/**
 * version 1.1 2017-03-13
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	// ģ������ʹ�õĶ���
		private User user = new User();

		public User getModel() {
			return user;
		}

		// ע��UserService
		private UserService userService;

		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		/**
		 * ��ת��ע��ҳ���ִ�з���
		 */
		public String registPage() {
			return "registPage";
		}

		/**
		 * AJAX�����첽У���û�����ִ�з���
		 * 
		 * @throws IOException
		 */
		public String findByName() throws IOException {
			// ����Service���в�ѯ:
			User existUser = userService.findByUsername(user.getUsername());
			// ���response����,��ҳ�����:
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			// �ж�
			if (existUser != null) {
				// ��ѯ�����û�:�û����Ѿ�����
				response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
			} else {
				// û��ѯ�����û�:�û�������ʹ��
				response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
			}
			return NONE;
		}

		/**
		 * �û�ע��ķ���:
		 */
		public String regist() {
			userService.save(user);
			this.addActionMessage("ע��ɹ�!��ȥ���伤��!");
			return "msg";
		}

		/**
		 * �û�����ķ���
		 */
		public String active() {
			// ���ݼ������ѯ�û�:
			User existUser = userService.findByCode(user.getCode());
			// �ж�
			if (existUser == null) {
				// ����������
				this.addActionMessage("����ʧ��:���������!");
			} else {
				// ����ɹ�
				// �޸��û���״̬
				existUser.setState(1);
				existUser.setCode(null);
				userService.update(existUser);
				this.addActionMessage("����ɹ�:��ȥ��¼!");
			}
			return "msg";
		}

		/**
		 * ��ת����¼ҳ��
		 */
		public String loginPage() {
			return "loginPage";
		}

		/**
		 * ��¼�ķ���
		 */
		public String login() {
			User existUser = userService.login(user);
			// �ж�
			if (existUser == null) {
				// ��¼ʧ��
				this.addActionError("��¼ʧ��:�û��������������û�δ����!");
				return LOGIN;
			} else {
				// ��¼�ɹ�
				// ���û�����Ϣ���뵽session��
				ServletActionContext.getRequest().getSession()
						.setAttribute("existUser", existUser);
				// ҳ����ת
				return "loginSuccess";
			}
		
		}
		
		/**
		 * �û��˳��ķ���
		 */
		public String quit(){
			// ����session
			ServletActionContext.getRequest().getSession().invalidate();
			return "quit";
		}
}
