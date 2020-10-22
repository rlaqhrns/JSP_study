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
    <p><a href="jstl02.jsp">[이전]</a></p>
    <p><a href="jstl04.jsp">[다음]</a></p>
 	
    <h2>c:remove 태그</h2>
    <h3>보관소에 저장된 값 제거</h3>
    <% pageContext.setAttribute("username1","홍길동");%>
    1) ${username1}<br>
    <c:remove var = "username1"/>
    1) ${username1}<br>

    <p><a href="jstl02.jsp">[이전]</a></p>
    <p><a href="jstl04.jsp">[다음]</a></p>
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