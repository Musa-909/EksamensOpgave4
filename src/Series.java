import java.util.ArrayList;

public class Series extends Media {
    private ArrayList<Season> seasons;


    public Series(String title, String actors, ArrayList<Season> seasons) {
        super(title, actors);
        this.seasons = seasons;
    }

    // Display series info
    @Override
    public String getInfo() {
        return "Title: " + getTitle() + "\nActors: " + getActors() + "\nSeasons: " + seasons.size();
    }

    // Get specific episode by season and episode number
    public Episode getEpisode(int seasonNumber, int episodeNumber) {
        // Check if season exists
        if (seasonNumber < 0 || seasonNumber >= seasons.size()) {
            return null;
        }

        Season season = seasons.get(seasonNumber);
        return season.getEpisodeByIndex(episodeNumber);
    }


    // Getter
    public ArrayList<Season> getSeasons() {
        return seasons;
    }
}
