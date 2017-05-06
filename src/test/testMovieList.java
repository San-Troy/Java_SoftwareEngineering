package test;

import java.util.ArrayList;
import Classes.Movie;
import util.csvReader_util;

public class testMovieList {
	
	public static void main(String[] args) {
		ArrayList<Movie> list = new csvReader_util().loadMovieFile("files/movies.csv");
		System.out.println(list.get(3).getName());
	}
	
}
