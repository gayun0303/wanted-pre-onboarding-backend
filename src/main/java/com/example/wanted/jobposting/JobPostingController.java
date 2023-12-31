package com.example.wanted.jobposting;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("")
	public ResponseEntity<?> getJobPostingList() {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("result", jobPostingService.getJobPostingList());
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 가져오기 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchJobPostingList(@RequestParam("keyword") String searchKeyword) {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("result", jobPostingService.searchJobPostingList(searchKeyword));
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 검색 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/{jobPostingId}")
	public ResponseEntity<?> getJobPosting(@PathVariable Long jobPostingId) {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("result", jobPostingService.getJobPosting(jobPostingId));
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 상세 조회 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}
}
