<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <p><a href="jstl01.jsp">[이전]</a></p>
    <p><a href="jstl03.jsp">[다음]</a></p>
 
    <h3>값 설정 방식</h3>
    <c:set var="username1" value="홍길동" />
    <c:set var="username2">임꺽정</c:set>
    1) ${username1}<br>
    2) ${username2}<br>
    <h3>기본 보관소</h3>
    3) ${pageScope.username1}<br>
    4) ${requestScope.username1}<br>
    <h3>보관소 지정 - scope 속성</h3>
    <c:set var="username3" scope="request">일지매</c:set>
    5) ${pageScope.username3} <br>
    6) ${requestScope.username3}<br>
    <h3>기존값 덮어씀</h3>
    <% pageContext.setAttribute("username4","똘이장군");%>
    7) 기존값 = ${username4} <br>
    8) 덮어쓴 값 = ${username4} <br>
    <h3> 객체의 프로퍼티 값 변경 </h3>
    <%!
        public static class MyMember{
            int no;
            String name;
            public int getNo(){return this.no}
            public void setNo(){this.no = no}
            public String getName(){return this.naem}
            public coid setName(String name){this.name = name;}
        }
        %>
        <% 
            MyMember member = new MyMember();
            member.setNo();
            member.setName("홍길동");
            pageContext.setAttribute("member",member);
        
        %>
        9) ${member.name}<br>
        <c:set target = "${member}" property = "name" value="임꺽정" />
        10) ${member.name}<br>
       
       
    
    <p><a href="jstl01.jsp">[이전]</a></p>
    <p><a href="jstl03.jsp">[다음]</a></p>
</body>
</html>