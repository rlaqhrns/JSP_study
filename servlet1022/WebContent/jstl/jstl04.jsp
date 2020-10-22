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
    <p><a href="jstl03.jsp">[이전]</a></p>
    <p><a href="jstl05.jsp">[다음]</a></p>
 	
    <h2>c:if 태그</h2>
    <c:if test="${10>20}" var = "result1">
    1) 10은 20보다 크다 <br>
    </c:if>
    2) ${result1} <br>
    <c:if test="${10<20}" var = "result2">
    3) 10은 20보다 크다<br>
    </c:if>
    4)${result}<br>
    <p><a href="jstl03.jsp">[이전]</a></p>
    <p><a href="jstl05.jsp">[다음]</a></p>
    <%!
        public static class MyMember{
            int no;
            String name;
            public int getNo(){return this.no;}
            public void setNo(int no){this.no = no;}
            public String getName(){return this.name;}
            public void setName(String name){this.name = name;}
        }
        %>
        <% 
            MyMember member = new MyMember();
            member.setNo(100);
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