package com.example.wanted.company;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
@Slf4j
public class CompanyController {
	private final CompanyServiceImpl companyService;

	@PostMapping("")
	public ResponseEntity<?> addCompany(@RequestBody AddCompanyDto addCompanyDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			companyService.addCompany(addCompanyDto);
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("회사 등록 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}
}
