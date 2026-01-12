public abstract class Media {
    private String title;
    private String actors;

    public Media(String title, String actors) {
        this.title = title;
        this.actors = actors;
    }

    //Method to display info
    public abstract String getInfo();


    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }
}