package com.projects.silkroadstudio.User;

import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) throws IncorrectInformationProvidedException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IncorrectInformationProvidedException("Entered user ID does not exist.");
        }
        return user.get();
    }

    public User findByName(String name) throws IncorrectInformationProvidedException {
        Optional<User> user = userRepository.findByName(name);
        if (user.isEmpty()) {
            throw new IncorrectInformationProvidedException("Entered user name does not exist.");
        }
        return user.get();
    }

}
