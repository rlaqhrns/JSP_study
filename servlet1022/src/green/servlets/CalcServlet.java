package green.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Good!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int a = Integer.parseInt(request.getParameter("v1"));
		int b = Integer.parseInt(request.getParameter("v2"));
		int result = 0;
		System.out.println("v1 : " + a);
		System.out.println("v2 : " + b);
		if(request.getParameter("op").equals("+")) {
			result = a+b;
			System.out.println("v1+v2 : " +result);
		}else if(request.getParameter("op").equals("-")) {
			result = a-b;
			System.out.println("v1-v2 : " +result);
		}else if(request.getParameter("op").equals("*")) {
			result = a*b;
			System.out.println("v1*v2 : " +result);
		}else if(request.getParameter("op").equals("/")) {
			result = a/b;
			System.out.println("v1/v2 : " +result);
		}
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.include(request, response);
		response.sendRedirect("jstl/jstl08.jsp");
	}


}
