package com.adepuu.pointservice.scheduled;

import com.adepuu.pointservice.service.PointService;
import org.springframework.scheduling.annotation.Scheduled;

public class ExpiredPoints {
    private final PointService pointService;

    public ExpiredPoints(PointService pointService) {
        this.pointService = pointService;
    }

    @Scheduled(cron = "0 0 23 * * *")
    public void checkAndUpdateExpiredPoints() {
        pointService.checkAndUpdateExpiredPoints();
    }
}
