<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;color:red;">
	<%--注释掉
		<%String msg=(String)request.getAttribute("error_msg");%>
		<%=msg%>
	--%>
		${error_msg}
	</body>
</html>