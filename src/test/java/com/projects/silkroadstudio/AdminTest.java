package com.projects.silkroadstudio;

import com.projects.silkroadstudio.User.Admin.Admin;
import com.projects.silkroadstudio.User.Admin.AdminRepository;
import com.projects.silkroadstudio.User.Admin.AdminService;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.User.Role.Role;
import com.projects.silkroadstudio.User.Role.RoleRepository;
import com.projects.silkroadstudio.User.User;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @AfterEach
    void tearDown() {
        adminRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @SneakyThrows
    @Test
    void testCreateAdmin() {
        Role admin_role = new Role(ERole.ROLE_ADMIN);
        roleRepository.save(admin_role);
        Admin admin_user = new Admin("Iago", "Aspas", "iagoaspas@email.com", "12345678910", admin_role);
        Admin admin1 = adminService.save(admin_user);

        assertEquals(admin1.getName(), "Iago");
    }


}
