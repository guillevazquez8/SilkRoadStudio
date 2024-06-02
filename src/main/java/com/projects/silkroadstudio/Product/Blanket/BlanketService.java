package com.projects.silkroadstudio.Product.Blanket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BlanketService {

    private final BlanketRepository blanketRepository;

    public Blanket save(Blanket blanket) {
        return blanketRepository.save(blanket);
    }

}
