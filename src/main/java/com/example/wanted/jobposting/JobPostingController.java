package com.example.wanted.jobposting;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job-posting")
@Slf4j
public class JobPostingController {
	private final JobPostingServiceImpl jobPostingService;

	@PostMapping("")
	public ResponseEntity<?> addJobPosting(@RequestBody JobPostingDto jobPostingDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			jobPostingService.addJobPosting(jobPostingDto);
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 등록 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}

	@PutMapping("/{jobPostingId}")
	public ResponseEntity<?> updateJobPosting(@PathVariable Long jobPostingId, @RequestBody JobPostingUpdateDto jobPostingUpdateDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			jobPostingService.updateJobPosting(jobPostingUpdateDto, jobPostingId);
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 수정 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping("/{jobPostingId}")
	public ResponseEntity<?> deleteJobPosting(@PathVariable Long jobPostingId) {
		Map<String, Object> result = new HashMap<>();
		try {
			jobPostingService.deleteJobPosting(jobPostingId);
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 삭제 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}
}
