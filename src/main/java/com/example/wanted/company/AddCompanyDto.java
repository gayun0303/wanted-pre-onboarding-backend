package com.example.wanted.company;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddCompanyDto {
	private String companyName;
	private String country;
	private String region;
}
