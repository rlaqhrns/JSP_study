<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" scope="application" class="green.Counter" />
<%@ page import= "java.io.*" %>
<%
	int count = 0;
	session = request.getSession(); //세션 얻어옴(생성)
	session.setMaxInactiveInterval(1); //1초 세션 유지
	
	String first = (String) session.getValue("checkfirst");
	
	String count_file = "/Users/rlaqhrns/dev/JSP/text/count.txt";

	if(cnt.getCount() == 0){ 
		int j = 0;
		String old = null;
		File infile = new File(count_file); // 파일객체 생성, 생성자의 파라미터로 파일이름
		try{ // 파일 입출력 또는 데이터 베이스 접근은 try catch로 감싼다.
			if(infile.exists()){
				BufferedReader input =
					new BufferedReader(new FileReader(infile));
				if((old = input.readLine()) != null){ // 한줄씩 읽어들인다.
					int i = Integer.parseInt(old);
					for(j = 0;j < i; j++){
						cnt.setCount();
					}
					input.close(); //파일 닫기
				}
			
			} 

		}catch(IOException e){
			out.println(e.getMessage());
		}
	} // 첫번째 이프문 빠이
	if(first != null){
		count = cnt.getCount();
	}else { 
	cnt.setCount();
	count = cnt.getCount();
	session.putValue("checkfirst","first");
	}
	if(count%10 == 0){
		try{
			count_file = "/Users/rlaqhrns/dev/JSP/text/count.txt";
			PrintWriter pw =
				new PrintWriter(new FileWriter(count_file));
			pw.println(count);
			pw.close();
		}catch(IOException e){
			out.println(e.getMessage());
		}
	}
	out.println("현재까지 방문자 수 : " + count + "<br>세션에 저장된 정보 " +
					session.getValue("checkfirst"));

%>