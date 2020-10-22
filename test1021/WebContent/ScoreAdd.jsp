<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 입력</title>
</head>
<body>
	<h1>점수 입력</h1>
	
		<form action='add' method='post'>
		이름 : <input type='text' name='name'><br>
		국어 : <input type='text' name='kor'><br>
		수학 : <input type='text' name='math'><br>
		영어 : <input type='text' name='eng'><br>
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
		<input type="button" value='목록' onclick="location.href='list'">
		</form>
		
</body>
</html>