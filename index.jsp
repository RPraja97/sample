<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
out.print("WELCOME");
%>
<h1>Hai </h1>
<%!
int a=5;
int  b=a;
public void test(){
	System.out.println(b);}
%>
<%=b %>
<% out.println(b);
test();
%>

</body>
</html>