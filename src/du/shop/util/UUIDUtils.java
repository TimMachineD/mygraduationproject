package du.shop.util;

import java.util.UUID;

/**
 * ��������ַ���
 * @author Administrator
 *
 */
public class UUIDUtils {
	/**
	 * �������ַ���
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
