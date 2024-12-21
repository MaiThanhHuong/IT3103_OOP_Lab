package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList();

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super(title, category, cost, director, length);
        this.artist = artist;
        this.tracks = tracks;
    }

    public boolean containsTrack(Track track){
        if(track == null) return false;
        for (Track t : tracks){
            if(track.equals(t)){
                return true;
            }
        }
        return false;
    }

    public void addTrack(Track track){
        if(containsTrack(track)){
            System.out.println("Track already added");
            return;
        }

        tracks.add(track);
        System.out.println("Added track " + track.getTitle() + " successfully");

    }

    public int getLength(){
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() throws PlayerException {
        for (Track track : tracks) {
            if (track.getLength() <= 0) {
                throw new PlayerException("Track length is invalid.");
            }
            track.play();
        }
    }

}