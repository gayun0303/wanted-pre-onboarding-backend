package com.example.wanted.jobposting;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JobPostingUpdateDto {
	private String position;
	private int reward;
	private String content;
	private String techStack;
}
