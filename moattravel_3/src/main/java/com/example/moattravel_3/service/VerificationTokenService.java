package com.example.moattravel_3.service;

import org.springframework.stereotype.Service;

import com.example.moattravel_3.entity.User;
import com.example.moattravel_3.entity.VerificationToken;
import com.example.moattravel_3.repository.VerificationTokenRepository;

import jakarta.transaction.Transactional;

@Service
public class VerificationTokenService {
	private final VerificationTokenRepository verificationTokenRepository;

	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
		this.verificationTokenRepository = verificationTokenRepository;
	}

	@Transactional
	public void create(User user, String token) {
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setUser(user);
		verificationToken.setToken(token);
		verificationTokenRepository.save(verificationToken);
	}

	public VerificationToken getVerifivationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
}
