package com.example.wanted.jobposting;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.wanted.company.CompanyEntity;
import com.example.wanted.company.CompanyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
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

	@Override
	public JobPostingEntity updateJobPosting(JobPostingUpdateDto jobPostingUpdateDto, Long jobPostingId) throws Exception {
		JobPostingEntity jobPostingEntity = jobPostingRepository.findById(jobPostingId).orElseThrow(()->new Exception("수정하려는 채용 공고 정보를 찾을 수 없습니다."));

		jobPostingEntity.setPosition(jobPostingUpdateDto.getPosition());
		jobPostingEntity.setReward(jobPostingUpdateDto.getReward());
		jobPostingEntity.setContent(jobPostingUpdateDto.getContent());
		jobPostingEntity.setTechStack(jobPostingUpdateDto.getTechStack());

		return jobPostingRepository.save(jobPostingEntity);
	}

	@Override
	public void deleteJobPosting(Long jobPostingId) throws Exception {
		jobPostingRepository.deleteByJobPostingId(jobPostingId);
	}

	@Override
	public List<JobPostingDto> getJobPostingList() throws Exception {
		return jobPostingRepository.findAllJobPosting();
	}
}
