package com.example.wanted.company;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Long, CompanyEntity> {

	Optional<CompanyEntity> findById(Long companyId);
	
}
