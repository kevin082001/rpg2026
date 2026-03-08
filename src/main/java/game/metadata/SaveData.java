package game.metadata;

import game.objects.PlayerStats;

import java.time.LocalDateTime;

public class SaveData {
    private String username;
    private LocalDateTime lastSaved;
    private PlayerStats stats;

    public SaveData(String username) {
        //TODO IMPORTANT: add "stats"
        this.username = username;
        this.lastSaved = LocalDateTime.now();
    }

    public SaveData() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLastSaved() {
        return lastSaved;
    }

    public void setLastSaved(LocalDateTime lastSaved) {
        this.lastSaved = lastSaved;
    }

    public PlayerStats getStats() {
        return stats;
    }

    public void setStats(PlayerStats stats) {
        this.stats = stats;
    }
}
