
package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberAddServlet
 */
@SuppressWarnings("serial")
@WebServlet("/member/add" )
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>회원등록</title></head>");
		out.println("<body><h1>회원등록</h1>");
		out.println("<form action='add' method='post'>");
		out.println("이름 : <input type='text' name='name'><br>");
		out.println("이메일 : <input type='text' name='email'><br>");
		out.println("암호 : <input type='password' name='password'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("<input type='reset' value='취소'>");
		out.println("</form>");
		out.println("</body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul",
               "root", "1234");
         System.out.println("DB 접속 성공");
         stmt = conn.prepareStatement("insert into members (email, pwd, mname, cre_date, mod_date)"
        		 						+ " values (?,?,?, now(),now())");
         stmt.setString(1, request.getParameter("email"));
         stmt.setString(2, request.getParameter("password"));
         stmt.setString(3, request.getParameter("name"));
         stmt.executeUpdate();
         //리다이렉트를 이용한 리프레시
         response.sendRedirect("list"); //목록 보기로 이동
         
         response.setContentType("text/html;charset=utf-8");
         
     
		}catch(Exception e) {
			throw new ServletException();
		}finally {
			try {if(stmt!=null) stmt.close();}catch(Exception e) {}
			try {if(conn!=null) conn.close();}catch(Exception e) {}
		}
	}

}
