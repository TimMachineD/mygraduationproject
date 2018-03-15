package du.shop.util;

import java.util.UUID;

/**
 * 生成随机字符串
 * @author Administrator
 *
 */
public class UUIDUtils {
	/**
	 * 获得随机字符串
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
