<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	out.print("out.print() 메서드 출력.<br>");
    	
    // pageContext(page) 객체의 getOut() 메서드를 통해 out 객체의 print() ㅔ서드 호
    	pageContext.getOut().print(
    			"pageContext.getout() 메서드를 통해 출력.<br>");
    
   
    %>