package org.example;

// (0 4) = a
// (0 1) = b
// (1 4) = c

// a - b = v
// b-v = n/2 = i0
// (b-(a-b))/2


import java.util.Scanner;

public class Target {
    public static void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("(0 4) = a\n(0 1) = b\n(1 4) = c\n");
        String input = scanner.nextLine().trim();

        String[] numbers = input.split("\\s+");

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        System.out.println((b-(Math.abs(a-c)))/2);
    }
}


