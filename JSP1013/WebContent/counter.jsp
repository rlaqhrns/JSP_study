<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" scope="application" class="green.Counter" />

<%
	int count = 0;
	session = request.getSession(); //세션 얻어옴(생성)
	session.setMaxInactiveInterval(1); //1초 세션 유지
	 //추가
	String first = (String) session.getValue("checkfirst");

	if(first != null){ 
		count = cnt.getCount();

	}else { 
		cnt.setCount();
		count = cnt.getCount();
		session.putValue("checkfirst","first");
	}
	out.println("현재까지 방문자 수 : " + count + "<br>세션에 저장된 정보 " +
					session.getValue("checkfirst"));
	
%>