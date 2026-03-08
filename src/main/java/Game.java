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
    private static SaveData user;

    public void start() {
        //PrintUtil.printColorTest();

        try {
            SavefileUtil sfu = new SavefileUtil();
            List<SaveData> allSaves = sfu.getSaves();
            Thread.sleep(2000);
            String profileToLoad = PrintUtil.printSavefileSelect(allSaves);
            if (profileToLoad != null && !profileToLoad.isEmpty()) {
                for (SaveData save : allSaves) {
                    if (save.getUsername().equals(profileToLoad)) {
                        user = sfu.loadSavefile(profileToLoad);

                        //TODO open user main menu (fight, map, notebook, shop, etc...)
                        userMainMenu();
                        //TODO checking what was selected

                        return;
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

    private void userMainMenu() {
        int userMainMenuChoice = PrintUtil.printUserMainMenu(user);
        switch (userMainMenuChoice) {
            case 1:
                PrintUtil.clearScreen();
                System.out.println("fight");
                break;
            case 2:
                PrintUtil.clearScreen();
                System.out.println("map");
                break;
            case 3:
                PrintUtil.clearScreen();
                System.out.println("notebook");
                break;
            case 4:
                PrintUtil.clearScreen();
                System.out.println("bag");
                break;
            case 5:
                PrintUtil.clearScreen();
                System.out.println("collection");
                break;
            case 6:
                try {
                    PrintUtil.clearScreen();
                    System.out.println("Goodbye");
                    Thread.sleep(1000);
                    System.exit(67);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
                try {
                    PrintUtil.clearScreen();
                    System.out.println("invalid option. try again.");
                    Thread.sleep(1500);
                    userMainMenu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
