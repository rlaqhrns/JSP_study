package green.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Score;

/**
 * Servlet implementation class StudentUpdate
 */
@SuppressWarnings("serial")
@WebServlet("/student/delete")
public class StudentDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/greendb?serverTimezone=Asia/Seoul", "root",
					"1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select * from student where num = " + request.getParameter("num"));
			//System.out.println("수정본이 잘들어나 ? " +rs.next());
			while(rs.next()) {
				request.setAttribute("score", new Score()
						.setNum(rs.getInt("num"))
						.setName(rs.getString("name"))
						.setKor(rs.getInt("kor"))
						.setMath(rs.getInt("math"))
						.setEng(rs.getInt("eng")));
			}
					
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/ScoreDelete.jsp");
			rd.include(request, response);
		} catch (Exception e) {throw new ServletException(e);
		} finally { 
			try { if (rs != null) rs.close();} catch (Exception e) {}
			try { if (stmt != null) stmt.close();} catch (Exception e) {}
			try {if (conn != null) conn.close();} catch (Exception e) {}
		}

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		//DB와 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/greendb?serverTimezone=Asia/Seoul", "root",
					"1234");
			System.out.println("DB 접속 성공 " + conn);
			
			stmt = conn.prepareStatement("delete from student where num=?");
			
			stmt.setString(1, request.getParameter("num"));
			stmt.executeUpdate();
			
			response.sendRedirect("list");
		} catch (Exception e) {
			throw new ServletException();
		}finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}
		}
	}

		
	

}
