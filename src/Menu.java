import java.util.ArrayList;

public class Menu {
    private UIText ui;
    private Streaming streaming;


    public Menu() {
        this.ui = new UIText();
        this.streaming = createTestData();
    }

    // data with movies and series
    private Streaming createTestData() {

        // STRANGER THINGS
        ArrayList<Episode> stSeason1Eps = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            stSeason1Eps.add(new Episode(i));
        }

        Season stSeason1 = new Season(stSeason1Eps);

        ArrayList<Episode> stSeason2Eps = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            stSeason2Eps.add(new Episode(i));
        }
        Season stSeason2 = new Season(stSeason2Eps);

        ArrayList<Season> stSeasons = new ArrayList<>();
        stSeasons.add(stSeason1);
        stSeasons.add(stSeason2);
        Series strangerThings = new Series("Stranger Things", "Millie Bobby Brown, Finn Wolfhard", stSeasons);



        // THE WALKING DEAD
        ArrayList<Episode> twdSeason1Eps = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            twdSeason1Eps.add(new Episode(i));
        }
        Season twdSeason1 = new Season(twdSeason1Eps);

        ArrayList<Episode> twdSeason2Eps = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            twdSeason2Eps.add(new Episode(i));
        }
        Season twdSeason2 = new Season(twdSeason2Eps);

        ArrayList<Season> twdSeasons = new ArrayList<>();
        twdSeasons.add(twdSeason1);
        twdSeasons.add(twdSeason2);
        Series theWalkingDead = new Series("The Walking Dead", "Andrew Lincoln, Norman Reedus", twdSeasons);



        // VIKINGS
        ArrayList<Episode> vSeason1Eps = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            vSeason1Eps.add(new Episode(i));
        }
        Season vSeason1 = new Season(vSeason1Eps);

        ArrayList<Episode> vSeason2Eps = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            vSeason2Eps.add(new Episode(i));
        }
        Season vSeason2 = new Season(vSeason2Eps);

        ArrayList<Season> vSeasons = new ArrayList<>();
        vSeasons.add(vSeason1);
        vSeasons.add(vSeason2);
        Series vikings = new Series("Vikings", "Travis Fimmel, Katheryn Winnick", vSeasons);



        // MOVIES
        Movie avengers = new Movie("Avengers Endgame", "Robert Downey Jr, Chris Evans", "Russo Brothers");
        Movie superman = new Movie("Superman", "Henry Cavill", "Zack Snyder");
        Movie spiderman = new Movie("Spiderman", "Tom Holland", "Jon Watts");

        // Adds all to streaming
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(avengers);
        movies.add(superman);
        movies.add(spiderman);

        ArrayList<Series> seriesList = new ArrayList<>();
        seriesList.add(strangerThings);
        seriesList.add(theWalkingDead);
        seriesList.add(vikings);

        return new Streaming(movies, seriesList);
    }

    // Starts the menu
    public void start() {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = ui.promptNumericInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    playMovie();
                    break;
                case 2:
                    playEpisode();
                    break;
                case 3:
                    showAllMovies();
                    break;
                case 4:
                    showAllSeries();
                    break;
                case 5:
                    showTotalEpisodes();
                    break;
                case 6:
                    ui.displayMsg("Goodbye!");
                    running = false;
                    break;
                default:
                    ui.displayError("Invalid choice! Please choose 1-6.");
            }
            System.out.println();
        }
    }

    // Show menu options
    private void showMenu() {
        ui.displayMsg("=== STREAMING MENU ===");
        ui.displayMsg("1. Play a movie");
        ui.displayMsg("2. Play an episode");
        ui.displayMsg("3. Show all movies");
        ui.displayMsg("4. Show all series");
        ui.displayMsg("5. Show total episodes in a series");
        ui.displayMsg("6. Exit");
    }

    // Play a movie
    private void playMovie() {
        String title = ui.promptTxt("Enter movie title: ");
        Movie movie = streaming.getMovie(title);

        if (movie != null) {
            ui.displayMsg(movie.getInfo());
            ui.displayMsg(movie.play());
        } else {
            ui.displayError("Movie not found!");
        }
    }


    // Play an episode
    private void playEpisode() {
        String seriesTitle = ui.promptTxt("Enter series title: ");

        // Find and show series info
        Series foundSeries = null;
        for (Series s : streaming.getAllSeries()) {
            if (s.getTitle().equalsIgnoreCase(seriesTitle)) {
                foundSeries = s;
                break;
            }
        }

        if (foundSeries != null) {
            ui.displayMsg(foundSeries.getInfo());

            int seasonNumber = ui.promptNumericInt("Enter season number: ") - 1;
            int episodeNumber = ui.promptNumericInt("Enter episode number: ");

            Episode episode = streaming.findEpisode(seriesTitle, seasonNumber, episodeNumber);

            if (episode != null) {
                ui.displayMsg("Season " + (seasonNumber + 1) + " Episode " + episode.play() + " of " + seriesTitle);
            } else {
                ui.displayError("Season or episode not found!");
            }
        } else {
            ui.displayError("Series not found!");
        }
    }

    // Show all movies
    private void showAllMovies() {
        ui.displayMsg("=== All Movies ===");
        for (Movie m : streaming.getAllMovies()) {
            ui.displayMsg("- " + m.getTitle());
        }
    }

    // Show all series
    private void showAllSeries() {
        ui.displayMsg("=== All Series ===");
        for (Series s : streaming.getAllSeries()) {
            ui.displayMsg("- " + s.getTitle());
            ui.displayMsg("  Total seasons: " + s.getSeasons().size());

            int seasonNum = 1;
            for (Season season : s.getSeasons()) {
                ui.displayMsg("  Season " + seasonNum + ": " + season.getAllEpisodes().size() + " episodes");
                seasonNum++;
            }
            ui.displayMsg(""); // Empty line between series
        }
    }

    // Show total episodes in a series
    private void showTotalEpisodes() {
        String seriesTitle = ui.promptTxt("Enter series title: ");
        int total = streaming.totalEpisodes(seriesTitle);

        if (total > 0) {
            ui.displayMsg(seriesTitle + " has " + total + " episodes in total.");
        } else {
            ui.displayError("Series not found!");
        }
    }

}