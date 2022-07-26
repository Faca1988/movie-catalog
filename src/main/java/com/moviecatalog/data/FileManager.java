package com.moviecatalog.data;

import com.moviecatalog.domain.Movie;
import com.moviecatalog.exception.*;
import java.io.*;
import java.util.*;

public class FileManager implements IDataAccess {

    @Override
    public boolean exist(String fileName) throws DataAccessException {
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Movie> list(String fileName) throws ReadDataException {
        List<Movie> list = new ArrayList<>();
        try {
            if (exist(fileName)) {
                try {
                    var br = new BufferedReader(new FileReader(fileName));
                    String name = br.readLine();
                    while (name != null) {
                        var movie = new Movie(name);
                        list.add(movie);
                        name = br.readLine();
                    }
                    br.close();
                } catch (FileNotFoundException ex) {
                    throw new ReadDataException(ex.getMessage());
                } catch (IOException ex) {
                    throw new ReadDataException(ex.getMessage());
                }
            }
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void write(Movie movie, String fileName, boolean append) throws WriteDataException {
        try {
            if (exist(fileName)) {
                try {
                    var writer = new BufferedWriter(new FileWriter(fileName, append));
                    writer.write(movie.getName());
                    writer.close();
                } catch (IOException ex) {
                    throw new WriteDataException(ex.getMessage());
                }
            }else{
                this.create(fileName);
                this.write(movie, fileName, append);
            }
        } catch (DataAccessException ex) {
            throw new WriteDataException(ex.getMessage());
        }
    }

    @Override
    public String search(String fileName, String search) throws ReadDataException {
        String foundedSearch = "";
        try {
            if (exist(fileName)) {
                var br = new BufferedReader(new FileReader(fileName));
                String name = br.readLine();
                while (name != null) {
                    if (name.contains(search)) {
                        foundedSearch = name;
                        br.close();
                        break;
                    } else {
                        name = br.readLine();
                    }
                }
            } else {
                System.out.println("The file " + fileName + " doesn't exist.");
            }
        } catch (DataAccessException ex) {
            throw new ReadDataException(ex.getMessage());
        } catch (IOException ex) {
            throw new ReadDataException(ex.getMessage());
        }
        return foundedSearch;
    }

    @Override
    public void create(String fileName) throws DataAccessException {
        try {
            if (this.exist(fileName)) {
                System.out.println("The specified file already exist.");
            } else {
                var file = new File(fileName);
                try {
                    var output = new PrintWriter(file);
                    output.close();
                    System.out.println("File " + fileName + " was created successfully");
                } catch (FileNotFoundException e) {
                    throw new DataAccessException(e.getMessage());
                }
            }
        } catch (DataAccessException ex) {
            ex.getMessage();
        }
    }

    @Override
    public void delete(String fileName) throws DataAccessException {
        if (!this.exist(fileName)) {
            System.out.println("Is not possible delete the file because the file doesn't exist.");
        } else {
            File file = new File(fileName);
            file.delete();
            System.out.println("File " + fileName + " was deleted correctly");
        }
    }

}
