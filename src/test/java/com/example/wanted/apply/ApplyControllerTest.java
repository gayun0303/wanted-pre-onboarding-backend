package com.example.wanted.apply;

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

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ApplyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("POST: 채용 지원 테스트")
	void apply() throws Exception{
		Map<String, Integer> requestMap = new HashMap<>();
		requestMap.put("userId", 2);
		requestMap.put("jobPostingId", 2);

		String content = new ObjectMapper().writeValueAsString(requestMap);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/apply")
			.contentType(MediaType.APPLICATION_JSON)
			.content(content);

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}
}