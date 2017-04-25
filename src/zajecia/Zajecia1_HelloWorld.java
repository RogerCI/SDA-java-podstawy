package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-04.
 */
public class Zajecia1_HelloWorld {
    public static void main(String[] args) {

//        checkAge();
//        isNumberEven();
//        checkBigger();
//        displayEvenNumbers();
//        greaterThan0();
//        listPositiveEven();
//        sumOfElements();
//        sumOfEven();
//        sumOfPositive();
//        sumOfEvenGreaterThan();
//        avg();
//        sumOfSth();
//        sumMultipliedBy();
        sumOfSthFromUser();
/*
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Your number is: " + number);
        String name = scanner.nextLine();
        System.out.println("Your name is: " + name);
*/
    }

    public static void checkAge() {
        int age = 18;
        if (age >= 18) {
            System.out.println("age over 18");
        } else {
            System.out.println("age under 18");
        }
    }

    public static void isNumberEven() {
        int number = 8;
        if (number % 2 == 0) {
            System.out.println("number is even!");
        } else {
            System.out.println("this number is odd!");
        }
    }

    public static void checkBigger() {
        int number1 = 3;
        int number2 = 3;

        if (number1 > number2) {
            System.out.println("First number is bigger");
        } else if (number1 == number2) {
            System.out.println("Numbers are equal!");
        }
        else {
            System.out.println("Second number is bigger");
        }
    }

    public static void arrayTest() {
        int[]array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6};

        for (int i = 0; i < array.length; i++) {
            System.out.println("index: " + i + ", wartosc: " + array[i]);
        }
    }

    public static void displayEvenNumbers() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) System.out.println(array[i]);
        }
    }

    public static void greaterThan0(){
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) System.out.println(array[i]);
        }
    }

    public static void listPositiveEven() {
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 2 == 0) System.out.println(array[i]);
        }
    }

    public static void sumOfElements() {
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum +=array[i];
        }
        System.out.println("Sum: " + sum);
    }

    public static void sumOfEven() {
        //sumujemy tylko parzyste
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }

    public static void sumOfPositive() {
        //suma dodatkich
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }

    public static void sumOfEvenGreaterThan() {
        //suma doatkich parzystych
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 2 == 0) sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }

    public static void  avg() {
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double avg = sum / (double)array.length;
        System.out.println("Avg: " + avg);
    }

    public static void sumOfSth() {
        //suma cyfr mniejszych od zadanej, ale wieksze od zero
        int number = 5;
        int sum = 0;

        for (int i = 1; i < number; i++) {
            sum += i;
        }

        System.out.println("My sum: " + sum);
    }

    public static void sumMultipliedBy () {
        //suma wszystkich elementow przemnozonych przez indeks danego elementu oraz srednia z tak przemnozonych elementow
        int[] array = {-1, 2, -3, 4, 5, 7, -9, 15};
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum+= array[i] * i;
        }
        double msum = sum / (double)array.length;
        System.out.println("Multiplied sum: " + sum);
        System.out.println("Average of multiplied sum: " + msum);
    }

    public static void sumOfSthFromUser() {
        //suma cyfr mniejszych od zadanej - podanejprzez usera - , ale wieksze od zero
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your number: ");
        int number = scanner.nextInt();
        System.out.println("Your number is: " + number);

        int sum = 0;

        for (int i = 1; i < number; i++) {
            sum += i;
        }

        System.out.println("My sum: " + sum);
    }


}
