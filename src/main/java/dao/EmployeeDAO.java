package dao;
import java.util.List;
import entity.Employee;
public interface EmployeeDAO {
	//更改
	void modify(Employee e) throws Exception;
	//保存
	void save(Employee e) throws Exception;
	//查找
	Employee findByEmpno(int empno) throws Exception;
	//查找全部
	List<Employee> findAll() throws Exception;
	//删
	void delete(int empno) throws Exception;
}
