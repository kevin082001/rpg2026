package util;

/**
 * This class has everything from util methods for printing strings, </br>
 * formatting output, printing stuff in a certain color or clearing the screen.
 */
public class PrintUtil {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cmdEchoOff() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "@echo off").inheritIO().start().waitFor();
            } else {
                //only supported for windows cmd
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printColorTest() {
        System.out.println(Colors.GREEN + "This is green!" + Colors.RESET);
        System.out.println(Colors.GREEN_BRIGHT + "This is green but bright!" + Colors.RESET);
        System.out.println("This is default color!");
        System.out.println(Colors.RED + "This is red!" + Colors.RESET);
        System.out.println(Colors.RED_BRIGHT + "This is red but bright!" + Colors.RESET);
        System.out.println(Colors.YELLOW + "This is yellow!" + Colors.RESET);
        System.out.println(Colors.YELLOW_BRIGHT + "This is yellow but bright!" + Colors.RESET);
        System.out.println(Colors.BLUE + "This is blue!" + Colors.RESET);
        System.out.println(Colors.BLUE_BRIGHT + "This is blue but bright!" + Colors.RESET);
        System.out.println(Colors.PURPLE + "This is purple!" + Colors.RESET);
        System.out.println(Colors.PURPLE_BRIGHT + "This is purple but bright!" + Colors.RESET);
        System.out.println(Colors.CYAN + "This is cyan!" + Colors.RESET);
        System.out.println(Colors.CYAN_BRIGHT + "This is cyan but bright!" + Colors.RESET);
        System.out.println(Colors.BLACK + "This is black!" + Colors.RESET);
        System.out.println(Colors.BLACK_BOLD + "This is black but bold!" + Colors.RESET);
        System.out.println(Colors.WHITE + "This is white!" + Colors.RESET);
        System.out.println(Colors.WHITE_BOLD + "This is white but bold (and also bright i guess if that makes sense)!" + Colors.RESET);
        System.out.println(Colors.BG_BLACK + Colors.WHITE_BOLD + "Background should now be black" + Colors.RESET);
        System.out.println(Colors.BG_RED + Colors.WHITE_BOLD + "Background should now be red" + Colors.RESET);
        System.out.println(Colors.BG_GREEN + Colors.WHITE_BOLD + "Background should now be green" + Colors.RESET);
        System.out.println(Colors.BG_YELLOW + Colors.WHITE_BOLD + "Background should now be yellow" + Colors.RESET);
        System.out.println(Colors.BG_BLUE + Colors.WHITE_BOLD + "Background should now be blue" + Colors.RESET);
        System.out.println(Colors.BG_PURPLE + Colors.WHITE_BOLD + "Background should now be purple" + Colors.RESET);
        System.out.println(Colors.BG_CYAN + Colors.WHITE_BOLD + "Background should now be cyan" + Colors.RESET);
        System.out.println(Colors.BG_WHITE + Colors.BLACK + "Background should now be white and text black" + Colors.RESET);
    }
}
