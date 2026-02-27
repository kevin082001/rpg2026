package util;

import game.metadata.SaveData;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SavefileUtil {
    private List<SaveData> saves = new ArrayList<>();

    public SavefileUtil() {
        saves = this.loadAllSavefiles();
    }

    private List<SaveData> loadAllSavefiles() {
        //look in the save directory and fetch the files

        try {
            Path saveDir = Paths.get("saves", ".");
            DirectoryStream<Path> stream = Files.newDirectoryStream(saveDir, "*.save");
            for (Path entry : stream) {
                String content = Files.readString(entry);
                String[] lines = content.split("\\R");
                System.out.println("Found save file " + entry.getFileName());
                String fileName = entry.getFileName().toString();
                String playerName = fileName;
                int lastDot = fileName.lastIndexOf(".");
                if (lastDot > 0) {
                    playerName = fileName.substring(0, lastDot);
                }
                SaveData data = new SaveData();
                data.setUsername(playerName);
                saves.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return saves;
    }

    public SaveData loadSavefile(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }

        for (SaveData save : saves) {
            if (save.getUsername().equals(username)) {
                return save;
            }
        }

        return null;
    }

    public void createNew(String username) {
        if (username != null && !username.trim().isEmpty()) {
            //create new entry and save onto system

            try {
                SaveData data = new SaveData(username);
                File savefile = new File("saves/" + username + ".save");
                FileWriter fw = new FileWriter(savefile);
                fw.write(username);
                fw.write("\n" + data.getLastSaved().toString());
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(SaveData updatedData) {
        if (updatedData == null) {
            return;
        }

        String username = updatedData.getUsername();
        if (username != null && username.trim().isEmpty()) {
            for (SaveData sv : saves) {
                if (sv.getUsername().equals(username)) {
                    try {
                        FileWriter fw = new FileWriter("saves/" + username + ".save");
                        fw.write(sv.getUsername());
                        fw.write("\n" + sv.getLastSaved().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public List<SaveData> getSaves() {
        return saves;
    }
}
