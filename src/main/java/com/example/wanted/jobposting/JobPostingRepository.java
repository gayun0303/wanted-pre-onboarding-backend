package com.example.wanted.jobposting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {
	void deleteByJobPostingId(Long jobPostingId);

	@Query(value = "SELECT jp.job_posting_id AS jobPostingId, c.company_name AS companyName, c.country, c.region, jp.position, jp.reward, jp.tech_stack AS techStack "
		+ "FROM job_posting AS jp, company AS c;", nativeQuery = true)
	List<JobPostingSummaryDto> findAllJobPosting();
}
