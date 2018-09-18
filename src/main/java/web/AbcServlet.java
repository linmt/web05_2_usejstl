package web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AbcServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getContextPath());  //  /web05_2
		System.out.println(request.getServletPath());  //  /abc
		System.out.println(request.getRequestURI());   //  /web05_2/abc
		System.out.println(request.getRequestURL());   //  http://localhost:8080/web05_2/abc
	}
}
