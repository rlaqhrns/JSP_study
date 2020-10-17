
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page language="java" import="java.sql.*"%>

<%

String id = request.getParameter("id");
String password = request.getParameter("password").trim();
String name = request.getParameter("name");
String email = request.getParameter("email");
System.out.println("name : "+name+", email : " + email);
	Connection conn = null;
Statement st = null;
ResultSet rs = null;

//jdbc-odbc driver 등록

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
	out.println(e);
}
//String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
String dbURL = "jdbc:mysql://localhost:3306/member?useSSL=false";
String dbId = "root";
String dbPassword = "12190628";
System.out.println("1단계!!");
// DB와 연결

try {
	conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
	System.out.println("db 연결 성공!!");
	st = conn.createStatement();
	st.executeUpdate("delete from woori where id = " + id);

} catch (SQLException e) {
	out.println("<script>alert('가입처리되지 않았습니다. 다시 시도해주세요.');</script>");
}

try {
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
} catch (SQLException e) {
	out.println(e);
}
%>

<a href="main.html">GOGO!!</a>