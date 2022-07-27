package com.moviestore;

import com.moviecatalog.business.IMovieCatalog;
import com.moviecatalog.business.MovieCatalog;
import java.io.*;

public class MovieStore {

    static String fileName = "pelis.txt";
    static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    static IMovieCatalog mc;

    public static void main(String[] args) throws IOException {
        int optionSelected = -1;
        do {
            showMenu();
            optionSelected = Integer.parseInt(console.readLine());
            switch (optionSelected) {
                case 0:
                    break;

                case 1:
                    mc = new MovieCatalog();
                    mc.initFile(fileName);
                    break;

                case 2:
                    mc = new MovieCatalog();
                    addMovie();
                    break;

                case 3:
                    mc = new MovieCatalog();
                    System.out.println("Catalogo: \n");
                    mc.listMovies(fileName);
                    break;

                case 4:
                    searchMovie();
                    break;

                default:
                    break;
            }
        } while (optionSelected != 0);
    }

    static void showMenu() {
        System.out.println("============================================");
        System.out.println("============ Menu de opciones ==============");
        System.out.println("1 - Iniciar Catalogo peliculas");
        System.out.println("2 - Agregar Peliculas");
        System.out.println("3 - Listar Peliculas");
        System.out.println("4 - Buscar Peliculas");
        System.out.println("0 - Salir del programa");
        System.out.println("============================================");
    }

    static void addMovie() throws IOException {
        String option = "";
        mc = new MovieCatalog();
        do {
            System.out.println("Introduzca el nombre de la pelicula:");
            mc.addMovie(console.readLine(), fileName);
            System.out.println("Agregamos otra pelicula? Si / No:");
            option = console.readLine();
        } while (!option.equals("No"));
    }

    static void searchMovie() throws IOException {
        String option = "";
        String search = "";
        mc = new MovieCatalog();
        do {
            System.out.println("Introduzca el nombre de la pelicula a buscar:");
            search = console.readLine();
            mc.searchMovie(fileName, search);
            System.out.println("Buscamos otra pelicula? Si / No:");
            option = console.readLine();
        } while (!option.equals("No"));
    }
}
