import util.PrintUtil;

import java.util.Scanner;

public class Game {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
