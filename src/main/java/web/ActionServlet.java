package web;
import dao.EmployeeDAOImpl;
import dao.UserDAOImpl;
import entity.Employee;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String action =uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		if(action.equals("/list")){
			try {				
				List<Employee> employees =dao.findAll();
				request.setAttribute("emplist",employees);
				RequestDispatcher rd =request.getRequestDispatcher("empList.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				//String errmsg="system is busy,please try again later";
				//request.setAttribute("error_msg",errmsg);
				//为何中文会报错
				request.setAttribute("error_msg","system is busy,please try again later");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				}
		}else if(action.equals("/add")){
			String ename = request.getParameter("ename");
			String sal = request.getParameter("sal");
			String age = request.getParameter("age");
			try {
				Employee e = new Employee();
				e.setEname(ename);
				e.setSal(Double.parseDouble(sal));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/del")){
			int empno = Integer.parseInt(request.getParameter("empno"));
			try {
				dao.delete(empno);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/load")){
			Integer empno = Integer.parseInt(request.getParameter("empno"));
			try {
				Employee e = dao.findByEmpno(empno);
				request.setAttribute("e", e);
				request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/modify")){
			Integer empno =Integer.parseInt(request.getParameter("empno"));
			String ename =request.getParameter("ename");
			String sal =request.getParameter("sal");
			String age = request.getParameter("age");
			try {
				Employee e = new Employee();
				e.setEmpno(empno);
				e.setEname(ename);
				e.setSal(Double.parseDouble(sal));
				e.setAge(Integer.parseInt(age));
				dao.modify(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/regist")){
			UserDAOImpl userDAO=new UserDAOImpl();
			String userName =request.getParameter("username");
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd");
			String gender=request.getParameter("gender");
			try {
				User user = userDAO.findByUserName(userName);
				if(user!=null){
					request.setAttribute("regis_err","用户名已存在");
					request.getRequestDispatcher("regist.jsp").forward(request,response);
				}else{
					user=new User();
					user.setUserName(userName);
					user.setName(name);
					user.setPwd(pwd);
					user.setGender(gender);
					userDAO.save(user);
					response.sendRedirect("login.jsp");
				}				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/login")){
			UserDAOImpl userDAO=new UserDAOImpl();
			String userName =request.getParameter("username");
			String pwd=request.getParameter("pwd");
			try {
				User user = userDAO.findByUserName(userName);
				if(user==null||!user.getPwd().equals(pwd)){
					request.setAttribute("login_err","用户名或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request,response);
				}else{
					response.sendRedirect("list.do");
				}				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else{
			System.out.println(uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf(".")));
		}
	}
}
