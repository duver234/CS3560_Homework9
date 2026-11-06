import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongLibraryServer server = new SongLibraryServer();
        server.addSong(new Song(123, "Song A", "Artist A", "Album A", 180));
        server.addSong(new Song(456, "Song B", "Artist B", "Album B", 200));
        server.addSong(new Song(789, "Song C", "Artist C", "Album C", 220));
        server.addSong(new Song(101, "Song D", "Artist D", "Album D", 240));
        server.addSong(new Song(102, "Song E", "Artist E", "Album E", 260));
        server.addSong(new Song(103, "Song F", "Artist F", "Album F", 280));

        SongService getter = new SongProxyGetter(server);
        Song song = getter.searchById(123); // This should retrieve the song from the server and cache it
        song.playSong();

        List<Song> songsByTitle = getter.searchByTitle("Song B");
        System.out.println("Songs with title 'Song B':");
        for (Song s : songsByTitle) {
            System.out.println("- " + s.getTitle());
        }

        song = getter.searchById(456);
        song.playSong();

        song = getter.searchById(123); // This should retrieve the song from the cache
        song.playSong();

        List<Song> songsByAlbum = getter.searchByAlbum("Album C");
        System.out.println("Songs in album 'Album C':");
        for (Song s : songsByAlbum) {
            System.out.println("- " + s.getTitle());
        }


    }
}