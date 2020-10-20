package green;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServlet를 상속하여 Calculator 클래스로 구현
 */
//@WebServlet({ "/Calculator", "/calculator", "/calc" })
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정수형 변수 a 선언
    	// request.getParameter() 호출시 문자열 "a"를 전달하고
    	// 반환되는 값을 정수형으로 변환(Integer.parseInt) 하여 a에 저장
    	int a = Integer.parseInt(request.getParameter("a"));
    	// 정수형 변수 b 선언
    	// request.getParameter() 호출시 문자열 "b"를 전달하고
    	// 반환되는 값을 정수형으로 변환(Integer.parseInt) 하여 b에 저장
    	int b = Integer.parseInt(request.getParameter("b"));
    	// 두번째 파라미터로 전달 받은 response의 HttpServletResponse
    	// 클래스의 메서드 setContentType()에 "text/plain"문자열 전달
    	// 두번째 파라미터로 전달 받은 response의 HttpServletResponse
    	// 클래스의 메서드 setCharacterEncoding()에 "UTF-8"문자열 전달
    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	// 하여 한글 깨짐 대책마련
    	// PrintWriter 데이터 타입의 참조변수 writer을 선언하고
    	// response의 메서드 getWriter() 호출하고 호된 결과를
    	// writer변수에 저장
    	PrintWriter writer = response.getWriter();
    	writer.println("a = " + a + "," + "b = " + b + "의 계산 결과입니다. ");
    	writer.println("a+b = " + (a+b));
    	writer.println("a-b = " + (a-b));
    	writer.println("a*b = " + (a*b));
    	writer.println("a/b = " + ((float)a/b));
    	writer.println("a%b = " + (a%b));
    	
    	
    	
	}

}
