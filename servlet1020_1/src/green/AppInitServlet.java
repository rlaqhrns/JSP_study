package green;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AppInitServlet
 */
@SuppressWarnings("serial")
@WebServlet("/AppInitServlet")
public class AppInitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("AppInitServlet ready...");

		super.init(config); // 부모클래스(HttpServlet)에게 파라미터로 받은 config 전달

		try {
			ServletContext sc = this.getServletContext();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul", "root", "1234");
			System.out.println("DB 접속 성공" + conn);
			sc.setAttribute("conn", conn);
		} catch (Throwable e) {
			throw new ServletException();
		}
	}

	@Override
	public void destroy() {
		System.out.println("AppInitServlet end ....");
		super.destroy();
	Connection conn = (Connection)this.getServletContext().getAttribute("conn");
	
	try {
		if(conn != null && conn.isClosed() == false) {
			conn.close();
		} 
	}catch (Exception e) {}
	
	}

}
