package com.twu.biblioteca;

import com.twu.biblioteca.Service.LibraryService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LibraryServiceTest_2 {
    @Test
    public void should_return_all_available_movies_with_name_year_director_rating_when_call_listMovies_method(){
        LibraryService libraryService = new LibraryService();
        assertEquals("Titanic", libraryService.listMovies().get(0).getMovieName());
        assertEquals("1997", libraryService.listMovies().get(0).getMovieYear());
        assertEquals("wangxue", libraryService.listMovies().get(0).getMovieDirector());
        assertEquals(9, libraryService.listMovies().get(0).getMovieRating());
        assertEquals("Movie2", libraryService.listMovies().get(1).getMovieName());
        assertEquals("1990", libraryService.listMovies().get(1).getMovieYear());
        assertEquals("xuewang", libraryService.listMovies().get(1).getMovieDirector());
        assertEquals(8, libraryService.listMovies().get(1).getMovieRating());
    }

}
