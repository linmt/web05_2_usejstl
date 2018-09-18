package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	/*	
	tomcat创建servlet逻辑：
	LoginServlet s=new LoginServlet();
	ServletConfig c=new ServletConfig();
	c.加载数据();从web.xml加载数据
	s.init(c);	
	*/
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	    System.out.println("初始化...");
	    String maxOnline=config.getInitParameter("maxOnline");
	    System.out.println(maxOnline);
	}	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		//http://localhost:8080/web05_2/lg
		ServletConfig cfg=getServletConfig();
		String maxOnline=cfg.getInitParameter("maxOnline");
		System.out.println(maxOnline);
		System.out.println("正在登录...");
	}
}
