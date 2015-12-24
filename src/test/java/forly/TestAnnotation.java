package forly;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.util.ObjectUtil;

public class TestAnnotation {
	public static void main(String[] args) {
		Funny f = new Funny();
		f.setId(0);
		f.setPublisher(new User());
		ObjectUtil.getProperty(f);
	}
}
