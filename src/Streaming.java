import java.util.ArrayList;

public class Streaming {
    private ArrayList<Movie> movies;
    private ArrayList<Series> series;


    public Streaming(ArrayList<Movie> movies, ArrayList<Series> series) {
        this.movies = movies;
        this.series = series;
    }

    // Find and return a movie by title
    public Movie getMovie(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    // Find and return a specific episode from a series
    public Episode findEpisode(String title, int seasonNumber, int episodeNumber) {
        for (Series s : series) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                return s.getEpisode(seasonNumber, episodeNumber);
            }
        }
        return null;
    }

    // Calculate total number of episodes in a series
    public int totalEpisodes(String seriesTitle) {
        for (Series s : series) {
            if (s.getTitle().equalsIgnoreCase(seriesTitle)) {
                int total = 0;
                for (Season season : s.getSeasons()) {
                    total += season.getAllEpisodes().size();
                }
                return total;
            }
        }
        return 0;
    }



    public ArrayList<Movie> getAllMovies() {
        return movies;
    }

    public ArrayList<Series> getAllSeries() {
        return series;
    }
}
