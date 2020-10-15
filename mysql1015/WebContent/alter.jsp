<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page language="java" import="java.sql.*"%>

<%
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
	System.out.println("3단계!!");
	conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
	System.out.println("db 연결 성공!!" + conn);// 

} catch (SQLException e) {
	System.out.println("2단계!!");
	out.println("<script>alert('가입처리되지 않았습니다. 다시 시도해주세요.');</script>");
}

try {
	st = conn.createStatement();
	st.executeUpdate("alter table woori modify name char(10) not null");
	st.executeUpdate("alter table woori add email char(30)");
	st.executeUpdate("alter table woori add password integer");
} catch (SQLException e) {
	out.println(e);
}

try {
	rs = st.executeQuery("select * from woori");
	System.out.println(rs);
	ResultSetMetaData rsmd = rs.getMetaData(); //Metadata는 정보
	
	out.println("새로운 테이블이 수정되었습니다. <br>");
	out.println(rsmd.getColumnCount() + "개의 컬럼(필드)를 가지고 있습니다.");
	for(int i = 1;i<=rsmd.getColumnCount();i++){
	out.println(i+" 번째 칼럼은 " + rsmd.getColumnName(i));
	out.println("이고 유형은 " + rsmd.getColumnTypeName(i));
	out.println("이며 크기는 " + rsmd.getPrecision(i) + "<br>");
		
	}
	
	rs.close();
	st.close();
	conn.close();
} catch (SQLException e) {
	out.println(e);
}
%>

<a href="main.html">GOGO!!</a>