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

        int result3 = find("Ala ma kota", "kota");
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

//        System.out.println("Avg matrix: ");
//        double[][] resultAvgMatrix = avg(myRandomMatrix, myRandomMatrix2); //nie mam metody do wyswietlenia

        int number = 73;
        System.out.println("binary reprezentation of " + number + ": " + toBinary(number));

        String binaryNumber = "1111000"; //73
        System.out.println("Decimal representation of " + binaryNumber + ": " + toNumber(binaryNumber));

        String exp = "((2+2)*2)";
        System.out.println("Check round brackets of " + exp + ": " + checkRoundBrackets(exp));
        exp = "(2+2)*2)";
        System.out.println("Check round brackets of " + exp + ": " + checkRoundBrackets(exp));
        exp = ")(2+2)*2";
        System.out.println("Check round brackets of " + exp + ": " + checkRoundBrackets(exp));
        exp = ")2+2)*2(";
        System.out.println("Check round brackets of " + exp + ": " + checkRoundBrackets(exp));

        int result4 = find("Ala ma kota", "kota");
        System.out.println("word position: " + result4);

        int result4a = find("Ala ma kota", "ma");
        System.out.println("word position: " + result4a);

        int result5 = find("Ala ma kot", "kota");
        System.out.println("word position: " + result5);

        int wordCount = countAll("Ala ma kota i ma tez psa.", "ma");
        System.out.println("Count of words in sentence: " + wordCount);


    }

    public static int[] rgbToValues(String rgb) {
        //#FF0050 -> {255, 0, 80}
        //0 = 0, 1 = 1, 2 = 2, 3 = 3, 4 = 4, 5 = 5, 6 = 6, 7 = 7, 8 = 8, 9 = 9, A = 10, B = 11, C = 12, D = 13, E = 14, F = 15

//        7DE = (7 * 16^2) + (13 * 16^1) + (14 * 16^0)
//        7DE = (7 * 256) + (13 * 16) + (14 * 1)
//        7DE = 1792 + 208 + 14
//        7DE = 2014 (in decimal number)

//        FF = (15 * 16^1) + (15 * 16^0) = 240 + 15 = 255
//        00 = (0 * 16^1) + (0 * 16^0) = 0 + 0 = 0
//        50 = (5 * 15^1) + (0 * 16^0) =  80 + 0 = 80

        return null;
    }

    public static boolean checkRoundBrackets(String expression) {
        //(2+2)*2) -> false
        //((2+2)*2) -> true
        //)(2+2)*2 -> false
        //)2+2)*2( -> false
        //czy po kazdym otwartym nawiasie wystepuje zamkniety nawias

        //mam counter = 0. Przechodze po expression. Jesli mam nawiasotwierajacy to inkrementuje counter, jesli zamykajacy
        //to dekrementuje. Jesliw pewnym momencie counter zejdzieponizejzera, to od razu moge zwrocic false (bo wtedy nawiasow zamykajacych
        // bedziewiecej od otwieracjacych). Jesli po zakonczeniupetli counter bedzie wiekszy od zero to zwracam tez false (wtedy
        //nawiasow otwierajacychjest wiecej. True zwracam tylko wtedy kiedy counter = 0

        char[] charArray = expression.toCharArray();
        int counter = 0;
        int i = 0;

        while (i < charArray.length && counter >= 0) {
            if (charArray[i] == '(') {
                counter++;
            }
            if (charArray[i] == ')') {
                counter--;
            }
            i++;
        }

        return counter == 0;

    }

    public static int toNumber(String binaryCode) {
        //zamienic stringa na tablice charow
        //przejsc w petli
        //jesli znak = 1 to wtedy to ogolnej sumy dodac 2 do potegi (array.lenght - 1 - i) (bo pierwszy element to element z najwyzsza potega)
        char[] charArray = binaryCode.toCharArray();
        int result = 0; //koncowy wynik

        for (int i = 0; i < charArray.length; i++) { //przebiegam po tablicy
            int internalSum = 0; //czastkowa suma do dodania
            if (charArray[i] == '1') {
                internalSum = 1; //jesli mam jedynke, to czastkowa suma bedzie co najmniej jeden, a konkretnie będzie równa 2 do potęgi (array.lenght - 1 - i)
                //a wiec tyle wlasnie razy musze przemnozyc czastkowa sume przez 2
                for (int j = 0; j < (charArray.length - 1 - i); j++) {
                    internalSum = internalSum * 2;
                }
            }
            //na koniec iteracji dodaje czastkowa sume do globalnego wyniku
            result += internalSum;
        }
        return result;
    }

    public static String toBinary(int number) {
        //w petli dziele number przez 2 i pod number podstawiam calkowity wynik z dzielenia
        //kolejne reszty w dzielenia, zapisane od tylu, tworza binarna reprezentacje number
        String resultString = "";

        while (number > 0) {
            resultString += number % 2;
            number /= 2;
        }

        //zamieniam na tablice char-ow
        char[] charArray = resultString.toCharArray();

        //zamieniam kolejnosc elementow
        char[] tmpArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            tmpArray[charArray.length -1 - i] = (char)charArray[i];
        }

        //z powrotem na string
        resultString = String.valueOf(tmpArray);

        return resultString;
    }

    public static double[][] avg(int[][] matrix1, int[][] matrix2) {
        //zwraca macierz z elementami srednimi odpowiednich elementow z dwoch macierzy wejsciowych
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
        //zwraca macierz kwadratowa o rozmiarze numberOfBooks i randomowych elementach
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
            product = product * (number % 10); //(number % 10) - daje poszczegolne cyfry liczby, ktore dzieki temu moge przez siebie wymnazac
            number /= 10;   //potem zmniejszam (dziele) number i biore calkowita czesc, by w kolejnej iteracji dobrac sie do kolejnej (zawsze ostatniej) cyfry
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
        //zwraca tablice w liczba wystapien poszczegolnych liter alfabetu

        //moj wariant
        //int[] resultArray = new int[26];

        //robie 26 przejs cpetli
        //w kazdym przejsciu dana litera jest reprezentowana przez indeks (i + 97), bo 'a' ma indeks 97 w tablicy ascii
        //w kazdej iteracji licze wystapienia danej litery w message i wynik zapisuje w tablicy wynikowej pod indeksem "i"
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
        //tutaj przebiegam po tablicy wejsciowej i jesli dany znak (wczesniej zamieniony na maly znak) jest literka, to wtedy w tablicy wynikowej
        //podbijam element o odpowiednim indeksie w tablicy wynikowej
        //ten wariant jest lepszy, bo nie korzystam z dodatkowej metody countAll, ktora ma w sobie petle, czyli w efekcie nie robie dwoch petli, tylko te jedną
        char[] messageArray = message.toCharArray();
        int[] resultArray = new int[26];

        for (int i = 0; i < messageArray.length; i++) {
            char charInLowerCase = toLowerCase(messageArray[i]);
            if (charInLowerCase >= 97 && charInLowerCase <= 122) {
                resultArray[charInLowerCase - 97]++;  //dla 'a' ten index wyniesie 0 w tablicy wynikowej, dla 'b' indeks bedzie 1, itd...
            }
        }
        return resultArray;
    }

    public static int countAll(String message, String sentence) {
        //Ala ma kota i ma tez psa;  ma -> 2
        int counter = 0; //licznik

        while (find(message, sentence) != -1) { //szukam słowa w message, jak znajde to podbijam licznik i ucinam message,
                                                // zeby moc szukac dalej pierwszego (kolejnego) wystapienia slowa w message
            counter++;
            message = message.substring(find(message, sentence) +1);
        }
        return counter;
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
        //zamienia duze litery na male
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

        //przechodze w petli przez messageArray tak dlugo dopoki nie wyjde poza zakres i dopoki flaga = false
        //to odejmowanie znaczy, ze jesli zostalo mi do sprawdzenia mniej znakow niż ma szukane slowo
        //czyli np. zostały mi 3 znaki do sprawdzenia, ale szukanywyraz ma 4 znaki
        //to dalsze wyszukiwanie nie ma sensu
        while (!flag && i <= (messageArray.length - sentenceArray.length) ) {
            flag = false;

                //w podpetli przebiegam po znakach z szukanego sentence, musze uwazac, zeby nie wyjsc poza zakres sentence
                //w podpetli sprawdzam, czy kolejne (dalsze niż i) znaki z message są takie same jak kolejne znaki z sentence
                //jeśli są, to podpetla działą i zwiększa j - czyli sprawdzam po kolei kazdy znak z sentence
                //jesli uda mi sie dojsc z wielkością j do (dlugosc sentence - 1), to znaczy, ze fraza sentence zostala znaleziona i mozna ustawic flage na true
                //ustawienie flagi na true powoduje przerwanie obydwu petli, wartosc gotowa do zwrocenia to (i-1), poniewaz (i-1) symbolizuje indeks pierwszej literki z sentence w message
                //minus jeden bierze sie stad, ze po przerwaniu wewnetrznej petli musi sie jeszcze dokonczyc ostatni przebieg zewnetrznej petli, gdzie nastepuje i++
                //stad przy returnie musze to odjac
                int j = 0;
                while (j < sentenceArray.length && messageArray[i+j] == sentenceArray[j]) {
                    j++;
                    if (j == sentenceArray.length) {
                        flag = true;
                    }

                }
            i++;
        }
        return flag ? i-1 : -1;
        //return i == messageArray.length ? -1 : i-1; //jesli doszedlem ze zmienna i do konca, to znaczy, ze nie odnalazlem frazy
    }

    public static int find(String message, char sentence) {
        //zwraca index pierwszego wystapienia znaku w message

        char[] charArray = message.toCharArray();
        int i = 0;

        //robimy petle tak dlugo jak nie znajdziemy znaku i tak dlugo az nei wyjdziemy poza zakres tablicy
        //sprawdzanie rownosci znakow robie w warunku petli, a w jej ciele wystarczy, ze podbijam i
        while (i < charArray.length && charArray[i] != sentence) {
            i++;
        }
        //na koniec petli, jesli i bedzie rownie dlugosci tablicy, to znaczy, ze nei znalezlismy szukanego znaku
        //w przeciwnym razie znalezlismy, pod indexem rownym i
        return (i == charArray.length) ? -1 : i;
    }



}
