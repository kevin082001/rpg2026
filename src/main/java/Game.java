import util.PrintUtil;

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
            PrintUtil.printSavefileSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
