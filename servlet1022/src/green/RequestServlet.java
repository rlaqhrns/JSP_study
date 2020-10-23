package green;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;


@SuppressWarnings("serial")
@WebServlet("/r")
public class RequestServlet extends HttpServlet {
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Member member = new Member();
      member.setEmail("aa@test.com");
      member.setName("aa");
      member.setNo(9);
      request.setAttribute("a", "7");
      request.setAttribute("member", member);
      
      request.setAttribute("pw", request.getParameter("pw"));
      request.setAttribute("addr", request.getParameter("addr"));
      request.setAttribute("tel", request.getParameter("tel"));
      
      int a = Integer.parseInt(request.getParameter("v1"));
      int b = Integer.parseInt(request.getParameter("v2"));
      String op = request.getParameter("op");
      int result;
      
      if(op.equals("+")) {
         result= a+b;
         request.setAttribute("result", result);
      }
      
      RequestDispatcher rd = request.getRequestDispatcher("1.jsp");
      rd.forward(request, response);
   }

}