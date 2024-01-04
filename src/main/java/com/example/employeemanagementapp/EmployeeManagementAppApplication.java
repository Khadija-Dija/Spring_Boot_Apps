package com.example.employeemanagementapp;

import com.example.employeemanagementapp.entities.Employee;
import com.example.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class EmployeeManagementAppApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;
    public static void main(String[] args) {

        SpringApplication.run(EmployeeManagementAppApplication.class, args);
        System.out.println("Hello World!");
    }


    @Override
    public void run(String... args) throws Exception {
     employeeRepository.save(new Employee(null,"John Doe", "Male", "1234567890", "john.doe@example.com",
                "ID123456", new Date(85, 7, 25)));
     employeeRepository.save(new Employee(null,"Bob Johnson", "Female", "5555555555", "bob.johnson@example.com",
              "ID333333", new Date(90, 7, 25)));
     employeeRepository.save(new Employee(null, "Bob Johnson", "Male", "5555555555", "bob.johnson@example.com",
             "ID333333", new Date(99, 7, 25)));

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();}
}
