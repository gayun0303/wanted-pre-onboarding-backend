package com.example.wanted.apply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.wanted.jobposting.JobPostingEntity;
import com.example.wanted.user.UserEntity;

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
@Entity(name = "apply")
public class ApplyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apply_id")
	private Long applyId;

	@ManyToOne
	@JoinColumn(name = "job_posting_id")
	private JobPostingEntity jobPostingEntity;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
}
