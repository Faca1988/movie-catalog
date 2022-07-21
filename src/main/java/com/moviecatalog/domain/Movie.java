
package com.moviecatalog.domain;

public class Movie {
    private String movieName;
    
    public Movie(){}
    
    public Movie(String name){
        this.movieName = name;
    }
    
    public String getName(){ return this.movieName; }
    public void setName(String name){ this.movieName = name; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie{");
        sb.append("movieName: ").append(movieName);
        sb.append("}");
        return sb.toString();
    }
    
    
    
}
