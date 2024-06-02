package com.projects.silkroadstudio.Product.Carpet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarpetService {

    private final CarpetRepository carpetRepository;

    public Carpet save(Carpet carpet) {
        return carpetRepository.save(carpet);
    }

}
