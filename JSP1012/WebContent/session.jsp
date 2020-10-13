<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    
    	request.setCharacterEncoding("UTF-8");
    	String userId = request.getParameter("id");
    	String password = request.getParameter("passwd");
    	
    	
    	String sessionId = session.getId();
    	session.setMaxInactiveInterval(5000);
    	int sessionTime = session.getMaxInactiveInterval();
    	session.invalidate();
    	out.print(userId + "님 환영합니다. <br>");
    	out.print("생성된 세션 id : " + sessionId + "<p>");
    	out.print("세션유지 시간 : " + sessionTime);
    
    %>[]