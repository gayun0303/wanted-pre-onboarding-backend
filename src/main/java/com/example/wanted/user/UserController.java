package com.example.wanted.user;

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
@RequestMapping("/user")
@Slf4j
public class UserController {
	private final UserServiceImpl userService;

	@PostMapping("")
	public ResponseEntity<?> addUser(@RequestBody Map<String, String> map) {
		Map<String, Object> result = new HashMap<>();
		try {
			userService.addUser(map.get("userName"));
			result.put("state", "SUCCESS");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("사용자 등록 실패 {}", e.getMessage());
			result.put("state", "FAIL");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}
}
