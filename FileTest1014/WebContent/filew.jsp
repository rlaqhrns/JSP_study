<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%
	
	String infile = "/Users/rlaqhrns/dev/JSP/FileTest1014/WebContent/filew.jsp";
	String outfile = "/Users/rlaqhrns/dev/JSP/text/filewcopy.txt";

	int ch = 0;
	File inf = new File(infile);
	File outf =  new File(outfile);

	FileReader filer = new FileReader(inf);
	FileWriter filew = new FileWriter(outfile);
	try{
		while((ch = filer.read()) != -1){
			filew.write(ch);
		}
		filer.close();
		filew.close();

	} catch(IOException e){
		out.println(e.getMessage());
		
	}


%>