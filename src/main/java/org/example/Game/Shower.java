package org.example.Game;

public class Shower {

    // Текущий процесс
    public static String displayGuessed(Integer[] guessed) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < guessed.length; i++) {
            if (guessed[i] == null) {
                sb.append("-");
            } else {
                sb.append(guessed[i]);
            }
            if (i < guessed.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Проверка все ли элементы угаданы
    public static boolean isFullyGuessed(Integer[] guessed) {
        for (Integer num : guessed) {
            if (num == null) {
                return false;
            }
        }
        return true;
    }

    public static void ShowStart() {
        System.out.println("Угадайте массив из " + Game.getARRAY_SIZE() + " чисел от 0 до " + Game.getMAX_VALUE() + ".");
        ShowHelp();
    }

    public static void ShowHelp() {
        System.out.println("Вы можете запросить сумму двух элементов, введя их индексы (например, '0 4').");
        System.out.println("Или попробуйте угадать элементы, вводя пары индекс-значение (например, '0 1 2 45' = (индекс1 число1 индекс2 число2).");
        Row();
    }
    public static void Row() {
        System.out.println();
    }
}
