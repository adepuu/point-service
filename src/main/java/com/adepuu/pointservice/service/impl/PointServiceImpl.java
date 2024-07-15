package com.adepuu.pointservice.service.impl;

import com.adepuu.pointservice.entity.Point;
import com.adepuu.pointservice.entity.User;
import com.adepuu.pointservice.repo.PointRepository;
import com.adepuu.pointservice.repo.UserRepository;
import com.adepuu.pointservice.service.PointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final UserRepository userRepository;

    public PointServiceImpl(PointRepository pointRepository, UserRepository userRepository) {
        this.pointRepository = pointRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void checkAndUpdateExpiredPoints() {
        OffsetDateTime now = OffsetDateTime.now();
        List<Point> expiredPoints = pointRepository.findAllByExpiredAtBeforeAndRemainingGreaterThanAndIsDeductedIsFalse(now, BigDecimal.ZERO);
        for (Point point : expiredPoints) {
            User user = point.getUser();
            BigDecimal expiredAmount = point.getRemaining();
            user.setPoints(user.getPoints().subtract(expiredAmount));
            point.setIsDeducted(true);
            pointRepository.save(point);
            userRepository.save(user);
        }
    }
}
