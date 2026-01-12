public class Episode implements Playable{
    private int episodeNumber;

    public Episode(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    // Play the episode
    @Override
    public String play() {
        return episodeNumber + " is now playing";
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }
}