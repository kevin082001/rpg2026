package util;

import game.metadata.SaveData;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;
import org.jline.utils.NonBlockingReader;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has everything from util methods for printing strings, </br>
 * formatting output, printing stuff in a certain color or clearing the screen.
 */
public class PrintUtil {
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

    public static String printSavefileSelect(List<SaveData> existingSaves) {
        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            // Enter raw mode to read keys immediately without pressing Enter
            terminal.enterRawMode();
            NonBlockingReader reader = terminal.reader();
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();

            int selectedIndex = 0;
            boolean running = true;

            List<String> savenames = new ArrayList<>();
            for (SaveData sd : existingSaves) {
                savenames.add(sd.getUsername());
            }
            savenames.add(Colors.GREEN_BRIGHT + "NEW GAME");
            savenames.add(Colors.RED_BRIGHT + "EXIT");

            while (running) {
                terminal.puts(InfoCmp.Capability.clear_screen);

                clearScreen();
                terminal.flush();
                terminal.writer().println("=== rpg2026 - made by kevko ===");
                terminal.writer().println();

                for (int i = 0; i < savenames.size(); i++) {
                    if (i == selectedIndex) {
                        terminal.writer().println(Colors.BG_RED + Colors.WHITE_BOLD + " > " + savenames.get(i) + Colors.WHITE_BOLD + " < " + Colors.RESET);
                    } else {
                        terminal.writer().println(Colors.WHITE_BOLD + "   " + savenames.get(i) + Colors.RESET);
                    }
                }

                //move cursor to "NEW GAME"
                terminal.writer().print("\033[2A");
                terminal.flush();

                // 2. Read Input
                int code = reader.read();

                if (code == 27) { // Escape sequence (Arrow keys start with 27)
                    // Check if more characters are waiting (the [ and A/B/C/D)
                    if (reader.peek(10) != -2) {
                        int next1 = reader.read();
                        int next2 = reader.read();

                        if (next1 == 91 || next1 == 79) { // '['
                            if (next2 == 65) { // UP
                                if (selectedIndex > 0) {
                                    selectedIndex--;
                                }
                            } else if (next2 == 66) { // DOWN
                                if (selectedIndex < savenames.size() - 1) {
                                    selectedIndex++;
                                }
                            }
                        }
                    }
                } else if (code == 10 || code == 13) { // Enter Key
                    if (selectedIndex == savenames.size() - 1) { // Exit
                        terminal.writer().println(Colors.RESET);
                        running = false;
                    } else if (selectedIndex == savenames.size() - 2) { //New Game
                        //clear line so user can enter name in-line
                        terminal.writer().print("\r\033[K");
                        terminal.flush();
                        String name = lineReader.readLine("> ");

                        //profile created!
                        terminal.writer().println("\nProfile '" + name + "' created.\nPress any key to continue...");
                        terminal.flush();
                        reader.read();
                        return name;
                    } else { //Load profile
                        terminal.writer().println(Colors.RESET);
                        terminal.writer().println("Loading " + savenames.get(selectedIndex) + "...");
                        Thread.sleep(1000); // Small pause for effect
                        terminal.writer().println(Colors.RESET);
                        return savenames.get(selectedIndex);
                    }
                } else if (code == 'q') { //debug shortcut ;)
                    running = false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }


    //------------------------------------------
    //Testing methods
    //------------------------------------------

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
