package musicmanagement;

public class Song {

    private String id;
    private String title;
    private String artist;
    private int duration;

    public Song(String id, String title, String artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        int min = duration / 60;
        int sec = duration % 60;
        return String.format("ID: %-6s | Title: %-25s | Artist: %-20s | Duration: %02d:%02d",
                id, title, artist, min, sec);
    }

}
