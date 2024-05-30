package com.projects.silkroadstudio.User.Admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

}
