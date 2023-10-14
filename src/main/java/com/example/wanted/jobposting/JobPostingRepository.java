package com.example.wanted.jobposting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {
	void deleteByJobPostingId(Long jobPostingId);

	@Query(value = "SELECT jp.job_posting_id AS jobPostingId, c.company_name AS companyName, c.country, c.region, jp.position, jp.reward, jp.tech_stack AS techStack "
		+ "FROM job_posting AS jp, company AS c;", nativeQuery = true)
	List<JobPostingSummaryDto> findAllJobPosting();

	@Query(value = "SELECT jp.job_posting_id AS jobPostingId, c.company_name AS companyName, c.country, c.region, jp.position, jp.reward, jp.tech_stack as techStack "
		+ "FROM job_posting AS jp, company AS c "
		+ "WHERE company_name LIKE %:searchKeyword% OR country LIKE %:searchKeyword% OR region LIKE %:searchKeyword% OR position LIKE %:searchKeyword% OR reward LIKE %:searchKeyword% OR tech_stack LIKE %:searchKeyword%"
		, nativeQuery = true)
	List<JobPostingSummaryDto> searchJobPosting(String searchKeyword);

	@Query(value = "SELECT job_posting_id FROM job_posting WHERE NOT job_posting_id = :jobPostingId AND company_id = :companyId", nativeQuery = true)
	List<Integer> findJobPostingIdByCompany_Id(Long jobPostingId, Long companyId);
}
