<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
   <%
   
   		String indir ="/Users/rlaqhrns/dev/JSP/text";
        String infile = "count.txt"

        int i = 0;
        File dir = new File(indir);
        File afile = null;
        File check = new File(indir, infile);

        if(check.exists()){
            out.println(indir+"경로에 " + infile + "파일이 존재합니다. ");

        }else{
            out.println(indir + "경로에 " + infile + "파일은 없습니다. ");

        }
        out.println("<p>");
        String [] dirlist = dir.list();
        out.println("디렉토리/폴더들 <br>");
%>