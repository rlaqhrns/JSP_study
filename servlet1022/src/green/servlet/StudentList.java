package green.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Score;

@SuppressWarnings("serial")
@WebServlet("/student/list")
public class StudentList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB와 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/greendb?serverTimezone=Asia/Seoul", "root",
					"1234");
			System.out.println("DB 접속 성공 " + conn);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT num, name, kor, math, eng, total, avg, grade" + " FROM Student" + " ORDER BY num");

			response.setContentType("text/html; charset=UTF-8");
			ArrayList<Score> scores = new ArrayList<Score>();// 추가
			// 데이터베이스에서 회원 정보를 가져와 Member에 담는다.
			// 그리고 Member객체를 ArrayList에 추가한다.
			while (rs.next()) {
				scores.add(new Score().setNum(rs.getInt("num")).setName(rs.getString("name")).setKor(rs.getInt("kor"))
						.setMath(rs.getInt("math")).setEng(rs.getInt("eng"))

				);
			}	
			// request에 회원 목록 데이터 보관한다.
			request.setAttribute("scores", scores);
			// JSP로 출력을 위임한다.
			RequestDispatcher rd = request.getRequestDispatcher("/ScoreList.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try { if (rs != null)rs.close();} catch (Exception e) {}
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (conn != null)conn.close();} catch (Exception e) {}
		}

	}

}
