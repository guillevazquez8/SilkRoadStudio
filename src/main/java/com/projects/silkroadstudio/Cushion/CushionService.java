package com.projects.silkroadstudio.Cushion;

import com.projects.silkroadstudio.Carpet.CarpetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CushionService {
    private final CushionRepository cushionRepository;
}
