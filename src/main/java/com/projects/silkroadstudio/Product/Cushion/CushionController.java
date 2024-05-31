package com.projects.silkroadstudio.Product.Cushion;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cushion")
public class CushionController {

    private final CushionService cushionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cushion createCushion(@RequestBody Cushion cushion) {
        return cushionService.save(cushion);
    }
}
