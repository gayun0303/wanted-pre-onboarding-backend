package com.example.wanted.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public void addUser(String userName) throws Exception {
		UserEntity user = UserEntity.builder()
			.name(userName)
			.build();
		userRepository.save(user);
	}
}
