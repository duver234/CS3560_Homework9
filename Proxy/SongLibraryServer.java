import java.util.List;
import java.util.ArrayList;

public class SongLibraryServer {
    private List<Song> songList = new ArrayList<Song>();

    public void addSong(Song song) {
        songList.add(song);
    }

    public List<Song> getSongList() {
        return songList;
    }
}