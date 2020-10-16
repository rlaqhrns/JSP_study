<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language ="java" import ="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %> 

<%
   String id = request.getParameter("id");
   String password = request.getParameter("password").trim();
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   System.out.println("name : "+name+", email : " + email);
   
   String sql = null;
   Connection conn = null;
   Statement st = null;
   ResultSet rs = null;
   int cnt = 0;

   //jdbc-odbc driver 등록
   try{
      Class.forName("com.mysql.cj.jdbc.Driver");
   } catch(ClassNotFoundException e){
      out.println(e);
   }
   //DB와연결
   try{
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member?useSSL=false",
   "root", "12190628");
      System.out.println("db 연결성공  " +conn );//여기 출력 
   } catch(SQLException e){
      out.println(
   "<script>alert('가입처리되지 않았습니다. 다시 시도해주세요 ')</script>");
   }

   //쿼리를 실행함
   try{
      st = conn.createStatement();  // 숙지하도
      rs = st.executeQuery("select * from woori where id = '" + id + "'");
      if(!(rs.next())){
         //Statement 객체 생성
         System.out.println(id+password+name+email);
         sql = "insert into woori(id, password, name, email)";
         sql = sql + " values('" + id+ "'," + password + ",";
         sql = sql + "'" +name + "','" + email +"')";
         //insert 문을 이용하여 데이터 추가
         cnt = st.executeUpdate(sql);
         System.out.println(cnt);
        //콘솔로cnt 찍어보
         if(cnt > 0) out.println("데이터가 성공적으로 입력되었습니다.");
         else out.println("데이터가 입력되지 않았습니다.");
      } else out.println("id가 이미 등록되어 있습니다.");
      st.close();

      conn.close();
   } catch(SQLException e){
      out.println(e.getMessage());
   }
%>
<a href = main.html>메인으로</a>
&nbsp; [<a href="insert.html"> 회원등록 페이지로 </a>]