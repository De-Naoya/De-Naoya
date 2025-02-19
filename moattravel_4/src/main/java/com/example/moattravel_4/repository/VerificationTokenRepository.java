package com.example.moattravel_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel_4.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	public VerificationToken findByToken(String token);
}
