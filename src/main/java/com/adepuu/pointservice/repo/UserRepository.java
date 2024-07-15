package com.adepuu.pointservice.repo;

import com.adepuu.pointservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
