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
        PrintUtil.clearScreen();
        PrintUtil.cmdEchoOff();
        System.out.println("Hallihallöchen");
        PrintUtil.printColorTest();
        System.out.print("Please enter your name:");
        String name = sc.nextLine();
        PrintUtil.clearScreen();
        System.out.println("Hello, " + name);
    }
}
