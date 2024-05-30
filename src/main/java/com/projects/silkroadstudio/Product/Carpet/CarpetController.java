package com.projects.silkroadstudio.Product.Carpet;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carpet")
public class CarpetController {
    private final CarpetService carpetService;
}
