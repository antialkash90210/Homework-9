package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Random rnd = new Random();
        int numberOfAttempts = 0;
        int compNumber;
        int userNumber = 0;
        final int EXIT_CODE = -1;
        boolean inputResult;

        compNumber = rnd.nextInt(10) + 1;

        do {
            inputResult = true;
            Scanner input = new Scanner(System.in);

            try {
                System.out.println("Введите любое число от 1 до 10: ");
                userNumber = input.nextInt();

                if (userNumber < 1 || userNumber > 10) {
                    throw new Exception();
                }

                if (userNumber > compNumber) {
                    System.out.println("Введите число поменьше: ");
                } else if (userNumber < compNumber) {
                    System.out.println("Введите число побольше: ");
                }

                if (userNumber != EXIT_CODE) {
                    numberOfAttempts++;
                }
            }

            catch (Exception e) {
                inputResult = false;
            }

        } while (compNumber != userNumber || inputResult == false);

        System.out.println("Поздравляю,вы угадали число!! ");
        System.out.println("Количество попыток: " + numberOfAttempts);

        if (numberOfAttempts <= 3) {
            System.out.println("гений");
        } else if (numberOfAttempts > 3 && numberOfAttempts <= 6) {
            System.out.println("среднячок");
        } else {
            System.out.println("лошара");
        }

    }
}