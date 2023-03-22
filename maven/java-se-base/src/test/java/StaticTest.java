import com.litongjava.util.ConfigUtil;

/**
 * @author litong
 * @date 2018年6月5日_下午2:04:27 
 * @version 1.0
 * 静态类和静态方法谁会先执行 
 */
public class StaticTest {
	
	//静态属性也是只执行一次吗,因为有静态代码库,静态属性也只执行一次
	public static String key=ConfigUtil.getValue("appkey");
	
	//static 静态代码块只执行一次
	static {
		System.out.println(key);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(key);
		}
	}

}
