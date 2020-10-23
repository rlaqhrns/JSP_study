package green.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

import green.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
   
   Connection conn;
    public void contextDestroyed(ServletContextEvent sce)  { 
       //db커넥션 객체 해제
       //웹 애플리케이션 종료될 때 호출되는 메서드
    }

    public void contextInitialized(ServletContextEvent event)  {
       //db커넥션 객체 준비
       //웹 애플리케이션 시작할 때 호출됨.공용 객체를 준비해야 하면 이 메서드 사용
       try {
         ServletContext sc = event.getServletContext();
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","root","1234");
         System.out.println("DB 접속 성공 "+conn);
         sc.setAttribute("conn", conn);
         MemberDao memberDao = new MemberDao();
         memberDao.setConnection(conn);
         sc.setAttribute("memberDao", memberDao);
      } catch (Throwable e) {
         e.printStackTrace();
      }
    }
   
}