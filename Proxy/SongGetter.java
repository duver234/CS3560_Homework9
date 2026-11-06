import java.util.List;
import java.util.ArrayList;

public class SongGetter implements SongService {
    private SongLibraryServer server;
    private List<Song> songList;

    public SongGetter(SongLibraryServer server) {
        this.server = server;
        this.songList = server.getSongList();
    }

    @Override
    public Song searchById(int songID) {
        for (Song song : songList) {
            if (song.getSongID() == songID) {
                return song;
            }
        }
        System.out.println("Song with ID " + songID + " not found.");
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> returningSongs = new ArrayList<Song>();

        for (Song song : songList) {
            if (song.getTitle().equals(title)) {
                returningSongs.add(song);
            }
        }
        return returningSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> returningSongs = new ArrayList<Song>();

        for (Song song : songList) {
            if (song.getAlbum().equals(album)) {
                returningSongs.add(song);
            }
        }
        return returningSongs;
    }

}