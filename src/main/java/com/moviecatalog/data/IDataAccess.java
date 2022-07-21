
package com.moviecatalog.data;

import com.moviecatalog.domain.Movie;
import java.util.List;

public interface IDataAccess {
    public boolean exist(String fileName);
    public List<Movie> list(String name);
    public void write(Movie movie, String fileName, boolean append);
    public String search(String fileName, String search);
    public void create(String fileName);
    public void delete(String fileName);
}
