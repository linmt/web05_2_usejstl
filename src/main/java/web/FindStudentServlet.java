package web;

import entity.Course;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 张洲徽 on 2018/9/19.
 */
public class FindStudentServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        //1.获取参数（略）
        //2.处理业务
        Student stu=new Student();
        stu.setName("张三");
        stu.setAge(23);
        stu.setSex("M");
        stu.setInterests(new String[]{"琴","棋","书","画"});
        Course c=new Course();
        c.setId(1);
        c.setName("java");
        c.setDays(80);
        stu.setCourse(c);
        //3.转发或重定向
        req.setAttribute("stu",stu);
        //当前：
        req.getRequestDispatcher("find_student.jsp").forward(req, res);
        //目标：
    }
}
