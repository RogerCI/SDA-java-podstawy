package zajecia;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/**
 * Created by RENT on 2017-04-10.
 */
public class Zajecia5 {
    public static void main(String[] args) {

//        Zajecia4.displayArray( getArray(10) );
//        System.out.println();
//        Zajecia4.displayArray( getArray(11) );
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Insert value:");
//        int someValue = scanner.nextInt();
//        Zajecia4.displayArray( getArray(someValue) );

//        randomTest();
        /*
        int[] newArray = getRandomArray(7); //dlugosc wyniku - zakres - przesuniecie
        Zajecia4.displayArray(newArray);

        System.out.println();

        int[] newArray2 = getRandomArray(13, 5, 100); //dlugosc wyniku - zakres - przesuniecie
        Zajecia4.displayArray(newArray2);

        System.out.println();
        Zajecia4.displayArray(getRandomArray(10));
        System.out.println();
        Zajecia4.displayArray(getRandomArray(10, 15));
        System.out.println();
        Zajecia4.displayArray(getRandomArray(10, 15, 20));
        */

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert numberOfBooks: ");
        int numberOfBooks = scanner.nextInt();
        System.out.println("Insert bound: ");
        int bound = scanner.nextInt();
        System.out.println("Insert offset: ");
        int offset = scanner.nextInt();

        Zajecia4.displayArray(getRandomArray(numberOfBooks, bound, offset));

        System.out.println("Statistics:");
        Zajecia4.statistics(getRandomArray(numberOfBooks, bound, offset));
        */

//        printSquare(5);
//        System.out.println();
//        printRectangle(2, 3);
//        System.out.println();
//        printTriangle(5);
//        printMatrixOfNumber(5);
//        printOneMatrix(5);
//        printEmptySquare(5);
//        printChessBoard(5);
//        tree(3);
//        homework();
        lineOfNumbers(5);


    }

    //1
    //  2
    //   3
    //    4
    public static void lineOfNumbers(int value) {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < i; j++) { //tutaj drukowanie spacji - spacji jest tyle jaki jest numer wiersza (czyli i)
                System.out.print("  "); //wypisuje dwie spacje jako jeden odstep ze wzgledow estetycznych
            }
            //teraz liczba do wydrukowania, czyli i+1
            System.out.println((i+1));
        }
    }

    public static void homework() {
        //losujemy liczbe z przedzialu 15-25
        Random random = new Random();
        int size = random.nextInt(10) + 15;
        System.out.println("SIZE: " + size);
        //wywolac metode getArray
        int[] array = getArray(size);
                //mozna tez:
                //int[] array = getRandomArray(10, 10, 15);
        Zajecia4.displayArray(array);
        //uzyc wygenerowanej tablicy w metodzie statistics
        Zajecia4.statistics(array);
        //dla wylosowanej (liczby - 12) zrobic drzewko
        tree(size - 12);
    }

    //a = 3
    //    *
    //  * * *
    //* * * * *
    //    *
    //    *
    //    *

    //w pierwszym wierszu ilosc spacji to: a - i -1
    // ilosc gwiazdek to zawsze 2 * i + 1
    //korzeń: w wierszy jest (a-1) spacji i jedna gwiazdka, a wierszy jest tyle ile a

    public static void tree(int a) {
        //górna cześć
        for (int i = 0; i<a; i++) { //tutaj przechodzimy po wierszach

            for (int j = 0; j < (a-i-1); j++) { //tu piszemy spacje
                System.out.print("  ");
            }

            for (int j = 0; j < (2*i+1); j++) { //tu piszemy gwiazdki
                System.out.print("* ");
            }
            System.out.println();
        }
        //teraz korzeń
        for (int i = 0; i < a; i++) { //wierszy jest tyle ile a
            for (int j = 0; j < a-1; j++) { //drukuje (a-1) spacji w wierszu...
                System.out.print("  ");
            }
            System.out.println("*"); //... oraz jedna gwiazdke
        }
    }


    //1 0 1 0
    //0 1 0 1
    //1 0 1 0
    //0 1 0 1
    public static void printChessBoard(int a) {
        for (int i = 0; i < a; i++) { //jesli suma wspolrzednych jest parzysta to wydrukuj 1
            for (int j = 0; j < a; j++) {
                if ((i+j) % 2 == 0) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //1 1 1 1
    //1     1
    //1     1
    //1 1 1 1
    public static void printEmptySquare(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == 0 || i == a-1 || j == 0 || j == a-1) { //pierwszy wiersz - ostatni wiersz - pierwsza kolumna - ostatnia kolumna
                    System.out.print("1 ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //1 0 0 0
    //0 1 0 0
    //0 0 1 0
    //0 0 0 1
    public static void printOneMatrix(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void printMatrixOfNumber(int a) {
        //wariant 1
        /*
        int value = 1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (value <10 ) {
                    System.out.print(" " + value + " ");
                }
                else {
                    System.out.print(value + " ");
                }
                value++;
            }
            System.out.println();
        }
        */
        //wariant 2 - bardziej cwany
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print((i*a + j + 1) + " ");  //nr wiersza razy jego dlugosc plus pozycja w wierszu plus jeden
            }
            System.out.println();
        }
    }

    //zadanie domowe: funkcja zwracajaca odpowiednia liczbe spacji; do uzycia w powyzszej funkcji
//    public static int giveSpaces(int dlugoscBoku, int liczba) {
//        int dlugosc = dlugoscBoku *dlugoscBoku;
//        return maxWartoscWMacierzy - String.valueOf(liczba).length(); //
//    }

//    *
//    * *
//    * * *
//    * * * *
    public static void printTriangle(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) { //drukuje tyle kropek ile wartoci ma w sobie zewnetrzny licznik
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printRectangle(int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printSquare(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static int[] getRandomArray(int size) {  //przedefiniowanie
        return getRandomArray(size, Integer.MAX_VALUE);
    }

    public static int[] getRandomArray(int size, int bound) {   //przedefiniowanie
        return getRandomArray(size, bound, 0);
    }

    public static int[] getRandomArray(int size, int bound, int offset) { //definiujemy dokladnie tylko te wersje, ktora jest najbardziej skomplikowana
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound) + offset;
        }
        return array;
    }

    public static void randomTest() {
        Random random = new Random();

        System.out.println(random.nextInt()); //z calego zakresu int-a
        System.out.println(random.nextInt(10)); //od 0 do 10
        System.out.println(random.nextInt(10) + 5); //od 5 do 15
        System.out.println(random.nextInt(10) - 5); //od -5 do 5
    }

    public static int[] getArray(int value) {
        //funkcja ma stworzyc tablice parzystych liczb od zero do ostatniej parzystej mniejszej od zadanego value
        //czyli np. dla 11 ma byc od 0 do 10, a dla 10 ma byc od 0 do 8
        //obliczyc numberOfBooks

        //WERSJA PIERWSZA
        //int numberOfBooks = value / 2 + value % 2;  //czyli dla value - 11 mam 11/2 + 11%2 = 5 + 1 = 6 elementów
        //int[] array = new int[numberOfBooks];

        //w petli ustawic wartosci
        //for (int i = 0; i < array.length; i++) {
        //    array[i] = i * 2;
        //}
        //return array;


        //WERSJA DRUGA - dla nieparzystego value dajw wyniku 1, 3, 5, 7, itd... a dla parzystego tak jak bylo
        //wariant 1
        /*
        int numberOfBooks = value / 2; //obojetnie czy parzystych czy nieparzystych liczba elementow w ynikowej tablicy bedzie taka sama
        int[] array = new int[numberOfBooks];
        if (value % 2 == 0) { //parzyste
            for (int i = 0; i < array.length; i++) {
                array[i] = i * 2;
            }
            return array;
        } else { //nieparzyste
            for (int i = 0; i < array.length; i++) {
                array[i] = i * 2 + 1; //dla nieparzystych dodaje jeden, zeby przeskakiwac po nieparzystych
            }
            return array;
        }
        */

        //wariant 2

        int size = value / 2;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + value % 2; //dla parzystych dodaje 0, a dla nieparzystych - 1.
        }
        return array;




    }


}
