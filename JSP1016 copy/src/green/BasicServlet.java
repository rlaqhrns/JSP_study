package green;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/z")
public class BasicServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
    
    public BasicServlet() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      System.out.println("여기 잘 들어오나" + " " + request.getParameter("kor"));
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      System.out.println("여기 포스트 잘 들어오나" + " " + request.getParameter("kor"));
//      doGet(request, response);
   }

}