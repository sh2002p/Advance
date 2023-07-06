package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstCtl")
public class FirstCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("do get");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");

		System.out.println(fname);
		System.out.println(lname);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("do post");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
	

		System.out.println(fname);
		System.out.println(lname);
		
		req.setAttribute("hello","what are you doing");

		RequestDispatcher rd = req.getRequestDispatcher("SecondCtl"); 
		rd.forward(req, resp);
	}

}
