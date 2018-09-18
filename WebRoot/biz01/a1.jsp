<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>		
	<head></head>
	<body style="font-size:30px;">
		a1的内容<br/>
		<a href="../a2.jsp">访问a2.jsp</a><br/>
		<a href="/web05_2/a2.jsp">访问a2.jsp</a><br/>
		<a href="<%=request.getContextPath()%>/a2.jsp">访问a2.jsp</a>
	</body>
</html>