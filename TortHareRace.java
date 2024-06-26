/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Mini Project #1
 * 
 * References used for this assignment: 
 * Stack Overflow (only to look up the built in Java Random number method)
 */

import java.util.Random;

public class TortHareRace
{
    public static void main (String [] args)
    {
        // Create a new random number generator
        Random randomNum = new Random();

        // Declare and initialize the tortoise and hare starting positions to 1
        int harePos = 1;
        int tortPos = 1;

        // Signify the start of the race
        System.out.println("\n\nAND THEY\'RE OFF!!");

        // Loop through until the tortoise or the hare crosses the finish line (meaning one reaches or exceeds 50 spaces)
        while (harePos < 50 && tortPos < 50)
        {
            // Generate a random number at the start of each round
            int randInt = randomNum.nextInt(11);

            // Determine the action of the tortoise and the hare depending on that random number
            if (randInt == 1 || randInt == 2)
            {
                tortPos += 3;
                harePos += 9;
            } else if (randInt == 3 || randInt == 4 || randInt == 5)
            {
                tortPos += 3;
                harePos += 1;
            } else if (randInt == 6)
            {
                tortPos += 1;

                // Check if the hare is far enough along to subtract 12 spaces, otherwise reset to starting position of 1
                if (harePos > 12)
                {
                    harePos -= 12; 
                } else 
                {
                    harePos = 1;
                }
            } else if (randInt == 7 || randInt == 8)
            {
                tortPos += 1;

                // Check if the hare is far enough along to subtract 2 spaces, otherwise reset to starting position of 1
                if (harePos > 2)
                {
                    harePos -= 2;
                } else 
                {
                    harePos = 1;
                }
            } else if (randInt == 9 || randInt == 10)
            {
                // Check if the tortoise is far enough along to subtract 6 spaces, otherwise reset to starting position of 1
                if (tortPos > 7)
                {
                    tortPos -= 6; 
                } else 
                {
                    tortPos = 1;
                }
            }

            // Call the printRoundOutcome method to print the race positions for that round
            printRoundOutcome(harePos, tortPos);

        }

        // Call the printWinner method to display the corresponding winner
        printWinner(harePos, tortPos);
    }

    public static void printRoundOutcome(int harePos, int tortPos)
    {
        // Initially set end to 50 because that is the end of the race
        int end = 50;

        // However, if end is greater than 50 because a participant passed the finish, have that position be the new end.
        // This is needed to display the final positions correctly. 
        if (harePos >= 50)
        {
            end = harePos + 1;
        } else if (tortPos >= 50)
        {
            end = tortPos + 1;
        }

        // Loop through the race and print out where the tortoise and the hare are located for this round
        for (int i = 1; i < end; i++){
            if (tortPos == harePos && i == tortPos){
                System.out.print("OUCH!!");
                break;
            } else if (i == tortPos){
                System.out.print("T");
            } else if (i == harePos){
                System.out.print("H");
            } else {
                System.out.print(" ");
            }
        }

        // Print a new line so the next round is its own line
        System.out.println();
    }

    public static void printWinner(int harePos, int tortPos)
    {
        // Print out the winner depending on the final positions of the tortoise and the hare
        if (harePos == tortPos){
            System.out.println("IT\'S A TIE!!\n\n");
        } else if (harePos > tortPos)
        {
            System.out.println("HARE WINS!!\n\n");
        } else if (tortPos > harePos)
        {
            System.out.println("TORTOISE WINS!!\n\n");
        }
    }
}