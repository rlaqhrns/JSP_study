<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="green.VOScore"%>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
 
        <h1>회원정보</h1>
    <% VOScore score = (VOScore) request.getAttribute("score"); %>
	<form action='delete' method='post'>
        번호 : <input type='text' name='num' value = '<%=score.getNum() %>' readonly><br>
        이름 : <input type='text' name='name' value='<%=score.getName()%>' readonly><br>
        국어 : <input type='text' name='kor' value='<%=score.getKor()%>' readonly><br>
        수학 : <input type='text' name='math' value='<%=score.getMath()%>' readonly><br>
        영어 : <input type='text' name='eng' value='<%=score.getEng()%>' readonly><br>
       
        <input type='submit' value='삭제'>
        <input type='button' value='취소' onclick='location.href="list"'>
    </form>
</body>
</html>