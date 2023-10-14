package com.example.wanted.jobposting;

public interface JobPostingSummaryDto {
	Long getJobPostingId();
	String getCompanyName();
	String getCountry();
	String getRegion();
	String getPosition();
	int getReward();
	String getTechStack();
}
