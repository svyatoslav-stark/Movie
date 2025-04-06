import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {

    @Test
    public void testUserLimit() {
        MovieManager manager = new MovieManager(1);
        assertEquals(1, manager.getLimit());
    }

    @Test
    public void testUserLimitZero() {
        MovieManager manager = new MovieManager(0);
        assertEquals(0, manager.getLimit());
    }

    @Test
    public void testUserLimitNegative() {
        MovieManager manager = new MovieManager(-1);
        assertEquals(0, manager.getLimit());
    }

    @Test
    void shouldAddOneMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");

        String[] expected = {"Movie 1"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldAddMultipleMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnAllMoviesWhenFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnLastMoviesWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnLastMoviesWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");

        String[] expected = {"Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnAllMoviesIfLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        String[] expected = {"Movie 2", "Movie 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnEmptyArrayIfNoMoviesAdded() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
        assertArrayEquals(expected, manager.findLast());
    }
}
