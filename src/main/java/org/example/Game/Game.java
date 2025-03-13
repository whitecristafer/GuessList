package org.example.Game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static org.example.Game.Shower.*;

public class Game {
    private static final int ARRAY_SIZE = 5;
    private static final int MAX_VALUE = 100;

    public static int getMAX_VALUE() {
        return MAX_VALUE;
    }

    public static int getARRAY_SIZE() {
        return ARRAY_SIZE;
    }

    public static void StartGame() {
        Random random = new Random();
        int[] array = new int[ARRAY_SIZE];
        Integer[] guessed = new Integer[ARRAY_SIZE];

        // Создаем рандом цифры
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(MAX_VALUE + 1);
        }

        Scanner scanner = new Scanner(System.in);
        ShowStart();

        while (true) {
            System.out.println("\nПрогресс: " + displayGuessed(guessed));
            System.out.print(" >>  ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Вы не ввели команду.");
                continue;
            }

            String[] parts = input.split("\\s+");

            try {
                if (parts.length == 2) {
                    int i = Integer.parseInt(parts[0]);
                    int j = Integer.parseInt(parts[1]);

                    if (i < 0 || j < 0 || j >= ARRAY_SIZE) {
                        System.out.println("Должны быть индексы от 0 до " + (ARRAY_SIZE - 1));
                        continue;
                    }

                    if (i == j) {
                        System.out.println("Вы ввели одинаковые индексы, а так не честно :3");
                        continue;
                    }

                    int sum = array[i] + array[j];
                    System.out.println("Сумма по индексам " + i + " и " + j + ": " + sum);
                } else if (parts.length % 2 == 0) {
                    boolean allCorrect = true;

                    for (int k = 0; k < parts.length; k += 2) {
                        int idx = Integer.parseInt(parts[k]);
                        int val = Integer.parseInt(parts[k + 1]);

                        if (idx < 0 || idx >= ARRAY_SIZE) {
                            System.out.println("Ошибка: индекс " + idx + " вне диапазона 0-" + (ARRAY_SIZE - 1) + ".");
                            allCorrect = false;
                            break;
                        }

                        if (array[idx] != val) {
                            allCorrect = false;
                            break;
                        }
                    }

                    if (allCorrect) {
                        boolean updated = false;

                        for (int k = 0; k < parts.length; k += 2) {
                            int idx = Integer.parseInt(parts[k]);
                            int val = Integer.parseInt(parts[k + 1]);

                            if (guessed[idx] == null) {
                                guessed[idx] = val;
                                updated = true;
                            }
                        }

                        if (updated) {
                            System.out.println("Верно! Обновленный прогресс: " + displayGuessed(guessed));
                        } else {
                            System.out.println("Верно, но эти элементы уже были угаданы.");
                        }

                        if (isFullyGuessed(guessed)) {
                            System.out.println("\nПоздравляем! Вы угадали все элементы массива!");
                            System.out.println("Загаданный массив был: " + Arrays.toString(array));
                            break;
                        }
                    } else {
                        System.out.println("Одно или несколько значений неверны.");
                    }
                } else {
                    System.out.println("Неверный формат ввода. Вот верный:\n\n");
                    ShowHelp();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целые числа в правильном формате:\n\n");
                ShowHelp();

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }


}

