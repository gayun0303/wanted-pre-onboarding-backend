package com.example.wanted.company;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

	Optional<CompanyEntity> findById(Long companyId);

	Boolean existsByCompanyName(String companyName);

}
