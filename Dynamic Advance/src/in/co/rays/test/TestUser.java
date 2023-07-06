package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.Bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {

	public static void main(String[] args) throws Exception {

		// testadd();
		testsearch();

	}

	private static void testsearch() throws Exception {

		UserModel m = new UserModel();
		List list = m.search();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserBean bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print(bean.getFirstname());
			System.out.print(bean.getLastname());
			System.out.print(bean.getLoginid());
			System.out.print(bean.getPassword());
			System.out.println(bean.getAdress());

		}
	}

	private static void testadd() throws Exception {

		UserBean bean = new UserBean();

		bean.setFirstname("Shardha");
		bean.setLastname("pushpad");
		bean.setLoginid("shardha114@gmail.com");
		bean.setPassword("shardha@123");
		bean.setAdress("indore");

		UserModel m = new UserModel();

		m.add(bean);

	}

}
