package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    AfishaManager manager = new AfishaManager();
    private Movie first = new Movie(1, 1, "movie1", "genre1", "image1");
    private Movie second = new Movie(2, 2, "movie2", "genre2", "image2");
    private Movie third = new Movie(3, 3, "movie3", "genre3", "image3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4", "image4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5", "image5");
    private Movie sixth= new Movie(6, 6, "movie6", "genre6", "image6");
    private Movie seventh = new Movie(7, 7, "movie7", "genre7", "image7");
    private Movie eight = new Movie(8, 8, "movie8", "genre8", "image8");
    private Movie ninth = new Movie(9, 9, "movie9", "genre9", "image9");
    private Movie tenth = new Movie(10, 10, "movie10", "genre10", "image10");

    @Test
    public void showsDefaultMoviesCount() {
        manager = new AfishaManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showsFiveAddedMovies() {
        manager = new AfishaManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showsThreeMoviesWithFiveAdded() {
        manager = new AfishaManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showsReversedMoviesSequence() {
        manager = new AfishaManager();
        manager.add(second);
        manager.add(first);
        manager.add(fifth);
        manager.add(third);
        manager.add(fourth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eight);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{eight, tenth, ninth, seventh, sixth, fourth, third, fifth, first, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showsAllWhenNotEnough(){
        manager = new AfishaManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {
        manager = new AfishaManager(1);
        manager.add(first);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotExist(){
        manager = new AfishaManager();
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNegative() {
        manager = new AfishaManager(-1);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }
}
