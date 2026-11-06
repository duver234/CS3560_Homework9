import java.util.List;
import java.util.HashMap;

public class SongProxyGetter implements SongService {
    private final HashMap<String, Song> songCache = new HashMap<>();
    private final HashMap<String, List<Song>> songListCache = new HashMap<>();
    private final SongService getter;
    private final SongLibraryServer server;

    public SongProxyGetter(SongLibraryServer server) {
        this.server = server;
        this.getter = new SongGetter(server);
    }

    @Override
    public Song searchById(int songID) {
        String songIDString = String.valueOf(songID);
        if (!songCache.containsKey(songIDString)) {
            songCache.put(songIDString, getter.searchById(songID));
        }
        return songCache.get(songIDString);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!songListCache.containsKey(title)) {
            songListCache.put(title, getter.searchByTitle(title));
        }
        return songListCache.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!songListCache.containsKey(album)) {
            songListCache.put(album, getter.searchByAlbum(album));
        }
        return songListCache.get(album);
    }

}