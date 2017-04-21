package zajecia;

import java.util.Random;

/**
 * Created by RENT on 2017-04-20.
 */
public class Zajecia10 {
    public static void main(String[] args) {

        int result = find("Ala ma kota", 'z');
        System.out.println("char position: " + result);

        int result2 = countAll("Ala ma kota.", 'a');
        System.out.println("char count: " + result2);

        int result3 = find("Ala ma kota", "la");
        System.out.println("word position: " + result3);

        int[] resultStatistics = stringStatistics("Ala ma kota i Borsuka");
        Zajecia4.displayArray(resultStatistics);

        System.out.println();

        printStringStatistics(resultStatistics);

        System.out.println();

        int wynik = multiplyDigits(246);
        System.out.println("multiply digits: " + wynik);

        int[][] myRandomMatrix = randomMatrix(3, 10, 5);
        int[][] myRandomMatrix2 = randomMatrix(3, 10, 5);
        Zajecia7.displayMatrix(myRandomMatrix); //randomowe elementy od 5 do 15
        Zajecia7.displayMatrix(myRandomMatrix2);

        System.out.println("Sum of this matrix: " + sum(myRandomMatrix));
        System.out.println("Avg of this matrix: " + avg(myRandomMatrix));

        System.out.println("Avg matrix: ");
        double[][] resultAvgMatrix = avg(myRandomMatrix, myRandomMatrix2); //nie mam metody do wyswietlenia



    }
    public static double[][] avg(int[][] matrix1, int[][] matrix2) {
        //zwraca macierz z elementami srednimi odpowiednich elementow z macierzy wejsciowych
        double[][] resultMatrix = new double[matrix1.length][matrix1[0].length];

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = ((double)matrix1[i][j] + (double)matrix2[i][j]) / 2;
            }
        }
        return resultMatrix;
    }

    public static double avg(int[][] matrix) {
        //srednia elementow z macierzy

        int sum = sum(matrix);
        int numberOfElements = matrix.length * matrix[0].length;
        return (double)sum/numberOfElements;
    }

    public static int sum(int[][] matrix) {
        //suma elementow macierzy
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] randomMatrix(int size, int bounds, int offset) {
        //zwraca macierz kwadratowa o rozmiarze size i randomowych elementach
        int[][] resultArray = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                resultArray[i][j] = random.nextInt(bounds) + offset;
            }
        }
        return resultArray;
    }

    public static int multiplyDigits(int number) {
        //123 => 1 * 2 * 3 = 6

        int product = 1; //wartosc poczatkowa

        while (number > 0) {
            product = product * (number % 10); //(number % 10) - daje poszczegolne cyfry liczby, potem zmniejszam (dziele) number
            number /= 10;
        }
        return product;
    }

    public static void printStringStatistics(int[] array) {
        //{2, 4, 2, 0, 2, ...} => aabbbbccee

        String result = "";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                result += (char)(i+97);  //dla i=0 to stworzy literke 'a' itd...
            }
        }
        System.out.println(result);
    }

    public static int[] stringStatistics(String message) {
        //aabbbbccee -> {2, 4, 2, 0, 2, ...}
        //zwraca tablice w liczba wystapiec poszczegolnych liter alfabetu

        //moj wariant
        //int[] resultArray = new int[26];

        //robie 27 przejs cpetli, od 0 do 27
        //w kazdym przejsciu dana litera jest reprezentowana przez indeks (i + 97), bo 'a' ma indeks 97 w tablicy scii
        //w kazdej iteracji licze wystapienia danej litery w message i wynik zapisuje w tablicy wynikowej pod indeksem i
        //(char)(i+97) - to moja literka w danej iteracji
        /*
        for (int i = 0; i < resultArray.length; i++) {
            char literka = (char)(i+97);
            literka = toLowerCase(literka);
            resultArray[i] = countAll(message, literka);
        }
        return resultArray;
        */
        //lepszy wariant
        char[] charArray = message.toCharArray();
        int[] ints = new int[26];

        for (int i = 0; i < charArray.length; i++) {
            char charInLowerCase = toLowerCase(charArray[i]);
            if (charInLowerCase >= 97 && charInLowerCase <= 122) {
                ints[charInLowerCase - 97]++;  //dla 'a' ten index wyniesie 0 w tablicy wynikowej
            }
        }
        return ints;
    }

    public static int countAll(String message, char sentence) {
        //Ala ma kota => zwroci liczbe 4  (bez wzgledu na wilkosc liter)

        char[] messageArray = message.toCharArray();
        int counter = 0;

        for (int i = 0; i < messageArray.length; i++) {
            if (toLowerCase(messageArray[i]) == toLowerCase(sentence)) {
                counter++;
            }
        }

        return counter;
    }

    public static char toLowerCase(char a) {
        if (a >= 65 && a <= 90) {
            a += 32;
        }
        return a;
    }

    public static int find(String message, String sentence) {
        //zwraca index pierwszego wystapienia calego slowa w message

        char[] messageArray = message.toCharArray();
        char[] sentenceArray = sentence.toCharArray();

        int i = 0;
        boolean flag = false;

        while (i < messageArray.length && !flag) {
            flag = false;
//            if (messageArray[i] == sentenceArray[0]) {
                int j = 0;
                while (j < sentenceArray.length && messageArray[i+j] == sentenceArray[j]) {
                    if (j == sentenceArray.length -1) {
                        flag = true;
                    }
                    j++;
                }
//            }
            i++;
        }
        return i == messageArray.length ? -1 : i-1;
    }

    public static int find(String message, char sentence) {
        //zwraca index pierwszego wystapienia znaku w message

        char[] charArray = message.toCharArray();
        int i = 0;

        //robimy petle tak dlugo jak nie znajdziemy znaku
        while (i < charArray.length && charArray[i] != sentence) {
            i++;
        }
        //na koniec petli, jesli i bedzie rownie dlugosci tablicy, to znaczy, zenei znalezlismy
        //w przeciwnym razie znalezlismy, pod indexem rownym i
        return (i == charArray.length) ? -1 : i;

    }



}
