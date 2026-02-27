import game.metadata.SaveData;
import util.PrintUtil;
import util.SavefileUtil;

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
            SavefileUtil sfu = new SavefileUtil();
            List<SaveData> allSaves = sfu.getSaves();
            Thread.sleep(2000);
            String profileToLoad = PrintUtil.printSavefileSelect(allSaves);
            if (profileToLoad != null && !profileToLoad.isEmpty()) {
                System.out.println("blub");
                for (SaveData save : allSaves) {
                    System.out.println("Checking: " + save.getUsername() + ".save");
                    if (save.getUsername().equals(profileToLoad)) {
                        System.out.println("will load: " + save.getUsername() + ".save");
                        sfu.loadSavefile(profileToLoad);
                    }
                }

                //new profile
                System.out.println("creating new profile for player '" + profileToLoad + "'");
                sfu.createNew(profileToLoad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
