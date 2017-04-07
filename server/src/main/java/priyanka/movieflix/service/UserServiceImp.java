package priyanka.movieflix.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priyanka.movieflix.entity.User;
import priyanka.movieflix.repository.UserRepositoryImp;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepositoryImp repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User user = repository.findOne(id);
		return user;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing == null){
			repository.create(user);
		}
		return user;
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing != null){
			repository.update(user);
		}
		return user;
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		repository.delete(existing);

	}

}
