import game.metadata.SaveData;
import util.PrintUtil;
import util.SavefileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The game loop.</br>
 * This class holds all variables which are relevant while playing. </br>
 * (player stats, enemies, map, collection, ....)
 */
public class Game {

    private final static Scanner sc = new Scanner(System.in);

    public void start() {
        //PrintUtil.printColorTest();

        try {
            //TODO implement actual functionality to save and load files
            //List<SaveData> allSaves = SavefileUtil.loadAllSavefiles();
            List<SaveData> allSaves = new ArrayList<>();
            allSaves.add(new SaveData("hero1"));
            allSaves.add(new SaveData("kevko"));
            allSaves.add(new SaveData("torvaldsthegoat1234"));
            PrintUtil.printSavefileSelect(allSaves);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
