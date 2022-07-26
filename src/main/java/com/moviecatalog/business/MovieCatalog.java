package com.moviecatalog.business;

import com.moviecatalog.data.*;
import com.moviecatalog.domain.Movie;
import com.moviecatalog.exception.*;
import java.util.List;
import java.util.logging.*;

public class MovieCatalog implements IMovieCatalog {

    IDataAccess data;

    public MovieCatalog() {
    }

    @Override
    public void initFile(String fileName) {
        this.data = new FileManager();
        try {
            this.data.create(fileName);
        } catch (WriteDataException ex) {
            ex.getMessage();
        } catch (DataAccessException ex) {
            ex.getMessage();
        }
    }

    @Override
    public void addMovie(String movieName, String fileName) {
        try {
            Movie movie = new Movie(movieName);
            this.data = new FileManager();
            this.data.create(fileName);
            this.data.write(movie, fileName, true);
        } catch (WriteDataException ex) {
            ex.getMessage();
        } catch (DataAccessException ex) {
            ex.getMessage();
        }
    }

    @Override
    public void listMovies(String fileName) {
        try {
            data = new FileManager();
            List<Movie> movieList = this.data.list(fileName);
//        for(Movie movie: movieList)
//            System.out.println(movie);
            movieList.forEach(movie -> {
                System.out.println(movie);
            });
        } catch (ReadDataException ex) {
           ex.getMessage();
        }
    }

    @Override
    public void searchMovie(String fileName, String search) {
        try {
            this.data = new FileManager();
            this.data.search(fileName, search);
        } catch (DataAccessException ex) {
            ex.getMessage();
        }
    }

}
