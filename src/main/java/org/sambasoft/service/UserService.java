package org.sambasoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sambasoft.entities.User;
import org.sambasoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
 
}
