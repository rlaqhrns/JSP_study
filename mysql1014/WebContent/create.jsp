<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page language="java" import="java.sql.*" %>
 
 <%
 	Connection conn = null;
 	Statement st = null;
 	ResultSet rs = null;
 	
 	//jdbc-odbc driver 등록
 	
 	try{
 		Class.forName("com.mysql.cj.jdbc.Driver");
 	}catch(ClassNotFoundException e){
 		out.println(e);
 	}
 	String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
 	//String dbURL = "jdbc://localhost:3306/member?useSSL=false";
 	String dbId = "root";
 	String dbPassword = "12190628";
		System.out.println("1단계!!");
 	// DB와 연결
 	
 	try{
 		conn = DriverManager.getConnection(dbURL,dbId, dbPassword);
 		System.out.println("db 연결 성공!!");
 		
 	}catch(SQLException e){
		System.out.println("2단계!!");
 		out.println("<script>alert('가입처리되지 않았습니다. 다시 시도해주세요.');</script>");
		System.out.println("3단계!!");
 	}
 	
 %>