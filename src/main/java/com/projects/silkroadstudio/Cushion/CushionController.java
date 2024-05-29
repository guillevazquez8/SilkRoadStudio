package com.projects.silkroadstudio.Cushion;

import com.projects.silkroadstudio.Customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cushion")
public class CushionController {
    private final CushionService cushionService;
}
