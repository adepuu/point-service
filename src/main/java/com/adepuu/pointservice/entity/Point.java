package com.adepuu.pointservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "points_id_gen")
    @SequenceGenerator(name = "points_id_gen", sequenceName = "points_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ColumnDefault("0.0")
    @Column(name = "points", precision = 10, scale = 2)
    private BigDecimal points;

    @ColumnDefault("0.0")
    @Column(name = "remaining", precision = 10, scale = 2)
    private BigDecimal remaining;

    @ColumnDefault("false")
    @Column(name = "is_deducted")
    private Boolean isDeducted;

    @Column(name = "expired_at")
    private OffsetDateTime expiredAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}