package com.lucas4it.spoj;

import java.io.IOException;
import java.util.Scanner;

/**
 * TEST - Life, the Universe, and Everything
 *
 * #basic #tutorial #ad-hoc-1
 *
 * Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything.
 * More precisely... rewrite small numbers from input to output. Stop processing input after reading in the number 42.
 * All numbers at input are integers of one or two digits.
 */
public class Spoj001 {

    public static void main(String[] args) throws IOException {
        boolean shouldContinue = true;

        Scanner scanner = new Scanner(System.in);
        while (shouldContinue) {
            String input = getNext(scanner);
            if (isInputNumber(input) && Integer.parseInt(input) != 42) {
                System.out.println(input);
            } else {
                shouldContinue = false;
            }
        }
    }

    private static String getNext(Scanner scanner) {
        return scanner.next();
    }

    private static boolean isInputNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
