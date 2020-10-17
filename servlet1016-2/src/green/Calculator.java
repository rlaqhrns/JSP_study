package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/caculator")
public class Calculator extends HttpServlet {
	
	//멤버변수 operatorTable, 데이터 타입 Map<String, Operator>
	//생성자를 이용하여 객체 생성, 접근제한자 private
	//Map은 interface이기 때문에 바로 객체 생성 불가
	//그래서 그것의 자식인 HashMap을 이용
	//부모가 자식 객체를 가리킨다.
	private HashMap<String, Operator> operatorTable = new HashMap<String, Operator>();
	//HashMap<key, value(Operator : interface)>
	
	private static final long serialVersionUID = 1L;
    
    public Calculator() {//생성자
        //super();
    	//연산자 처리기를 등록
    	//객체의 참조변수(opratorTable)의 메서드인 put을 이용하여
    	//첫 번째 파라미터 문자열 "+", 두 번째 파라미터는 PlusOperator 클래스의 객체이다.
    	//그런데 일반적으로 객체를 생성한 후 파라미터로 전달하지만 다른 곳에서 사용하지 않을 것이면
    	//바로 객체를 생성하여 함수의 파라미터로 전달 가능
    	operatorTable.put("+", new PlusOperator());
    	operatorTable.put("-", new MinusOperator());
    	operatorTable.put("*", new MultipleOperator());
    	operatorTable.put("/", new DivideOperator());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에서 보낸 값을 꺼낸다.
		//문자열 변수 하나를 선언하고 doGet(이 함수)의 첫 번째 파라미터 request를 이용하여
		//HttpSevletRequest의 메서드인 getParameter를 이용하여 값을 가져오는데
		//그 파라미터는 문자열 "op"이고 requestParameter() 메서드의 반환값을 위에서 선언한 문자열 변수에 저장
		String op = request.getParameter("op");
		double v1 = Double.parseDouble(request.getParameter("v1"));
		double v2 = Double.parseDouble(request.getParameter("v2"));
		//클라이언트로 출력하기 위해 준비한다.
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>계산결과</h1>");
		out.println("결과 : ");
		
		//연산을 수행한 후 결과를 클라이언트로 출력
		try {
			Operator operator = operatorTable.get(op);
			if(operator == null) {
				out.println("존재하지 않는 연산자입니다.");
				
			}else {
				double result = operator.execute(v1, v2);
				out.println(String.format("%.3f", result));
				
			}
		}catch(Exception e) {
			out.println("연산 오류가 발생하였습니다.");
		}
		out.println("</body></html>");
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	
	
}
