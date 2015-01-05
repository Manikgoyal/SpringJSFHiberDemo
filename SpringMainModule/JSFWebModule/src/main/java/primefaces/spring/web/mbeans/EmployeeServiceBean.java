package primefaces.spring.web.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;



import com.techdazzler.hibernate.model.Employee;
import com.techdazzler.spring.service.EmployeeService;


@Named
public class EmployeeServiceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Employee> employeeList;

	@Inject
	EmployeeService employeeService;
	
	public EmployeeServiceBean() {
		System.out.println("Bean Initialized");
		
	}
	
	
	public void populateEmployeeList(){
		employeeList = new ArrayList<Employee>();
		this.employeeList = employeeService.findAllEmployees();
	}
	
	public void deleteEmployee(String ssn){
		employeeService.deleteEmployeeBySsn(ssn);
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	
}
