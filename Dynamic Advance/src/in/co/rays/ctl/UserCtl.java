package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.Bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		UserModel model = new UserModel();
		try {
			UserBean bean = (UserBean) model.findByPk(Integer.parseInt(id));
			req.setAttribute("Bean", bean);
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		String fname = req.getParameter("firstName");
//		String lname = req.getParameter("lastName");
//		String login = req.getParameter("loginId");
//		String pass = req.getParameter("password");
//		String adress = req.getParameter("Address");
//
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.print(fname + " " + lname + " " + login + " " + pass + " " + adress + " ");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String op = req.getParameter("Operation");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String Login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");

		UserBean bean = new UserBean();
		bean.setId(Integer.parseInt(id));
		bean.setFirstname(fname);
		bean.setLastname(lname);
		bean.setLoginid(Login);
		bean.setPassword(pass);
		bean.setAdress(address);

		UserModel model = new UserModel();
		if (op.equals("Ragistration")) {
			try {
				model.add(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if (op.equals("Update")) {
			try {
				model.Update(bean);
				resp.sendRedirect("UserListCtl.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
