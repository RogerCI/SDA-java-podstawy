package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-06.
 */
public class Zajecia3 {
    public static void main(String[] args) {
/*
        fahrenheitToCelsius(80);
        celsiusToFahrenheit(25);

        Scanner scanner = new Scanner(System.in);

        System.out.println("First number: ");
        int a = scanner.nextInt();
        System.out.println("Second number: ");
        int b = scanner.nextInt();
        System.out.println("Third number: ");
        int c = scanner.nextInt();

        minMax(a, b, c);
*/

        System.out.println("Zrobilem zadanie domowe!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Height: ");
        double height = scanner.nextDouble();

        bmi(weight, height);

    }

    public static void bmi(double weight, double height) {
        // waga/wzrost^2
        double bmi = weight / (height * height); //wzrost w metrach!!!
        System.out.println("BMI:" + bmi);

        if (bmi < 18.5) {
            System.out.println("Masz niedowage!");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Jest OK.");
        } else {
            System.out.println("Masz nadwage!!!");
        }

    }


    public static void fahrenheitToCelsius(int fahrenheit) {
        double result = (fahrenheit-32)/1.8;
        System.out.println("Fahrenheit: " + fahrenheit + " = Celsius: " + result);
    }

    public static void celsiusToFahrenheit(int celsius) {
        double result = 1.8 * celsius + 32;
        System.out.println("Celsius: " + celsius + " = Fahrenheit: " + result );
    }


    public static void minMax(int a, int b, int c) {

        int min, max;

        if (a >= b && a >= c) {
            max = a;
        }
        else if (b >= a && b >= c) {
            max = b;
        }
        else {
            max = c;
        }

        if (a <= b && a <= c) {
            min = a;
        }
        else if (b <= a && b <= c) {
            min = b;
        }
        else {
            min = c;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);


    }


}
