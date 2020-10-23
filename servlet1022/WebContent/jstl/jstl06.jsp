<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
    <p><a href="jstl05.jsp">[이전]<a href="jstl07.jsp">[다음]</a></p>
    <h2>c:foreach 태그</h2>
    <% pageContext.setAttribute("nameList", new String[] {"홍길동", "임꺽정", "일지매"}); %>
    <ul>
        <c:forEach var="name" items="${nameList}">
        <li>${name}</li>
        </c:forEach>
    </ul>
    <h3>반복문 - 배열의 시작 인덱스와 종료 인덱스 지정</h3>
    <% pageContext.setAttribute("nameList2",
        new String[] {"홍길동","임꺽정","일지매","주먹대장","똘이장군"});%>
        <ul>
            <c:forEach var="name" items="${nameList2}" begin="2" end="3">
                <li>${name}</li>
            </c:forEach>
        </ul>
        <h3>반복문 arrayList 객체</h3>
        <%
            ArrayList<String> nameList3 = new ArrayList<String>();
            nameList3.add("홍길동");
            nameList3.add("임꺽정");
            nameList3.add("일지매");
            nameList3.add("주먹대장");
            nameList3.add("똘이장군");
            pageContext.setAttribute("nameList3",nameList3);
        %>
        <ul>
            <c:forEach var="name" items="${nameLIst3}">
                <li>${name}</li>
            </c:forEach>
        </ul>
    <h3>반복문 ArrayList 객체 생성 하고 데이터(문자열) 추가하고 setAttribyte의 
    key로 nameList3과 추가된 데이터 연결하고
    그 결과를 반복문으로 출력</h3>
    
    <p><a href="jstl05.jsp">[이전]<a href="jstl07.jsp">[다음]</a></p>
</body>
</html>