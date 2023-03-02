package util;

import java.util.Scanner;

/**
 * Class to receive the information from the console
 *
 * @author Isa & Sara
 */
public class Keyboard {
    static Scanner sc = new Scanner(System.in);

    public static String getString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}
