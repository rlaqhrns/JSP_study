<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<b> 이제 move.jsp로 이동합니다.</b><p>

<!-- jsp action태그의 forward 연습 

    현재 페이지에서 다른 페이지로 제어권을 옮길 때 사용함
forward 액션 태그는 이동할 페이지로 request와 response 객체를
전달하기 때문에 이동되는 페이지에서도 원래 요청한 페이지의 객체를 그대로 사용가능
또한 포워딩이 일어난 후에도 시작 페이지의 url에 요청한 페이지의 주소가 나타나며
redirect () 메서드 보다 속도가 빠르다-->

<jsp:forward page ="move.jsp" />