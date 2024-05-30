package com.projects.silkroadstudio;

import com.projects.silkroadstudio.Admin.Admin;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.User.Role.Role;
import com.projects.silkroadstudio.User.User;
import com.projects.silkroadstudio.User.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        User guille_surimi = new Admin("Guille", "Surimi", "surimi@email.com", "12345678910");

    }
}
