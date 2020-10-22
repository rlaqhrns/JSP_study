<%@page import="green.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="green.vo.Member" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
	<%-- <jsp:include page="/Header.jsp" /> --%>
	<h1>회원정보</h1>
	
	<form action = "update" method = "post">
	번호 : <input type="text" name = 'no' vlaue= '<%=member.getNo() %>' readonly><br>
	이름 : <input type="text" name = 'name' vlaue= '<%=member.getName() %>' readonly><br>
	이메일 : <input type="text" name = 'email' vlaue= '<%=member.getName() %>' readonly><br>
	가입일 : <%=member.getCreatedDate() %><br>
	<input type='submit' value='저장'>
	<input type='button' value='삭제' onclick='location.href="delete?no=<%=member.getNo() %>";'>
	
	</form>
	<p>
		<a href='add'>신규 회원</a>
	</p>
	<%
		ArrayList<Member> members = (ArrayList<Member>) request.getAttribute("members");
	System.out.println("여기는 JSP" + members.get(0).getName());
	for (Member member : members) {
	%>
	<%=member.getNo()%>,
	<a href='update?no=<%=member.getNo()%>'><%=member.getName()%></a>,
	<%=member.getEmail()%>,
	<%=member.getCreatedDate()%>
	<a href='delete?no=<%=member.getNo()%>'>[삭제]</a>
	<br>
	<%
		}
	%>
	<%-- <jsp:include page="/Tail.jsp" /> --%>
</body>
</html>