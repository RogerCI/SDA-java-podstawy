package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-07.
 */
public class Zajecia4 {
    public static void main(String[] args) {

//        displayDate(7, 4, 2017);
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Inse
//        int day = scanner.nextInt();
//        System.out.println("Insert month: ");
//        int month = scanner.nextInt();
//        System.out.println("Insert year: ");
//        int year = scanner.nextInt();
//
//        displayDate(day, month, year);

//        int[] array = {9, 8, 7, 6, 5, 4, 18, 2, 1, 0, -1, -12, -3, -4, -5, -6};

//        statistics(array);

        int[] newArray = getArrayFromUser();

        System.out.println("Your array:");
        displayArray(newArray);

        System.out.println("\nAnd now, statistics for you array!");
        statistics(newArray);

        System.out.println("\nA least, your reversed array:");
        displayReversedArray(newArray);

    }

    public static void statistics(int[] array) {
        int minValue = minFromArray(array);
        int maxValue = maxFromArray(array);
        int sumValue = sumFromArray(array);
        double avgValue = avgFromArray(array);
        int spanValue = spanFromArray(array);

        System.out.println("Min: " + minValue);
        System.out.println("Max: " + maxValue);
        System.out.println("Sum: " + sumValue);
        System.out.println("Avg: " + avgValue);
        System.out.println("Span: " + spanValue);
    }




    public static void displayReversedArray(int[] array) {
        displayArray(reverseArray(array));
    }

   public static int[] reverseArray(int[] array) {
        //tworzymy pusta tablice o tej samejdlugosci co pierwotna
        int[] tmp = new int[array.length];

        //przepisujemy elementy
        for (int i = 0; i<array.length; i++) {
            tmp[array.length -1 - i] = array[i];
            //biore biezacy zadanej tablicy i zapisuje go jako przeciległy element nowej wynikowej tablicy
            //np dla tablicy o 7 elementach:
            //w pierwszej iteracji biore pierwszy (i=0) element zadanej tablicy i wpisuje go jako (dlugosc - 1 - iteracja) = 6 element nowej tablicy
            //w drugiej iteracji biore drugi (i=1) element zadanej tablicy i wpisuje go jako (dlugosc - 1 - 1) = 5 element nowej tablicy
            //itd...
        }

        //zwracamy nowa tablice
       return tmp;
    }

    public static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.print("]");
    }

    public static int[] getArrayFromUser() {
        //tworzymy scanner
        //pytamy usera o ilosc elementow
        //tworzymy pustatablice
        //w petlipytamy usera o elementy

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements would you like to have in your array?");
        int size = scanner.nextInt();

        int[] array = new int[size]; //definicja tablicy o zadanej dlugosci

        for (int i = 0; i<array.length; i++) {
            System.out.println("Please give the " + i + " element: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int minFromArray(int[] array) {
        int tmpMin = array[0];
        for (int i = 0; i < array.length; i++) { //moglbym zaczac od 1
            if (array[i] < tmpMin) {
                tmpMin = array[i];
            }
        }
        return tmpMin;
    }

    public static int maxFromArray(int[] array) {
        int tmpMax = array[0];
        for (int i = 0; i < array.length; i++) { //moglbym zaczac od 1
            if (array[i] > tmpMax) {
                tmpMax = array[i];
            }
        }
        return tmpMax;
    }

    public static int sumFromArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double avgFromArray(int[] array) {
        int sum = sumFromArray(array);
        return sum / (double) array.length;
    }

    public static int abs(int value) {
        if (value < 0) {
            return value * -1;
        } else {
            return value;
        }
    }

    public static int spanFromArray(int[] array) {
        return abs(maxFromArray(array) - minFromArray(array));
//        return maxFromArray(array) - minFromArray(array);
    }

    private static void displayDate(int day, int month, int year) {
        if ((day >= 1 && day <= 31) && (month >= 1 && month <= 12) && year > 0) {
            System.out.println("Dzien: " + day + ", miesiac: " + month + ", rok: " + year);
        } else {
            System.out.println("Wrong data!");
        }

//        if (day >= 1 && day <= 31) {
//            if (month >= 1 && month <= 12) {
//                if (year > 0) {
//                    System.out.println("Dzien: " + day + ", miesiac: " + month + ", rok: " + year);
//                } else {
//                    System.out.println("Wrong year!");
//                }
//            } else {
//                System.out.println("Wrong month!");
//            }
//        } else {
//            System.out.println("Wrong day!");
//        }

    }

}
