package org.example;

import static org.example.Game.Game.StartGame;
import static org.example.Target.start;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2 && args[0].equals("-t")) {
            if (args[1].equals("1")) {
                start();
            } else {
                StartGame();
            }
        } else StartGame();

    }
}