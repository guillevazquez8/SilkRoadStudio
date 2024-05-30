package com.projects.silkroadstudio.Product.Cushion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cushion")
public class CushionController {
    private final CushionService cushionService;
}
