package com.fse.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.model.dao.User;
import com.fse.model.dto.RegistrationDTO;
import com.fse.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void save(RegistrationDTO registrationDto) {

		User user = modelMapper.map(registrationDto, User.class);
		userRepository.save(user);
	}

}
