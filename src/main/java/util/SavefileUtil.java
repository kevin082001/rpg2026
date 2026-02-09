package util;

import game.metadata.SaveData;

import java.util.ArrayList;
import java.util.List;

public class SavefileUtil {
    private static List<SaveData> saves = new ArrayList<>();

    public static List<SaveData> loadAllSavefiles() {
        return saves;
    }

    public static SaveData loadSavefile(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }

        for(SaveData save : saves) {
            if(save.getUsername().equals(username)) {
                return save;
            }
        }

        return null;
    }

    public static void create(SaveData data) {
        if (data != null) {
            //create new entry
        }
    }
}
