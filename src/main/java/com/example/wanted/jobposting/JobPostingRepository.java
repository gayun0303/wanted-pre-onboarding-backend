package com.example.wanted.jobposting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {
	void deleteByJobPostingId(Long jobPostingId);
}
