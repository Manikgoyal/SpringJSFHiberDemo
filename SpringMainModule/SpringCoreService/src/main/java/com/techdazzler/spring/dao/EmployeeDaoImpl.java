package com.techdazzler.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.techdazzler.hibernate.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		 Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
	        query.setString("ssn", ssn);
	        query.executeUpdate();

	}

	@Override
	public Employee findBySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

}
