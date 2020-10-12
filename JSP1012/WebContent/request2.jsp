<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- 여기의 getParameter는 무조건 알아야 한다.-->
    
    <%
    	int kor = Integer.parseInt(request.getParameter("kor"));
    	int math = Integer.parseInt(request.getParameter("math"));
    	int eng = Integer.parseInt(request.getParameter("eng"));
    	
    	
    	out.print("입력된 국어점수 : " + kor + "<br>");
    	out.print("입력된 수학점수 : " + math + "<br>");
    	out.print("입력된 영어점수 : " + eng + "<br>");
    	
    %>
    