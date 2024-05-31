package com.projects.silkroadstudio.Product.Cushion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CushionService {

    private final CushionRepository cushionRepository;

    public Cushion save(Cushion cushion) {
        return cushionRepository.save(cushion);
    }
}
