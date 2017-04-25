package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-04.
 */
public class Zajecia1_ZadaniaZeScannerem {
    public static void main(String[] args) {

        //checkOfSthFromUser();
        //isEvenFromUser();
        //displayEvenElements();
        //sumOddElements();
        //countEvenElements();
        //incrementElement();
//        addPreviousElement();
        //multiplyBy2();
        //fillArray();
        //fillArrayWithUnknownSize();
        addElementsMultipliedBy();
    }

    public static void checkOfSthFromUser() {
        //ktora cyfra podana przez usera jest wieksza
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert your first number: ");
        int number1 = scanner.nextInt();
        System.out.println("Your number is: " + number1);

        System.out.println("Insert your second number: ");
        int number2 = scanner.nextInt();
        System.out.println("Your second number is: " + number2);

        if (number1 > number2) System.out.println("First number is greater!");
        else if (number2 > number1) System.out.println("Second number is greater!");
        else System.out.println("Numbers are equal!!!");

    }

    public static void isEvenFromUser() {
        //pobieramy liczbe od usera i sprawdzamy parzystosc
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert number: ");
        int number = scanner.nextInt();
        System.out.println("Your number is: " + number);

        if (number %2 == 0) System.out.println("Your number is even!");
        else System.out.println("Your number os odd!");
    }

    public static void displayEvenElements() {
        //wyswietl co drugi element
        int[] array = {2, 3, 4, 5, 6, 7, 9, 11, 13};
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) System.out.println(array[i]);
        }
    }

    public static void sumOddElements() {
        //suma nieparzystych
        int[] array = {2, 3, 4, 5, 6, 7, 9, 11, 13};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) sum += array[i];
        }
        System.out.println("Suma nieparzystych to: " + sum);
    }

    public static void countEvenElements() {
        //ile jest parzystych
        int[] array = {2, 3, 4, 5, 6, 7, 9, 11, 13};
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) counter++;
        }
        System.out.println("Count of even: " + counter);
    }

    public static void incrementElement() {
        int[] array = {2, -3, 4, 5, -6, 7, 9, 11, 13};
        for (int i = 0; i < array.length; i++) {
            System.out.println("my element: " + array[i]);
            if (array[i] <0 ) {
                array[i] += 1;
                System.out.println("changed: " + array[i]);
            }
        }

    }

    public static void addPreviousElement() {
        int[] array = {2, -3, 4, 5, -6, 7, 9, 11, 13};
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i-1];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static void multiplyBy2() {
        //kazdy element doatki podzielny przez3 mnozymy razy 2
        int[] array = {2, -3, 4, 5, -6, 7, 9, 11, 13};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 3 == 0) array[i] = array[i] * 2;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static void fillArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert numberOfBooks: ");
        int size = scanner.nextInt();
        int[] array = new int[size]; //pusta tablica o zadanej liczbie elementach

        for (int i = 0; i < array.length; i++) {
            System.out.println("Give number: ");
            int number = scanner.nextInt();
            array[i] = number;
        }
        System.out.println("-----");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void fillArrayWithUnknownSize() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[100];
        int element = 1;
        int i = 0;

        while (element != 0) {
            System.out.println("Insert next number. Press 0 to break.  ");
            element = scanner.nextInt();
            array[i] = element;
            i++;
        }
        System.out.println("-----");
        for (int j = 0; j < i; j++) { //bo inaczej wyswietlimy wszystkie 100 elementow, a chcemy tylko tyle ile podal user
            System.out.println(array[j]);
        }
    }

    public static void addElementsMultipliedBy() {
        //pytamy o rozmiar tablicy
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert numberOfBooks: ");
        int size = scanner.nextInt();

        //tworzymy tablice
        int[] array = new int[size]; //pusta tablica o zadanej liczbie elementach


        //w petlifor dodajemy elementy do tablicy
        for (int i = 0; i < array.length; i++) {
            System.out.println("Give number: ");
            int number = scanner.nextInt();

            //jesli element jest pierwszy w tablicy to dodajemy go w przeciwnym razie mnozymy to co dal user przez
            // poprzedni element i dopiero to wstawiamy jako nowy element tablicy
            if (i == 0) {
                array[i] = number;
            } else {
                array[i] = number * array[i - 1];
            }
        }

            //wyswietlenie elementow podzielnych przez 3
            System.out.println("---------");
            for (int j = 0; j < array.length; j++) {
                if (array[j] % 3 == 0) System.out.println(array[j]);
            }

            //wyswietlenie sredniej
            System.out.println("---------");
            int sum = 0;
            for (int w = 0; w < array.length; w++) {
                sum += array[w];
            }
            double avg = sum / (double)array.length;
        System.out.println("Avg: " + avg);



    }


}
