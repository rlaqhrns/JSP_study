<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="info" scope="page" class="green.User" />
<jsp:setproperty name="info" property="name" />
<jsp:setproperty name="info" property="num" param="id" />


<html>
<body>
    <center>
        <table border="0" width="0">
            <form method="POST">
                <tr>
                    <th bgcolor="#996699" colspan="2">
                    <font col="white" size="+1">JSP Beans 테스트</font>
                    </th>
                </tr>
                <tr>
                    <th width="20%" bgcolor="#BB6699" width="40%">
                        <font color="white" size="-1">이름</font>
                    </th>
                    <td bgcolor="#99ccff" width="60%">
                        <input type="text" name="name" value="<%=info.getName() %>" size="10">
                    </td>
                </tr>
                <tr>
                    <th width="40%" bgcolor="#BB6699">
                        <font color="white" size="-1">학번</font>
                    </th>
                    <td bgcolor="#99ccff" width="60%">
                        <input type="text" name="id" value="<%=info.getNum() %>" size="10">
                    </td>
                </tr>
            </form>
        </table>
    </center>
</body>
</html>