
package com.moviecatalog.business;

public interface IMovieCatalog {
    public void addMovie(String movieName, String fileName);
    public void listMovies(String fileName);
    public void searchMovie(String fileName, String search);
    public void initFile(String fileName);
}
