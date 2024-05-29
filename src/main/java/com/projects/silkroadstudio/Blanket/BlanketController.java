package com.projects.silkroadstudio.Blanket;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blanket")
public class BlanketController {
    private final BlanketService blanketService;
}
