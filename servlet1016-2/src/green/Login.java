package green;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id").equals("1")){
			Score green = new Green();
			PrintWriter out = response.getWriter();
			out.println(green.go(3, 4))	;
		}
		
		if(request.getParameter("id").equals("2")){
			Score bus = new Bus();
			PrintWriter out = response.getWriter();
			out.println(bus.go(3, 4))	;
		}
		
		if(request.getParameter("id").equals("3")){
			 Score tire = new Tire();
			PrintWriter out = response.getWriter();
			out.println(tire.go(3, 4));
		}
	}

}
