import java.util.*;

public class IterativeMagicBoard extends MagicBoard {



    public static void main(String[] args) {

        int[][] mBoard = generateMagicBoard(7);

        for (int m = 0; m < 7; m++) {

            for (int z = 0; z < 7; z++) {

                System.out.print(mBoard[m][z] + "\t");

            }
            System.out.println();

        }

        iterativeMagicBoard(mBoard); //iterative magic board test, arraylist used

        //comment one of these two methods to test the other one

    }

    static boolean iterativeMagicBoard(int[][] arr){

        System.out.println("\nIterative version of the game\n");


        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> width = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            height.add(i);
        }

        for (int i = 0; i < arr.length; i++){
            width.add(i);
        }

        Iterator<Integer> heightIterator = height.iterator();
        Iterator<Integer> widthIterator = width.iterator();

        int w = 0, h = 0;

        while (heightIterator.hasNext() && widthIterator.hasNext()){

            int square = arr[height.get(h)][width.get(w)];

            System.out.println("You are on square [" + height.get(h) + "][" + width.get(w) + "], the value of this position " +
                    "is " + square + ".");

            //we verify how we can advance, and give the user a choice


            if (canGoLeft(square, width.get(w), arr.length)) {
                System.out.println("You can move left, to do that press 1");
            }

            if (canGoRight(square, w, arr.length)) {
                System.out.println("You can move right, to do that press 2");
            }
            if (canGoUp(square, h, arr.length)) {
                System.out.println("You can move up, to do that press 3");
            }
            if (canGoSouth(square, h, arr.length)) {
                System.out.println("You can move down, to do that press 4");
            }

            if (!canGoSouth(square, h, arr.length) && !canGoRight(square, w, arr.length) &&
                    !canGoLeft(square, w, arr.length) && !canGoUp(square, h, arr.length)) {
                System.out.println("No moves possible");
                return false;

            }

            Scanner sc = new Scanner(System.in);

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
        }
        return true;
    }

















}
