package priyanka.movieflix.repository;

import java.util.List;

import priyanka.movieflix.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie user);
	public Movie update(Movie user);
	public void delete(Movie user);

}
