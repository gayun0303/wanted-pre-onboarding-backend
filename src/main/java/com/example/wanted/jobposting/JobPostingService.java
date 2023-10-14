package com.example.wanted.jobposting;

import java.util.List;

public interface JobPostingService {
	void addJobPosting(JobPostingDto jobPostingDto) throws Exception;

	JobPostingEntity updateJobPosting(JobPostingUpdateDto jobPostingUpdateDto, Long jobPostingId) throws Exception;
	void deleteJobPosting(Long jobPostingId) throws Exception;

	List<JobPostingSummaryDto> getJobPostingList() throws Exception;
}
