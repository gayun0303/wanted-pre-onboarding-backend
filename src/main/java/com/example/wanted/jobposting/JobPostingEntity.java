package com.example.wanted.jobposting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.wanted.company.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "job_posting")
public class JobPostingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_posting_id")
	private Long jobPostingId;

	private String position;

	private int reward;

	@Column(name = "tech_stack")
	private String techStack;

	private String content;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;

}
