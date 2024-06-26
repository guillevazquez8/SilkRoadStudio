package com.projects.silkroadstudio;

import com.projects.silkroadstudio.User.Admin.Admin;
import com.projects.silkroadstudio.User.Admin.AdminRepository;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.User.Role.Role;
import com.projects.silkroadstudio.User.Role.RoleRepository;
import com.projects.silkroadstudio.User.User;
import com.projects.silkroadstudio.User.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserTest {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        Role admin = new Role(ERole.ROLE_ADMIN);
        roleRepository.save(admin);

        Admin guille_surimi = new Admin("Guille", "Surimi", "surimi@email.com", "12345678910", admin);
        adminRepository.save(guille_surimi);
    }

    @AfterEach
    void tearDown() {
        adminRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @SneakyThrows
    @Test
    void testGetUserById() {
        User user1 = userService.findByName("Guille");
        assertEquals(user1.getName(), "Guille");
    }

    @SneakyThrows
    @Test
    void testGetUserByIdWeb() {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/findByName/{name}", "Guille")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Guille"));
    }

}
