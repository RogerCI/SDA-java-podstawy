package zajecia;

import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-04-21.
 */
public class Zajecia11 {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\RENT\\IdeaProjects\\SDA-java-podstawy\\src\\zajecia\\blabla.txt");
//        readFromFileTest(file);
//        writeToFileTest(file, "Hello world!");

//        int[] intArray = readIntegersFromFile(file);
//        Zajecia4.displayArray(intArray);

//        int length = getLength(file);
//        System.out.println("\nLenght of file: " + length);
//
//
        int tmp = countOddIntegers(file);
        System.out.println("\ncount of odd integers from sile: " + tmp);

        int tmpCountWords = countWordsIn(file);
        System.out.println("Count of words: " + tmpCountWords);
    }

    public static int countWordsIn(File file) throws FileNotFoundException {
        //zwraca liczbe wyrazow w pliku
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while (scanner.hasNext()) {
            scanner.next();
            counter++;
        }
        return counter;
    }

    public static int countOddIntegers(File file) throws FileNotFoundException {
        //zwraca sume nieparzystych intow z pliku
        Scanner scanner = new Scanner(file);
//        int sum = 0;
//        for (int i = 0; i < getLength(file); i++) {
//            if (scanner.hasNext() && scanner.nextInt() % 2 == 1) {
//                System.out.println("i: " + i + "|" + scanner.nextInt() + "|");
//                sum += scanner.nextInt();
//            }
//        }
//
//        return sum;

        int counter = 0;
        while (scanner.hasNextInt()) {
            if (scanner.nextInt() % 2 == 1) {
                counter++;
            }
        }
//        scanner.close();
        return counter;
    }

    public static int[] readIntegersFromFile(File file) throws FileNotFoundException {
        //zwraca tablice z wszystkimiintami z pliku
        int[] resultArray = new int[getLength(file)];
        Scanner scanner = new Scanner(file);

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = scanner.nextInt();
        }
        return resultArray;
    }

    public static int getLength(File file) throws FileNotFoundException {
        //zwraca liczbe linii w pliku
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while (scanner.hasNext()) {
            counter++;
            scanner.nextLine();
        }
        return counter;
    }

    public static void writeToFileTest(File file, String message) throws IOException {
        try (
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)
                ) {
            out.println(message);
        }
//        try (ergerger) {
//            ergrgwr
//        }
    }

    private static void readFromFileTest(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }



}
