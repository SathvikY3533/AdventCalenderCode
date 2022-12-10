import java.util.*;
import java.io.*;

//A for Rock, B for Paper, and C for Scissors
//X for Rock, Y for Paper, and Z for Scissors
//1 for Rock, 2 for Paper, and 3 for Scissors
//0 if you lost, 3 if the round was a draw, and 6 if you won
//X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win



public class Day2 {
    public static void main(String[] args) {
        Scanner scan = null;
        int totalScore = 0;
        try {
            scan = new Scanner(new File("day2.txt"));
            while(scan.hasNextLine()) {
                String p1 = scan.next();
                String p2 = scan.next();


                if(p1.equals("A") && p2.equals("Y")) {
                    totalScore += 4;
                } else if(p1.equals("A") && p2.equals("Z")) {
                    totalScore += 8;
                } else if(p1.equals("A") && p2.equals("X")) {
                    totalScore += 3;
                }

                if(p1.equals("B") && p2.equals("X")) {
                    totalScore += 1;
                } else if(p1.equals("B") && p2.equals("Y")) {
                    totalScore += 5;
                } else if(p1.equals("B") && p2.equals("Z")) {
                    totalScore += 9;
                }

                if(p1.equals("C") && p2.equals("Z")) {
                    totalScore += 7;
                } else if(p1.equals("C") && p2.equals("X")) {
                    totalScore += 2;
                } else if(p1.equals("C") && p2.equals("Y")) {
                    totalScore += 6;
                }
            }

        } catch(IOException e) {
            System.out.println("File not Found!");
        }

        System.out.println(totalScore);

    }
}
