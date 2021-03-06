<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="entity.*" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>修改员工</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>
  <body>
    <div id="wrap">
      <div id="top_content">
        <%@include file="header.jsp" %>  
        <div id="content">
          <p id="whereami"></p>
          <h1>修改员工:</h1>
          <%--注释掉
          <%Employee e=(Employee)request.getAttribute("e");%>
          <form action="modify.do?empno=<%=e.getEmpno()%>" method="post">
          --%>
          <form action="modify.do?empno=${e.empno}" method="post">
            <table cellpadding="0" cellspacing="0" border="0" class="form_table">
              <tr>
                <td valign="middle" align="right">编号:</td>
                <td valign="middle" align="left">${e.empno}</td>
              </tr>
              <tr>
                <td valign="middle" align="right">姓名:</td>
                <td valign="middle" align="left"><input type="text" class="inputgri" name="ename" value="${e.ename}"/></td>
              </tr>
              <tr>
                <td valign="middle" align="right">薪水:</td>
                <td valign="middle" align="left"><input type="text" class="inputgri" name="sal" value="${e.sal}"/></td>
              </tr>
              <tr>
                <td valign="middle" align="right">年龄:</td>
                <td valign="middle" align="left"><input type="text" class="inputgri" name="age" value="${e.age}"/></td>
              </tr>
            </table>
            <p><input type="submit" class="button" value="提交" /></p>
          </form>
        </div>
      </div>
      <%@include file="footer.jsp" %>
    </div>
  </body>
</html>