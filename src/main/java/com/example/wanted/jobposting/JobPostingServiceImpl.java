package com.example.wanted.jobposting;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.wanted.company.CompanyEntity;
import com.example.wanted.company.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class JobPostingServiceImpl implements JobPostingService {
	private final JobPostingRepository jobPostingRepository;
	private final CompanyRepository companyRepository;

	@Override
	public void addJobPosting(JobPostingDto jobPostingDto) throws Exception {
		CompanyEntity company = companyRepository.findById(jobPostingDto.getCompanyId()).orElseThrow(()->new Exception("회사 정보를 찾을 수 없습니다."));
		JobPostingEntity jobPostingEntity = JobPostingEntity.builder()
			.company(company)
			.position(jobPostingDto.getPosition())
			.reward(jobPostingDto.getReward())
			.content(jobPostingDto.getContent())
			.techStack(jobPostingDto.getTechStack())
			.build();
		jobPostingRepository.save(jobPostingEntity);
	}
}
