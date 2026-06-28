packet musicmanagement

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MusicPlayer {
    // 1. Khai báo các cấu trúc dữ liệu theo đề bài
    private ArrayList<Song> playlist;
    private Stack<Song> stackHistory;
    private Song currentSong;
    private final Random random;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        stackHistory = new Stack<>();
        random = new Random();
        currentSong = null;
    }

    // Thêm bài hát vào danh sách phát
    public void addSong(Song song) {
        playlist.add(song);
    }

    // 2. Chức năng Shuffle Play (Phát ngẫu nhiên)
    public void shufflePlay() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist rỗng!");
            return;
        }

        // Nếu đang có một bài đang phát, lưu nó vào lịch sử trước khi đổi bài mới
        if (currentSong != null) {
            stackHistory.push(currentSong);
        }

        // Chọn ngẫu nhiên một index trong ArrayList
        int randomIndex = random.nextInt(playlist.size());
        currentSong = playlist.get(randomIndex);

        System.out.println("🎵 Đang phát (Shuffle): " + currentSong);
    }

    // 3. Chức năng Previous Song (Quay lại bài trước bằng Stack)
    public void previousSong() {
        if (stackHistory.isEmpty()) {
            System.out.println("❌ Không có bài hát nào trong lịch sử để quay lại!");
            return;
        }

        // Lấy bài hát vừa phát gần nhất ra khỏi Stack
        Song prevSong = stackHistory.pop();
        currentSong = prevSong;

        System.out.println("⏮️ Đang phát lại bài trước: " + currentSong);
    }

    // Xem bài hiện tại và lịch sử
    public void displayState() {
        System.out.println("-> Hiện tại: " + currentSong);
        System.out.println("-> Lịch sử (Stack): " + stackHistory);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.addSong(new Song("Bài A"));
        player.addSong(new Song("Bài B"));
        player.addSong(new Song("Bài C"));
        player.addSong(new Song("Bài D"));

        // Giả lập phát nhạc ngẫu nhiên vài lần
        player.shufflePlay();
        player.shufflePlay();
        player.shufflePlay();
        player.displayState();

        // Bấm nút Previous để lùi lại
        player.previousSong();
        player.previousSong();
        player.displayState();
    }
}