package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.beans;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();

		String curSession = (String) session.getAttribute("mySession");
		System.out.println(curSession);

		
		

		if (curSession == null) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			// String username = request.getParameter("uname");
			// String password = request.getParameter("pword");
			
			// creating beanUsers name & password
			beans beanUser1 = new beans();
			//String n = request.getParameter("cookieName");
			//Cookie ck = new Cookie("cname", n);
			
			beanUser1.setUsername(request.getParameter("uname"));
			beanUser1.setPassword(request.getParameter("pword"));
			
			
			

			if (beanUser1.getUsername().equals("fredkarm") && beanUser1.getPassword().equals("hejhej")) {
				session.setAttribute("mySession", "Hi");
				session.setMaxInactiveInterval(25);
				//ck.setMaxAge(500);
				RequestDispatcher rd = request.getRequestDispatcher("welcomepage.jsp");
				rd.forward(request, response);
				

			} else if (beanUser1.getUsername().equals("pelle") && beanUser1.getPassword().equals("scheisse")) {
				session.setAttribute("mySession", "Hi");
				session.setMaxInactiveInterval(25);
				//ck.setMaxAge(500);
				RequestDispatcher rd = request.getRequestDispatcher("welcomepage.jsp");
				rd.forward(request, response);
				
			}

			else {
				out.println("<h3>something went wrong</h3>");
				out.println("did you try username fredkarm and password hejhej");
				out.println("or username pelle and password scheisse");
			}
			
		} else {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("welcomepage.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
