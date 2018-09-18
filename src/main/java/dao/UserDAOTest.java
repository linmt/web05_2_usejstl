package dao;
import java.util.List;
import entity.Employee;
import entity.User;
public class UserDAOTest {
	public static void main(String[] args){
		try {
			testModify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testModify() throws Exception {
		UserDAOImpl dao = new UserDAOImpl();
		User u = dao.findByUserName("cat");
		System.out.println(u);
	}
	public void testFindAll() throws Exception {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		List<Employee> employees=dao.findAll();
		System.out.println(employees);
	}
	public void testSave() throws Exception {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee e = new Employee();
		e.setEname("kkk");
		e.setSal(new Double(1000));
		e.setAge(22);
		dao.save(e);
	}
	public void testDelete() throws Exception {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		dao.delete(1);
	}
	public void testFindById() throws Exception {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee e = dao.findByEmpno(3);
		System.out.println(e);
	}
}
