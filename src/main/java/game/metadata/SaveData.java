package game.metadata;

import java.time.LocalDateTime;

public class SaveData {
    private String username;
    private LocalDateTime lastSaved;

    public SaveData(String username) {
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
}
