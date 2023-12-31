package com.example.wanted.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findById(Long userId);
}
