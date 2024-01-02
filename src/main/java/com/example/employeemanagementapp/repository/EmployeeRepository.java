package com.example.employeemanagementapp.repository;

import com.example.employeemanagementapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
   List<Employee> findByNameContains(String keyword);

   //utilisons JPQL
   //@Query("select e from Employee e where e.name like %:x%")
   // List<Employee> find(@Param("x") String keyword);
}
