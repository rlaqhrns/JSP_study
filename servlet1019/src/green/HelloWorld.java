package green;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig; //추가
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebServlet(/hello);
public class HelloWorld implements Servlet{

//	멤버변수 선언
//	데이터 타입 Servletconfig, 참조변수 config
	
	ServletConfig config;
	int cnt;
	
	@Override
	public void destroy() {
		// 어플리케이션 종료될때 자동으로 호출됨
		System.out.println("destroy() 호출");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletXConfig() 호출됨");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		
		System.out.println("getServletInfo() 호출됨");
		return "version = 1.0; author = 이재오; 저작권 : 그린 2020";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 어플리케이션 실행시 자동으로 호출됨
		// 최초 1회만 실행된다.
		System.out.println("init() method 호출!!!");
		this.config = config;
		this.cnt = 0;
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// init() 메서드 다음으로 호출되는 메서드
		// service 메서드에서 doget, dopost로 전달됨
		//클라이언트 호출때 마다실행된다.
		System.out.println((this.cnt++)+ "번 service() 호출됨");
		
	}

}
