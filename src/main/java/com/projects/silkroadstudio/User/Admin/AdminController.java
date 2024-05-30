package com.projects.silkroadstudio.User.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

}
