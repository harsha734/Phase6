package com.foodbox.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.mts.repoImpl.QueryClass;
import com.foodbox.exception.FooditemNotFoundException;
import com.foodbox.pojo.Fooditms;
import com.foodbox.pojo.SnaksJuice;
import com.foodbox.repository.Fooditems;
import com.foodbox.repository.SnaksJuiceRepository;
import com.foodbox.repository.TheatreRepository;

import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Base64;

@Service
public class FooditemsServiceImpl implements FooditemsService {

	@Autowired
	private Fooditems moviesrepository;
	@Autowired
	TheatreRepository theatreRepository;
	@Autowired
	SnaksJuiceRepository showrepository;
	@Autowired
	QueryClass query;

	@Override
	public Fooditms addMovie(Fooditms movie) throws FooditemNotFoundException {
		if (movie != null) {
			if (moviesrepository.existsById(movie.getMovieId())) {
				throw new FooditemNotFoundException("Movie with this id already exists");
			} else {
				/*
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());
				if(fileName.contains(".."))
				{
					System.out.println("not a a valid file");
				}
				try {
					movie.setMovieImage(Base64.getEncoder().encodeToString(file.getBytes()));
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				moviesrepository.saveAndFlush(movie);
			}
		}
		return movie;
	}

	@Override
	public Fooditms removeMovie(int movieid) {
		Fooditms m = moviesrepository.findById(movieid).get();
		List<SnaksJuice> shows = showrepository.findAll();
		for (SnaksJuice show : shows) {
			if (show.getMovie()!=null && show.getMovie().getMovieId() == movieid) {
				show.setMovie(null);
			}
		}
		moviesrepository.delete(m);
		return m;
	}
	
	@Override
	public Fooditms updateMovie(Fooditms movie) {
		moviesrepository.saveAndFlush(movie);
		return moviesrepository.getOne(movie.getMovieId());
	}
	
	@Override
	public Fooditms addMovieToShow(Fooditms movie,Integer showId) {
		SnaksJuice show=new SnaksJuice();
		if (showId != null) {
			show = showrepository.getOne(showId);
			movie.setShow(show);
		}
		moviesrepository.saveAndFlush(movie);
		return moviesrepository.getOne(movie.getMovieId());
	}

	@Override
	public Fooditms viewMovie(int movieid) {
		return moviesrepository.findById(movieid).get();
	}

	@Override
	public List<Fooditms> viewMovieList() throws FooditemNotFoundException {
		List<Fooditms> ml = moviesrepository.findAll();
		//if (ml.size() == 0) throw new MovieNotFoundException("Movies dosen't exist");
		return ml;
	}

	@Override
	public List<Fooditms> viewMovieList(int theatreid) {
		List<Fooditms> movies = new ArrayList<>();
		List<SnaksJuice> shows = showrepository.findAll();
		Set<Integer> showIds = new HashSet<>();
		for (SnaksJuice s : shows) {
			if (s.getTheatre().getTheatreId() == theatreid) {
				showIds.add(s.getShowId());
			}
		}
		for (Integer id : showIds) {
			movies.add(showrepository.getOne(id).getMovie());
		}
		return movies;
	}

	@Override
	public List<Fooditms> viewMovieList(LocalDate date) {
		List<Fooditms> mvList = new ArrayList<>();
		for (Fooditms movie : moviesrepository.findAll()) {
			if (movie.getMovieDate() != null && movie.getMovieDate().isEqual(date)) {
				mvList.add(movie);
			}
		}
		return mvList;
	}


}
