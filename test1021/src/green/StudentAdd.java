package green;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/student/add")
public class StudentAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/ScoreAdd.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement stmt = null;
		VOScore score = new VOScore();
		int kor = Integer.parseInt(request.getParameter("kor"));
		int math = Integer.parseInt(request.getParameter("math"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		score.setKor(kor).setMath(math).setEng(eng);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/greendb?serverTimezone=Asia/Seoul", "root",
					"1234");
			System.out.println("DB 접속 성공");

			stmt = conn.prepareStatement(
					"insert into student (name, kor, math, eng, total, avg, grade) values (?,?,?,?,?,?,?)");
			stmt.setString(1, request.getParameter("name"));
			stmt.setInt(2, score.getKor());
			stmt.setInt(3, score.getMath());
			stmt.setInt(4, score.getEng());
			stmt.setInt(5, score.getTotal());
			stmt.setFloat(6, score.getAvg());
			stmt.setString(7, score.getGrade());
			stmt.executeUpdate();
			// 리다이렉트를 이용한 리프레시
			response.sendRedirect("list"); // 목록 보기로 이동

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
