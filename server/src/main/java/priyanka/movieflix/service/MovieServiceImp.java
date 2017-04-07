package priyanka.movieflix.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priyanka.movieflix.entity.Movie;
import priyanka.movieflix.repository.MovieRepositoryImp;

@Service
public class MovieServiceImp implements MovieService{
	
	@Autowired
	MovieRepositoryImp repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie movie = repository.findOne(id);
		return movie;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		repository.create(movie);
		return movie;
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findOne(id);
		if(existing != null){
			repository.update(movie);
		}
		return movie;
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		repository.delete(existing);

	}

}
