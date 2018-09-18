package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Employee;
public class EmployeeDAOImpl implements EmployeeDAO{
	//更改
	public void modify(Employee e) throws Exception{
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			PreparedStatement stat=conn.prepareStatement(
				"UPDATE emp SET ename=?,sal=?,age=? WHERE empno=?");
			stat.setString(1,e.getEname());
			stat.setDouble(2,e.getSal());
			stat.setInt(3, e.getAge());
			stat.setInt(4, e.getEmpno());
			stat.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
	}
	//保存
	public void save(Employee e) throws Exception{
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			PreparedStatement stat=conn.prepareStatement(
				"INSERT INTO emp (ename,sal,age) VALUES(?,?,?)");
			stat.setString(1,e.getEname());
			stat.setDouble(2,e.getSal());
			stat.setInt(3,e.getAge());
			stat.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
	}
	//查找
	public Employee findByEmpno(int empno) throws Exception{
		Employee e = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stat=
				conn.prepareStatement("SELECT * FROM emp WHERE empno=?");
			stat.setInt(1,empno);
			ResultSet rst = stat.executeQuery();
			if(rst.next()){
				String ename=rst.getString("ename");
				Double sal=rst.getDouble("sal");
				Integer age=rst.getInt("age");
				e=new Employee();
				e.setEmpno(empno);
				e.setEname(ename);
				e.setSal(sal);
				e.setAge(age);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
		return e;
	}
	//查找全部
	public List<Employee> findAll() throws Exception{
		List<Employee> employees=new ArrayList<Employee>();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			PreparedStatement stat=conn.prepareStatement(
				"SELECT * FROM emp");
			ResultSet rst=stat.executeQuery();
			while(rst.next()){
				Integer empno = rst.getInt("empno");
				String ename = rst.getString("ename");
				Double sal = rst.getDouble("sal");
				Integer age = rst.getInt("age");
				Employee e = new Employee();
				e.setEmpno(empno);
				e.setEname(ename);
				e.setSal(sal);
				e.setAge(age);
				employees.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return employees;
	}
	//删
	public void delete(int empno) throws Exception{
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			PreparedStatement stat=
				conn.prepareStatement("DELETE FROM emp WHERE empno=?");
			stat.setInt(1,empno);
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
}
