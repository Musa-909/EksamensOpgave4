public class Movie extends Media implements Playable {
    private String director;

    public Movie(String title, String actors, String director){
        super(title, actors);
        this.director = director;
    }


    // Play the movie
    @Override
    public String play() {
        return "Playing movie: " + getTitle();
    }

    // Display movie info
    @Override
    public String getInfo() {
        return "Title: " + getTitle() + "\nActors: " + getActors() + "\nDirector: " + director;
    }
}