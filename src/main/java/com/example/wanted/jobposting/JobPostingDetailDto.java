package com.example.wanted.jobposting;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDetailDto {
	private Long jobPostingId;
	private String companyName;
	private String country;
	private String region;
	private String position;
	private int reward;
	private String techStack;
	private String content;
	private List<Integer> otherJobPostingList;

	public static JobPostingDetailDto toDetailDto(JobPostingEntity entity) {
		return JobPostingDetailDto.builder()
			.jobPostingId(entity.getJobPostingId())
			.companyName(entity.getCompany().getCompanyName())
			.country(entity.getCompany().getCountry())
			.region(entity.getCompany().getRegion())
			.position(entity.getPosition())
			.reward(entity.getReward())
			.techStack(entity.getTechStack())
			.content(entity.getContent())
			.build();
	}
}
