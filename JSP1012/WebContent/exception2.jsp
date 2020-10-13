<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isErrorPage="true" %>
<%

	/* 위의 isErrorPage를 true로 설정 할 때만 동작 */
	out.print("에러 발생" + exception.getMessage());
%>