package com.adepuu.pointservice.repo;

import com.adepuu.pointservice.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> findAllByExpiredAtBeforeAndRemainingGreaterThanAndIsDeductedIsFalse(OffsetDateTime expiredAt, BigDecimal remaining);
}
