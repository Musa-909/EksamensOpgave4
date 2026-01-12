import java.util.ArrayList;

public class Season {
    private ArrayList<Episode> episodes;


    public Season(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }


    public ArrayList<Episode> getAllEpisodes() {
        return episodes;
    }


    // Get specific episode
    public Episode getEpisodeByIndex(int episodeNum) {
        for (Episode episode : episodes) {
            if (episode.getEpisodeNumber() == episodeNum) {
                return episode;
            }
        }
        return null;
    }
}