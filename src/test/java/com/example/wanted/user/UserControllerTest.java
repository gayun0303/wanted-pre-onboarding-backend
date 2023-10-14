package com.example.wanted.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class UserControllerTest{

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("POST: 사용자 생성 테스트")
	void addUser() throws Exception {
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("userName", "테스트이름");

		String content = new ObjectMapper().writeValueAsString(requestMap);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(content);

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}
}