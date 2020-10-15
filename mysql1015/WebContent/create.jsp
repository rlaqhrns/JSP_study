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
 	//String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
 	String dbURL = "jdbc:mysql://localhost:3306/member?useSSL=false";
 	String dbId = "root";
 	String dbPassword = "12190628";
		System.out.println("1단계!!");
 	// DB와 연결
 	
 	try{
		System.out.println("3단계!!");
 		conn = DriverManager.getConnection(dbURL,dbId, dbPassword);
 		System.out.println("db 연결 성공!!");
 		
 		
 	}catch(SQLException e){
		System.out.println("2단계!!");
 		out.println("<script>alert('가입처리되지 않았습니다. 다시 시도해주세요.');</script>");
 	}
 	
 	try{
 		st = conn.createStatement();
 		st.executeUpdate("create table woori(id char(10) primary key, name char(10))");
 	}catch(SQLException e){
 		out.println(e);
 	}
	
 	try{
 		rs = st.executeQuery("select * from woori");
 		ResultSetMetaData rsmd = rs.getMetaData(); //Metadata는 정
 		out.println("새로운 테이블이 생성되었습니다. <br>");
 		out.println(rsmd.getColumnCount() + "개의 컬럼(필드)를 가지고 있습니다.");
 		out.println("첫번째 칼럼은 " + rsmd.getColumnName(1) + "<br>");
 		out.println("두번째 칼럼은 " + rsmd.getColumnName(2) + "<br>");
 		out.println("첫번째 칼럼은 " + rsmd.getColumnName(3) + "<br>");
 		out.println("두번째 칼럼은 " + rsmd.getColumnName(4) + "<br>");
 		rs.close();
 		st.close();
 		conn.close();
 	}catch(SQLException e){
 		out.println(e);
 	}
 %>
 
<a href="main.html">GOGO!!</a>