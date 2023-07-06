package in.co.rays.ctl;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.co.rays.Bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("Operation");
		
		if (op != null && op.equalsIgnoreCase("Logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		RequestDispatcher rd = req.getRequestDispatcher("LoginRagistration.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String login = req.getParameter("LoginId");
		//String pass = req.getParameter("password");
		

		try {
			UserModel model = new UserModel();
			String login = req.getParameter("LoginId");
			String pass = req.getParameter("password");
			String uri = req.getParameter("uri");
			

			UserBean bean = model.authenticate(login, pass);

			if (bean != null) {
				HttpSession session = req.getSession();
				session.setAttribute("fname", bean.getFirstname());
				if (uri.equalsIgnoreCase("null")) {
					RequestDispatcher rd = req.getRequestDispatcher("Wlcm.jsp");
					rd.forward(req, resp);
				
					
				}else {
					resp.sendRedirect(uri);
				}
				

			} else {
				System.out.println("invalid");
				req.setAttribute("msg", "Invalid Login password");
				RequestDispatcher rd = req.getRequestDispatcher("LoginRagistration.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
