package com.adepuu.pointservice.controller;

import com.adepuu.pointservice.service.PointService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/points")
public class PointController {
    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/invalidate-expired")
    public void invalidateExpiredPoints() {
        pointService.checkAndUpdateExpiredPoints();
    }
}
