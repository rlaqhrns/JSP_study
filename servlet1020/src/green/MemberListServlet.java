package green;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;


@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //지역변수 선언
      //Connection 타입의 conn 지역변수 생성 및 null값 대임
      //Statement 타입의 stmt 지역변수 생성 및 null값 대입
      //ResultSet 타입의 rs 지역변수 생성 및 null값 대입
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
   
      
     
      
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul",
               "root", "1234");
         System.out.println("DB 접속 성공");
         stmt = conn.createStatement();
         rs = stmt.executeQuery("select mno, mname, email, cre_date"
               + " from members"
               + " order by mno asc");
         response.setContentType("text/html; charset=utf-8");
         
         PrintWriter out = response.getWriter();
         out.println("<html><head><title>회원목록</title></head>");
         out.println("<body><h1>회원목록</h1>");
         out.println("<p><a href='add'>신규회원</a></p>");
         
         while(rs.next()) {//DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴
            out.println(
               rs.getInt("mno") + ", " + "<a href = 'update?no=" + rs.getInt("mno") + "'>" +
               rs.getString("mname") + ", " +
               rs.getString("email") + ", " +
               rs.getDate("cre_date") + "<br>"
            );
            out.println("</body></html>");
         }
         
      } catch(Exception e){
         throw new ServletException();//예외를 던짐
         
      } finally {
         try { if(rs!=null) rs.close(); } catch(Exception e) {}
         try { if(stmt!=null) stmt.close(); } catch(Exception e) {}
         try { if(conn!=null) conn.close(); } catch(Exception e) {}         
      }
      
   }

}