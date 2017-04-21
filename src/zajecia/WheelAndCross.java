package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-20.
 */
public class WheelAndCross {

    public static void main(String[] args) {

        char[][] gameBoard = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            boolean inputFromUserFlag = false;
            displayBoard(gameBoard);
            int position = 0;

            while (!inputFromUserFlag) {
                System.out.println("Insert sign position: ");
                position = scanner.nextInt();
                inputFromUserFlag = validatePositionFromUser(position, gameBoard); //tu jest sterownik whilea
                if (!inputFromUserFlag) {
                    System.out.println("Wrong position. Insert again.");
                }
            }

            int[] positions = convertPosition(position);
            //w miejscewybrane przez usera wstawiam kolko lub krzyzyk
            gameBoard[positions[0]][positions[1]] = (i % 2 == 0) ? 'X' : 'O'; //kolko i krzyzyk na zmiane

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        System.out.println("End of game!");
        displayBoard(gameBoard);

    }

    public static boolean validatePositionFromUser(int positionFromUser, char[][] gameBoard) {
        //user moze podac liczbeod 0 do 9, oraz taka, ktora juz nie jest zajeta
        int ints[] = convertPosition(positionFromUser);
        return (positionFromUser > 0 && positionFromUser < 10 &&
                isFieldEmpty(gameBoard, ints[0], ints[1]));
    }

    public static boolean isFieldEmpty(char[][] gameBoard, int i, int j) {
        //te zajete maja juz X lub O w sobie
        return !(gameBoard[i][j] == 'X' || gameBoard[i][j] == 'O');
    }

    public static int[] convertPosition(int positionFromUser) {
        //dla 5 zwroci 1:1
        //dla 4 zwroci 1:0

        int[] position = new int[2];

        position[0] = (positionFromUser - 1) / 3;
        position[1] = (positionFromUser - 1) % 3;

        return position;
    }

    public static void displayBoard(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < gameBoard[0].length - 1) System.out.print("|"); //po ostatniej kolumnie nie dodaje
            }
            if (i != gameBoard.length - 1) { //po ostatnim wierszu nie dodaje
                System.out.print("\n-----\n");
            }
        }
        System.out.println();
    }

}
