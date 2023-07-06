package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.source.tree.WhileLoopTree;

import in.co.rays.Bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getconnetion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getconnetion();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Insert into user values (?, ?, ? , ?, ?, ?)");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstname());
		ps.setString(3, bean.getLastname());
		ps.setString(4, bean.getLoginid());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAdress());

		int i = ps.executeUpdate();

		System.out.println("data inseted = " + i);

		conn.commit();
		conn.close();
	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Connection conn = JDBCDataSource.getconnetion();

		PreparedStatement ps = conn.prepareStatement("select * from user where loginid =? and password =?");
		ps.setString(1, loginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAdress(rs.getString(6));
		}

		return bean;
	}

	public List search() throws Exception {
		Connection conn = JDBCDataSource.getconnetion();
		PreparedStatement ps = conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAdress(rs.getString(6));
			list.add(bean);

		}

		return list;
	}

	public void Update(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getconnetion();
		PreparedStatement ps = conn.prepareStatement(
				"update user set firstName = ?, lastName = ?, loginId = ?, password = ?, address =? where id = ?");

		ps.setString(1, bean.getFirstname());
		ps.setString(2, bean.getLastname());
		ps.setString(3, bean.getLoginid());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAdress());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		conn.close();

		System.out.println("data updateed " + i);
		
	}

	public UserBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getconnetion();
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAdress(rs.getString(6));
		}
		return bean;
	}
}
