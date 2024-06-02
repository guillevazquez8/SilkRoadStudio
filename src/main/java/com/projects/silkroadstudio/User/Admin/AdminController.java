package com.projects.silkroadstudio.User.Admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "Admin", description = "API to create admin user")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

}
