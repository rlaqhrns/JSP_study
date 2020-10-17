package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("serial")
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
    
	private HashMap<String, Score> scoreTbl = new HashMap<String, Score>();
	
	
    public Login() {
        //super();
    	scoreTbl.put("+", new Green());
    	scoreTbl.put("-", new Bus());
    	scoreTbl.put("*", new Tire());
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		double id = Double.parseDouble(request.getParameter("id"));
		double password = Double.parseDouble(request.getParameter("password"));
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>계산결과</h1>");
		out.println("result : ");
		
		try {
			Score score = scoreTbl.get(op);
			if(score == null) {
				out.println("존재하지 않는 연산");
			}else {
				double result = score.go(id, password);
				out.println(String.format("%.3f", result));
			}
		}catch(Exception e) {
			out.println("error");
		}
		out.println("</body></html>");
		doGet(request, response);
	}

}
