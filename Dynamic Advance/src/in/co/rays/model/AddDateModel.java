package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.Bean.AddDateBean;
import in.co.rays.util.JDBCDataSource;

public class AddDateModel {
	public static void AddDate(AddDateBean bean) throws Exception {
		Connection conn = JDBCDataSource.getconnetion();
		PreparedStatement ps = conn.prepareStatement("insert into parson values(?)");
		ps.setDate(1, new java.sql.Date(bean.getdob().getTime()));

		int i = ps.executeUpdate();
		System.out.println("Date inserted =  " + i);
		conn.close();
	}

}
