<!DOCTYPE html>
<html>
<head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Profile</title> 
</head>
<body>
	<h1>Profile</h1>
	<p>
		Name: 
		<%=
			request.getParameter("email")
		%>
	</p>
	<p>
		Name: 
		<%=
			request.getParameter("name")
		%>
	</p>
	<p>
		Phone number: 
		<%=	
						request.getParameter("phonenumber")
		%>
		
		<% 
		if (request.getParameter("phonenumber").length() == 11 &&
			request.getParameter("phonenumber").startsWith("09")
		) 
			{ 
		%>		
		<p> Valid phone number </p>
		</p>
		<% } else { %>
		<p> Invalid phone number!!! </p>
		<% } 
		%>
	</p>
</body	

</html>