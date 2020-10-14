<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%
	
	String infile = "/Users/rlaqhrns/dev/JSP/FileTest1014/WebContent/filew.jsp";
	String outfile = "/Users/rlaqhrns/dev/JSP/text/filewcopy.txt";
	String strline = null;

	FileReader filer = new FileReader(new File(infile));
	FileWriter filew = new FileWriter(new File(outfile));
	BufferedReader bufr = new BufferedReader(filer);
	BufferedWriter bufw = new BufferedWriter(filew);


	try{
		while((strline = bufr.readLine()) != null){
			strline = strline + "<br>";
			bufw.write(strline,0,strline.length());
			bufw.newLine();
		}
		bufw.close();

	} catch(IOException e){
		out.println(e.getMessage());
		
	}
	
	bufr = new BufferedReader(new FileReader(outfile));
	try{
		while((strline = bufr.readLine()) != null){
			out.println(strline);

		}
		bufr.close();
	} catch(IOException e){
		out.println(e.getMessage());
	}


%>