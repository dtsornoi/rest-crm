package com.employee.crm;

import com.employee.crm.entity.Role;
import com.employee.crm.entity.User;
import com.employee.crm.persistance.RoleRepository;
import com.employee.crm.persistance.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleRepository roleDAO;

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("admin");
        roleDAO.save(role);

        User user = new User();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setRole(role);
        userDAO.save(user);
    }
}
