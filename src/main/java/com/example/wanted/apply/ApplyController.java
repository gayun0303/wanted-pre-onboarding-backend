package com.example.wanted.apply;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wanted.jobposting.JobPostingDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apply")
@Slf4j
public class ApplyController {
	private final ApplyServiceImpl applyService;

	@PostMapping("")
	public ResponseEntity<?> apply(@RequestBody Map<String, Long> map) {
		Map<String, Object> result = new HashMap<>();
		try {
			applyService.apply(map.get("userId"), map.get("jobPostingId"));
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("채용 공고 지원 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}
}
