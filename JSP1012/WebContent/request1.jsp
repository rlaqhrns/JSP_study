<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<b> request 객체 정보 </b> <p>


<%-- 클라이언트가 요청한 정보를 전송할때 사용한 인코딩 리턴  --%>
<%= "인코딩 방식 : " + request.getCharacterEncoding() + "<p>" %>