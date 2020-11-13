import java.util.Scanner;

public class RecursiveMagicBoard extends MagicBoard {

    public static void main(String[] args) {

        int[][] mBoard = generateMagicBoard(7);

        for (int m = 0; m < 7; m++) {

            for (int z = 0; z < 7; z++) {

                System.out.print(mBoard[m][z] + "\t");

            }
            System.out.println();
        }

        recursiveMagicBoard(mBoard,0,0); //iterative magic board test, arraylist used
    }


    static boolean recursiveMagicBoard(int[][] arr, int h, int w) {

        System.out.println("\nRecursive version of the game\n");

        Scanner sc = new Scanner(System.in);
        int square = arr[h][w];
        int length = arr.length;

        System.out.println("You are on square [" + h + "][" + w + "], the value of this position " +
                "is " + square + ".");

        //we verify how we can advance, and give the user a choice


        if (canGoLeft(square, w, length)) {
            System.out.println("You can move left, to do that press 1");
        }

        if (canGoRight(square, w, length)) {
            System.out.println("You can move right, to do that press 2");
        }
        if (canGoUp(square, h, length)) {
            System.out.println("You can move up, to do that press 3");
        }
        if (canGoSouth(square, h, length)) {
            System.out.println("You can move down, to do that press 4");
        }

        if (!canGoSouth(square, h, length) && !canGoRight(square, w, length) &&
                !canGoLeft(square, w, length) && !canGoUp(square, h, length)) {
            System.out.println("No moves possible");
            return false;
        }
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                w -= square;
                System.out.println("You moved left for " + square + " spaces");
                break;

            case 2:
                w += square;
                System.out.println("You moved right for " + square + " spaces");
                break;



            case 3:
                h -= square;
                System.out.println("You moved up for " + square + " spaces");
                break;

            case 4:
                h += square;
                System.out.println("You moved down for " + square + " spaces");
                break;
        }

        System.out.println("Your new position is [" + h + "][" + w + "].");

        //for loop to show the magic board
        for (int m = 0; m < arr.length; m++) {
            for (int z = 0; z < arr.length; z++) {
                System.out.print(arr[m][z] + "\t");
            }
            System.out.println();
        }


        if (w == arr.length && h == arr.length) {
            System.out.println("You have completed the magic board, congratulations !");
            return true;
        }

        else recursiveMagicBoard(arr, h, w);

        return false;
    }


















}
