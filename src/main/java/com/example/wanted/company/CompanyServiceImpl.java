package com.example.wanted.company;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService{
	private final CompanyRepository companyRepository;

	@Override
	public void addCompany(AddCompanyDto addCompanyDto) throws Exception {
		if(addCompanyDto.getCompanyName().isBlank() || addCompanyDto.getRegion().isBlank() || addCompanyDto.getCountry().isBlank()) {
			throw new Exception("회사 정보에 비어 있는 항목이 있습니다.");
		}
		if(companyRepository.existsByCompanyName(addCompanyDto.getCompanyName())) {
			throw new Exception("이미 존재하는 회사입니다.");
		}

		CompanyEntity company = CompanyEntity.builder()
			.companyName(addCompanyDto.getCompanyName())
			.country(addCompanyDto.getCountry())
			.region(addCompanyDto.getRegion())
			.build();

		companyRepository.save(company);
	}
}
