package com.projects.silkroadstudio.Product.Blanket;

import com.projects.silkroadstudio.Product.Carpet.Carpet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blanket")
public class BlanketController {

    private final BlanketService blanketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blanket createBlanket(@RequestBody Blanket blanket) {
        return blanketService.save(blanket);
    }

}
