<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language ="java" import ="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
   String id = request.getParameter("id");
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   
   String sql = null;
   Connection conn = null;
   Statement st = null;
   
   //jdbc-odbc driver 등록
   try{
      Class.forName("com.mysql.cj.jdbc.Driver");
   } catch(ClassNotFoundException e){
      out.println(e);
   }
   //DB와연결
   try{
      conn= 
         DriverManager.getConnection("jdbc:mysql://localhost:3306/member?useSSL=false",
         "root", "12190628");
      System.out.println("db 연결성공  " +conn );
   } catch(SQLException e){
      out.println(e.getMessage());
   }

   try{
        st = conn.createStatement();
      //질의어 수행
        sql = "update woori set";
      sql = sql + "'name = '" + name + "', '" + "'email ='" + email + "', ";
      sql = sql + " where id = '" + id + "'";
        st.executeUpdate(sql);
        st.close();
        conn.close();
    } catch(SQLException e){
        out.println(e);
    }
%>
<jsp:foward page = "selectall.jsp"/>