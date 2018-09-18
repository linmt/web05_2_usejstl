<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@page import="entity.*,java.util.*" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>员工列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>
  <body>
    <div id="wrap">
      <div id="top_content"> 
        <%@include file="header.jsp"%>
        <div id="content">
          <p id="whereami"></p>
          <h1>员工列表</h1>
          <table class="table">
            <tr class="table_header"><td>编号</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>
            <%--注释掉
            <%
              List<Employee> employees=(List<Employee>)request.getAttribute("emplist");
              for(int i=0;i<employees.size();i++){
                Employee e=employees.get(i);
            %>
            --%>
            <c:forEach items="${emplist}" var="u" varStatus="s">
              <tr class="row${s.index%2+1}">
                <td>${u.empno}</td>
                <td>${u.ename}</td>
                <td>${u.sal}</td>
                <td>${u.age}</td>
                <td>
                  <a href="del.do?empno=${u.empno}"onclick="return confirm('是否确定删除${u.ename}');">删除</a>&nbsp;
                  <a href="load.do?empno=${u.empno}">修改</a>
                </td>
              </tr>
            </c:forEach>
            <%--注释掉
            <tr class="row<%=(i%2+1)%>">
              <td><%=e.getEmpno()%></td>  <td><%=e.getEname()%></td>
              <td><%=e.getSal()%></td>      <td><%=e.getAge()%></td>
              <td>
                <a href="del.do?empno=<%=e.getEmpno()%>"onclick="return confirm('是否确定删除<%=e.getEname()%>');">删除</a>&nbsp;
                <a href="load.do?empno=<%=e.getEmpno()%>">修改</a>
              </td>
            </tr>
            <%}%>
            --%>
          </table>
          <p><input type="button" class="button" value="添加员工" onclick="location='addEmp.jsp'"/></p>
        </div>
      </div>
      <%@include file="footer.jsp" %>
    </div>
  </body>
</html>