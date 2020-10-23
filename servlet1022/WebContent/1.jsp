<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   전송되어 오는 값은? : ${a}<br>
   두 번째로 전송되어 오는 이름 값은? : ${member.name}<br><br>
   
   <c:set var="mem" value="${requestScope.member}"/>
   <form action="r" method="get">
      비밀번호 : <input type="text" name="pw" value="${mem.email}">
      주소 : <input type="text" name="addr" value="${mem.name}">
      전화번호 : <input type="text" name="tel" value="${mem.no}">
      <input type="submit" value="전송">
   </form>
   <c:url var="calcUrl" value="http://localhost:8080/r">
      <c:param name="v1" value="30"/>
      <c:param name="v2" value="20"/>
      <c:param name="op" value="+"/>
   </c:url>
   <a href="${calcUrl}">계산하기</a>
   ${pw}, ${addr}, ${tel}, ${result}
</body>
</html>