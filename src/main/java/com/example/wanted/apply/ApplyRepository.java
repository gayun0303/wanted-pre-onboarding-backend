package com.example.wanted.apply;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted.jobposting.JobPostingEntity;
import com.example.wanted.user.UserEntity;

public interface ApplyRepository extends JpaRepository<ApplyEntity, Long> {
	Boolean existsByUserEntity_IdAndJobPostingEntity_JobPostingId (Long userId, Long jobPostingId);
}
