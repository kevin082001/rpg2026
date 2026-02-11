package util;

import game.metadata.SaveData;

import java.util.ArrayList;
import java.util.List;

public class SavefileUtil {
    private List<SaveData> saves = new ArrayList<>();

    public SavefileUtil() {
        saves = this.loadAllSavefiles();
    }

    private List<SaveData> loadAllSavefiles() {
        //look in the save directory and fetch the files
        return saves;
    }

    public SaveData loadSavefile(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }

        //look in the save directory and fetch the correct file

        for (SaveData save : saves) {
            if (save.getUsername().equals(username)) {
                return save;
            }
        }

        return null;
    }

    public void createNew(String username) {
        if (username != null) {
            //create new entry and save onto system
        }
    }

    public List<SaveData> getSaves() {
        return saves;
    }
}
