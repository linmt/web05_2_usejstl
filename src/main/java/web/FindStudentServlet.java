package web;

import entity.Course;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ���޻� on 2018/9/19.
 */
public class FindStudentServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        //1.��ȡ�������ԣ�
        //2.����ҵ��
        Student stu=new Student();
        stu.setName("����");
        stu.setAge(23);
        stu.setSex("M");
        stu.setInterests(new String[]{"��","��","��","��"});
        Course c=new Course();
        c.setId(1);
        c.setName("java");
        c.setDays(80);
        stu.setCourse(c);
        //3.ת�����ض���
        req.setAttribute("stu",stu);
        //��ǰ��
        req.getRequestDispatcher("find_student.jsp").forward(req, res);
        //Ŀ�꣺
    }
}
