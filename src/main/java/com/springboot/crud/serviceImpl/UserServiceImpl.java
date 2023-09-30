package com.springboot.crud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.crud.entity.User;
import com.springboot.crud.repo.UserRepository;
import com.springboot.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {

		return repository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> optional = repository.findById(userId);
		return optional.get();
	}

	@Override
	public List<User> getAllUsers() {
		
		return repository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = repository.save(existingUser);
        return updatedUser;
		
	}

	@Override
	public void deleteUser(Long userId) {
		repository.deleteById(userId);

	}

}
