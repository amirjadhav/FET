package com.cybage;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cybage.Project;
import com.cybage.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByProjectProjectName(String projectName);
}
