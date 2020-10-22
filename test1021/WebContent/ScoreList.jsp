<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="green.VOScore"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>
	<p>
		<a href='add'>신규 회원</a>
	</p>
	<%
		ArrayList<VOScore> scores = (ArrayList<VOScore>) request.getAttribute("scores");
	System.out.println("여기는 JSP");
	for (VOScore score : scores) {
	%>
	<%=score.getNum()%>. 
	이름 : <%=score.getName()%>,
	국어 : <%=score.getKor()%>점,
	수학 : <%=score.getMath()%>점,
	영어 : <%=score.getEng()%>점,
	합계 : <%=score.getTotal()%>점,
	평균 : <%=score.getAvg()%>점,
	학점 : <%=score.getGrade()%>
	<a href='update?num=<%=score.getNum()%>'>[수정]</a>
	<a href='delete?num=<%=score.getNum()%>'>[삭제]</a><br>
	<%
		}
	%>
	<br>
</body>
</html>