package com.projects.silkroadstudio.Product.Carpet;

import com.projects.silkroadstudio.Product.Cushion.Cushion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carpet")
public class CarpetController {

    private final CarpetService carpetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carpet createCarpet(@RequestBody Carpet carpet) {
        return carpetService.save(carpet);
    }

}
