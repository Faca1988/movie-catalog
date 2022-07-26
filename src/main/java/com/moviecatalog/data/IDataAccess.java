
package com.moviecatalog.data;

import com.moviecatalog.domain.Movie;
import com.moviecatalog.exception.*;
import java.util.List;

public interface IDataAccess{
    public abstract boolean exist(String fileName) throws DataAccessException;
    public abstract List<Movie> list(String name) throws ReadDataException;
    public abstract void write(Movie movie, String fileName, boolean append) throws WriteDataException;
    public abstract String search(String fileName, String search) throws ReadDataException;
    public abstract void create(String fileName) throws DataAccessException;
    public abstract void delete(String fileName) throws DataAccessException;
}
