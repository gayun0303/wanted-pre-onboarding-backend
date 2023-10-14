package com.example.wanted.jobposting;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JobPostingDto {
	private Long jobPostingId;
	private Long companyId;
	private String position;
	private int reward;
	private String content;
	private String techStack;
}
