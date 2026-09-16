
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domein.Movie;
import domein.YearComparator;

public class ComparableApp {

	public void startSortMovies() {
		List<Movie> allMovies = new ArrayList<Movie>();
		allMovies.add(new Movie("Force Awakens", 8.3, 2015));
		allMovies.add(new Movie("Force Awakens", 8.3, 2010));
		allMovies.add(new Movie("Force Awakens", 8.3, 2000));
		allMovies.add(new Movie("Star Wars", 8.7, 1977));
		allMovies.add(new Movie("Empire Strikes Back", 8.8, 1980));
		allMovies.add(new Movie("Return of the Jedi", 8.4, 1983));
		allMovies.add(new Movie("Return of the Jedi", 8.4, 1999));
		allMovies.add(new Movie("Return of the Jedi", 8.4, 2015));

		allMovies.sort(null);
		showMovies("Movies with natural ordering (name - year)", allMovies);
		allMovies.sort(new YearComparator());
		showMovies("Movies with total ordering based on year", allMovies);
		
//		Versie uit H02 met RatingComparator:
//		allMovies.sort(new RatingComparator());
		
// 		Oef 1, met anonieme inner class:
/**
		allMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                return Double.compare(movie2.getRating(), movie1.getRating());
                // Alternatief: return -Double.compare(movie1.getRating(), movie2.getRating());
            }
        });
		showMovies("Movies with total ordering based on descending rating", allMovies);
**/
		
// 		Oef 2, met lambdas:
/**
		allMovies.sort((movie1, movie2) ->
                -Double.compare(movie1.getRating(), movie2.getRating()));
		showMovies("Movies with total ordering based on descending rating", allMovies);
		
		allMovies.sort((movie1, movie2) ->
                movie1.getName().compareTo(movie2.getName()));
		showMovies("Movies with ordering based on name", allMovies);
**/
		
//		Oef 3, met methodereferenties:
		allMovies.sort(Movie::compareRating);
		showMovies("Movies with total ordering based on descending rating", allMovies);
		
		allMovies.sort(Comparator.comparing(Movie::getName));
		showMovies("Movies with ordering based on name", allMovies);
		
		allMovies.sort(Comparator.comparing(Movie::getRating).reversed());
		showMovies("Movies with total ordering based on descending rating", allMovies);
	}

	private void showMovies(String titel, List<Movie> allMovies) {
		System.out.printf("%s%n", titel);
		System.out.printf("%s%n", "=".repeat(titel.length()));
		for (Movie movie : allMovies) {
			System.out.println(movie);
		}
		System.out.println();
	}
}
