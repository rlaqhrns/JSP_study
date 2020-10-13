<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% request.setCharacterEncoding("utf-8"); %>
<head>
<jsp:useBean id="info" scope="page" class="green.User" />
<jsp:setProperty name="info" property="name" />
<jsp:setProperty name="info" property="num" param="id" />
<style>
.center {
   margin-left: auto;
   margin-right: auto;
}
</style>
</head>
<body>
   <form method="post" action="setgetUser.jsp">
      <table border=0 width=300 class="center">
         <tr>
            <th bgcolor="#996699" colspan="2">
            <font color="white" size="+1">JSP   Beans 테스트</font>
            </th>
         </tr>
         <tr>
            <th width="20%" bgcolor="#BB6699" width="40%">
            <font color="white" size="-1">이름</font>
            </th>
            <td bgcolor="#99ccff" width="60%">
               <input type="text" name="name" 
                  value=<%= info.getName() %> size="10">
            </td>
         </tr>
         <tr>
            <th width="40%" bgcolor="#BB6699">
            <font color="white" size="-1">학번</font>
            </th>
            <td bgcolor="#99ccff">
               <input type="text" name="id"
                  value=<%= info.getNum() %> size="10">
            </td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" value="보내기">
               <input type="reset" value="다시쓰기">
            </td>
         </tr>
      </table>
   </form>
   
  
</body>
</html>