<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.io.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css" type="text/css">
    <title>Document</title>
</head>
<body>
    <%
    
        File board_file = new File("/Users/rlaqhrns/dev/JSP/text/write.txt");
        String s = null;

        try{
            FileReader in1 = new FileReader(board_file);
            BufferedReader in2 = new BufferedReader(in1);

            while((s = in2.readLine()) != null){
                out.println(s);
            }
            in2.close();
        }catch(IOException e){
            out.println(e.getMessage());
        }
    
    
    
    
    %>
    
    <center>
        <a href="filegb_write.html">
            <img src="./image/write.gif" alt="" width="54px" height="19px" border="0"></a>
    </center>
</body>
</html>