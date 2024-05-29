package com.projects.silkroadstudio.User;

import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User findById(Long userId) throws IncorrectInformationProvidedException {
        return userService.findById(userId);
    }
}
