package com.projects.silkroadstudio.User;

import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "API to get users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) throws IncorrectInformationProvidedException {
        return userService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public User findByName(@PathVariable String name) throws IncorrectInformationProvidedException {
        return userService.findByName(name);
    }

}
