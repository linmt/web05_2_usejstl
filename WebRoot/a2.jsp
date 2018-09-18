<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		a2的内容<br/>
		<a href="biz01/a1.jsp">访问a1.jsp</a><br/>
		<a href="/web05_2/biz01/a1.jsp">访问a1.jsp</a><br/>
		<a href="<%=request.getContextPath()%>/biz01/a1.jsp">访问a1.jsp</a>
	</body>
</html>