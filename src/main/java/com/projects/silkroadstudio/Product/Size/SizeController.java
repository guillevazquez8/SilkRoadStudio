package com.projects.silkroadstudio.Product.Size;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController {
    private final SizeService sizeService;
}
