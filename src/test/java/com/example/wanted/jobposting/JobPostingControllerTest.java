package com.example.wanted.jobposting;

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
class JobPostingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("POST: 채용 공고 생성")
	void addJobPosting() throws Exception {
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("companyId", 1);
		requestMap.put("position", "백엔드 주니어 개발자");
		requestMap.put("reward", 1000000);
		requestMap.put("content", "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은...");
		requestMap.put("techStack", "Java");

		String content = new ObjectMapper().writeValueAsString(requestMap);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/job-posting")
			.contentType(MediaType.APPLICATION_JSON)
			.content(content);

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());

	}

	@Test
	@DisplayName("PUT: 채용 공고 수정")
	void updateJobPosting() throws Exception {
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("position", "백엔드 주니어 개발자");
		requestMap.put("reward", 1500000);
		requestMap.put("content", "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은...");
		requestMap.put("techStack", "Java");

		String content = new ObjectMapper().writeValueAsString(requestMap);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.put("/job-posting/2")
			.contentType(MediaType.APPLICATION_JSON)
			.content(content);

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}

	@Test
	@DisplayName("DELETE: 채용 공고 삭제")
	void deleteJobPosting() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.delete("/job-posting/1");

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}

	@Test
	@DisplayName("GET: 채용 공고 전체 리스트 조회")
	void getJobPostingList() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.get("/job-posting");

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}

	@Test
	@DisplayName("GET: 채용 공고 검색")
	void searchJobPostingList() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.get("/job-posting/search")
			.param("keyword", "원티드");

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}

	@Test
	@DisplayName("GET: 채용 공고 상세 조회")
	void getJobPosting() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
			.get("/job-posting/3");

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("state").value("SUCCESS"))
			.andDo(print());
	}
}