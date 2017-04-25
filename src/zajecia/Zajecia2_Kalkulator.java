package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-05.
 */
public class Zajecia2_Kalkulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz dzialanie: ");
        System.out.println("1: dodawanie");
        System.out.println("2: odejmowanie");
        System.out.println("3: mnozenie");
        System.out.println("4: dzielenie");
        System.out.println("5: wartosc bezwzgledna z roznicy");
        System.out.println("10: suma elementow mniejszych od");
        System.out.println("100: srednia elementow");


        int choice = scanner.nextInt();
        int number1 = 0, number2 = 0;

        if (choice < 10) {
            System.out.println("Liczba 1: ");
            number1 = scanner.nextInt();
            System.out.println("Liczba 2: ");
            number2 = scanner.nextInt();
        }
        else if (choice < 100){
            System.out.println("Liczba 1: ");
            number1 = scanner.nextInt();
        }

        int result = 0;

        if (choice == 1) {
            sum(number1, number2);
        }
        else if (choice == 2) {
            division(number1, number2);
        }
        else if (choice == 3) {
            multiply(number1, number2);
        }
        else if (choice == 4) {
            divide(number1, number2);
        }
        else if (choice == 5) {
            abs(number1, number2);
        }
        else if (choice == 10) {
            sumLessThan(number1);
        }
        else if (choice == 100) {
            int[] tmp = {1, 2, 3, 4, 5, 9, 34, 123};
            avg(tmp);
        }
        else {
            System.out.println("Bledne dzialanie!");
        }






    }

    public static void abs(int a, int b) {
        int abs = a -b;
        if (abs < 0) abs *= -1;
        System.out.println("|" + a + " - " + b + "| = " + abs);
    }

    public static void divide(int a, int b) {
        if (b != 0) {
            System.out.println(a + " / " + b + " = " + (a/(double)b));
        }
        else {
            System.out.println("Nie dzielimy przez zero!");
        }
    }

    public static void multiply(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a*b));
    }

    public static void division(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a-b));
    }

    public static void sum(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a+b));
    }

    public static void sumLessThan(int number) {
        //suma cyfr mniejszych od zadanej
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum +=i;
        }
        System.out.println("Sum is: " + sum);
    }
    public static void avg(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double avg = sum / (double)array.length;
        System.out.println("Avg: " + avg);
    }

}
