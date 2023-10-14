package com.example.wanted.apply;

import javax.transaction.Transactional;

import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import com.example.wanted.jobposting.JobPostingEntity;
import com.example.wanted.jobposting.JobPostingRepository;
import com.example.wanted.jobposting.JobPostingServiceImpl;
import com.example.wanted.user.UserEntity;
import com.example.wanted.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ApplyServiceImpl implements ApplyService {
	private final ApplyRepository applyRepository;
	private final UserRepository userRepository;
	private final JobPostingRepository jobPostingRepository;

	@Override
	public void apply(Long userId, Long jobPostingId) throws Exception {
		UserEntity userEntity = userRepository.findById(userId).orElseThrow(()->new Exception("사용자 정보를 찾을 수 없습니다."));
		JobPostingEntity jobPostingEntity = jobPostingRepository.findById(jobPostingId).orElseThrow(()->new Exception("채용 공고 정보를 찾을 수 없습니다."));

		if(applyRepository.existsByUserEntity_IdAndJobPostingEntity_JobPostingId(userEntity.getId(), jobPostingEntity.getJobPostingId())) {
			throw new Exception("이미 지원한 항목입니다.");
		}

		ApplyEntity applyEntity = ApplyEntity.builder()
			.userEntity(userEntity)
			.jobPostingEntity(jobPostingEntity)
			.build();

		applyRepository.save(applyEntity);
	}
}
