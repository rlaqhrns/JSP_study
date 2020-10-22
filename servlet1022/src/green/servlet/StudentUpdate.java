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
@WebServlet("/student/update")
public class StudentUpdate extends HttpServlet {

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
			RequestDispatcher rd = request.getRequestDispatcher("/ScoreUpdate.jsp");
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
			
			Score score = new Score();
			String name = request.getParameter("name");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int math = Integer.parseInt(request.getParameter("math"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			System.out.println(request.getParameter("num"));
			score.setName(name).setKor(kor).setMath(math).setEng(eng);
			
			stmt = conn.prepareStatement("update student set name=?, kor=?, math=?, eng=?, total=?, avg=?, grade=? where num=?");
			
			
			stmt.setString(1, score.getName());
			stmt.setInt(2, score.getKor());
			stmt.setInt(3, score.getMath());
			stmt.setInt(4, score.getEng());
			stmt.setInt(5, score.getTotal());
			stmt.setFloat(6, score.getAvg());
			stmt.setString(7, score.getGrade());
			stmt.setString(8, request.getParameter("num"));
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
